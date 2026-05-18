package com.mentalhealth.chatbot;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Manages the counseling chatbot conversation session.
 * Holds conversation history and delegates responses to ChatbotEngine.
 */
public class CounselingChatbot {

    private static final String BOT_NAME = "Serenity";

    private final Scanner scanner;
    private final ChatbotEngine engine;
    private final List<String> history; // alternating user/bot messages

    public CounselingChatbot(Scanner scanner) {
        this.scanner = scanner;
        this.engine  = new ChatbotEngine();
        this.history = new ArrayList<>();
    }

    /** Main entry point — starts the chat session loop. */
    public void show() {
        System.out.println();
        System.out.println("=".repeat(55));
        System.out.printf("  %s — Your AI Wellness Companion%n", BOT_NAME);
        System.out.println("=".repeat(55));
        System.out.println();
        System.out.printf("  %s: Hi, I'm %s. I'm here to listen and support you.%n",
                BOT_NAME, BOT_NAME);
        System.out.printf("  %s: What's on your mind today?%n", BOT_NAME);
        System.out.println();
        System.out.println("  (Type 'history' to review our conversation,");
        System.out.println("   type 'quit' or '0' to return to the main menu)");
        System.out.println();

        while (true) {
            System.out.print("  You: ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("quit") ||
                input.equalsIgnoreCase("0")    ||
                input.equalsIgnoreCase("exit")) {
                printClosingMessage();
                break;
            }

            if (input.equalsIgnoreCase("history")) {
                printHistory();
                continue;
            }

            if (input.isEmpty()) {
                System.out.printf("  %s: Take your time. I'm right here.%n", BOT_NAME);
                continue;
            }

            // Save user message
            history.add("You: " + input);

            // Get and display bot response
            String response = engine.respond(input);
            System.out.println();
            System.out.printf("  %s: %s%n", BOT_NAME, wrapText(response, 70));
            System.out.println();

            // Save bot message
            history.add(BOT_NAME + ": " + response);
        }
    }

    // ------------------------------------------------------------------ //

    private void printHistory() {
        System.out.println();
        System.out.println("--- Conversation History ---");
        if (history.isEmpty()) {
            System.out.println("  No messages yet.");
        } else {
            for (String line : history) {
                System.out.println("  " + line);
            }
        }
        System.out.println();
    }

    private void printClosingMessage() {
        System.out.println();
        System.out.printf("  %s: It was good talking with you. Remember to be gentle with yourself.%n",
                BOT_NAME);
        System.out.printf("  %s: Take care, and come back anytime you need to talk. 💙%n", BOT_NAME);
        System.out.println();
    }

    /**
     * Simple word-wrap that inserts newlines + indentation so long bot
     * responses don't overflow a typical terminal window.
     */
    private static String wrapText(String text, int maxWidth) {
        if (text.length() <= maxWidth) return text;

        StringBuilder sb   = new StringBuilder();
        String indent      = "         "; // aligns with bot name prefix
        String[] words     = text.split(" ");
        int lineLen        = 0;

        for (String word : words) {
            if (lineLen + word.length() + 1 > maxWidth) {
                sb.append("\n").append(indent);
                lineLen = 0;
            }
            if (lineLen > 0) {
                sb.append(' ');
                lineLen++;
            }
            sb.append(word);
            lineLen += word.length();
        }
        return sb.toString();
    }
}
