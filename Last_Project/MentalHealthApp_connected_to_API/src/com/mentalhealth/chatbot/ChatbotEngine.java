package com.mentalhealth.chatbot;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

public class ChatbotEngine {
    private static final String API_KEY_ENV  = "GROQ_API_KEY";
    private static final String API_KEY_HARD = "";

    private static final String MODEL   = "llama-3.3-70b-versatile";
    private static final String API_URL = "https://api.groq.com/openai/v1/chat/completions";

    private static final String SYSTEM_PROMPT =
            "You are Serenity, a compassionate AI mental health companion inside a wellness app. " +
            "Listen actively, respond with warmth, ask thoughtful follow-up questions, " +
            "offer gentle evidence-based coping tips when appropriate, and validate feelings " +
            "without judgment. Keep replies concise (2-4 sentences) — this is a chat interface. " +
            "If the user expresses suicidal ideation or crisis, always share: " +
            "Korea crisis line: 1393 (free, 24/7) | International: https://www.iasp.info/resources/Crisis_Centres/ " +
            "You are NOT a replacement for professional therapy. Never diagnose or recommend medication.";
    private final HttpClient     httpClient;
    private final List<String[]> history;
    private final String         apiKey;

    public ChatbotEngine() {
        this.httpClient = HttpClient.newHttpClient();
        this.history    = new ArrayList<>();
        this.apiKey     = resolveApiKey();
    }
    public String respond(String userMessage) {
        if (apiKey == null || apiKey.isBlank()) {
            return "No API key found.\n" +
                   "Set the GROQ_API_KEY environment variable and restart.\n" +
                   "Get your free key at: https://console.groq.com/";
        }

        history.add(new String[]{"user", userMessage});

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(API_URL))
                    .header("Content-Type",  "application/json")
                    .header("Authorization", "Bearer " + apiKey)
                    .POST(HttpRequest.BodyPublishers.ofString(buildBody()))
                    .build();

            HttpResponse<String> resp =
                    httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            if (resp.statusCode() != 200) {
                history.remove(history.size() - 1);
                return apiError(resp.statusCode(), resp.body());
            }

            String reply = parseText(resp.body());
            history.add(new String[]{"assistant", reply});
            return reply;

        } catch (java.net.ConnectException e) {
            history.remove(history.size() - 1);
            return "No internet connection. Please check your network and try again.";
        } catch (Exception e) {
            history.remove(history.size() - 1);
            return "Something went wrong: " + e.getMessage();
        }
    }

    public void resetHistory() {
        history.clear();
    }

    private String buildBody() {
        StringBuilder messages = new StringBuilder("[");
        messages.append("{\"role\":\"system\",\"content\":\"").append(esc(SYSTEM_PROMPT)).append("\"}");
        for (String[] turn : history) {
            messages.append(",{\"role\":\"").append(turn[0])
                    .append("\",\"content\":\"").append(esc(turn[1])).append("\"}");
        }
        messages.append("]");

        return "{\"model\":\"" + MODEL + "\",\"messages\":" + messages + "}";
    }

    private String parseText(String json) {
        String key = "\"content\":\"";
        int s = json.indexOf(key);
        if (s == -1) return "I'm here. Tell me more.";
        s += key.length();

        StringBuilder sb = new StringBuilder();
        int i = s;
        while (i < json.length()) {
            char c = json.charAt(i);
            if (c == '\\' && i + 1 < json.length()) {
                char n = json.charAt(i + 1);
                if      (n == '"')  { sb.append('"');  i += 2; continue; }
                else if (n == 'n')  { sb.append('\n'); i += 2; continue; }
                else if (n == 't')  { sb.append('\t'); i += 2; continue; }
                else if (n == '\\') { sb.append('\\'); i += 2; continue; }
                else                { sb.append(c);    i++;    continue; }
            }
            if (c == '"') break;
            sb.append(c);
            i++;
        }
        return sb.toString().trim();
    }
    
    private String resolveApiKey() {
        String env = System.getenv(API_KEY_ENV);
        if (env != null && !env.isBlank()) return env.trim();
        if (!API_KEY_HARD.isBlank())       return API_KEY_HARD.trim();
        return null;
    }

    private String apiError(int status, String body) {
        return switch (status) {
            case 400 -> "Bad request (400). The message may contain unsupported content.";
            case 401 -> "Invalid API key (401). Double-check your GROQ_API_KEY.";
            case 429 -> "Rate limit hit (429). Wait a moment and try again.";
            case 503 -> "Groq API is temporarily unavailable (503). Try again shortly.";
            default  -> "API error " + status + ": " +
                        body.substring(0, Math.min(body.length(), 150));
        };
    }

    private static String esc(String s) {
        return s.replace("\\", "\\\\")
                .replace("\"", "\\\"")
                .replace("\n", "\\n")
                .replace("\r", "\\r")
                .replace("\t", "\\t");
    }
}
