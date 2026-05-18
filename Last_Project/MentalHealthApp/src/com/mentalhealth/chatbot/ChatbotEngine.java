package com.mentalhealth.chatbot;

import java.util.*;

/**
 * AI Counseling Chatbot engine.
 *
 * Uses a keyword-response map to simulate empathetic counseling.
 * In a real app this would call an external AI API; for the
 * final project this rule-based approach demonstrates the pattern.
 */
public class ChatbotEngine {

    // Each entry: keywords → list of possible responses (one is picked randomly)
    private final Map<String[], List<String>> responseMap = new LinkedHashMap<>();
    private final Random random = new Random();

    // Remember the last detected theme so follow-up replies feel connected
    private String lastTheme = "general";

    public ChatbotEngine() {
        buildResponseMap();
    }

    // ------------------------------------------------------------------ //

    /** Return a response string for user input. */
    public String respond(String input) {
        if (input == null || input.isBlank()) {
            return "I'm here. Take your time and share whatever is on your mind.";
        }

        String lower = input.toLowerCase();

        // Check for crisis keywords first — highest priority
        if (containsAny(lower, "suicide", "kill myself", "end my life",
                "want to die", "not worth living")) {
            return crisisResponse();
        }

        // Match against keyword groups
        for (Map.Entry<String[], List<String>> entry : responseMap.entrySet()) {
            if (containsAny(lower, entry.getKey())) {
                lastTheme = entry.getKey()[0]; // track theme
                return pick(entry.getValue());
            }
        }

        // Contextual follow-up if no match
        return followUp(lower);
    }

    // ------------------------------------------------------------------ //

    private void buildResponseMap() {

        add(arr("anxious", "anxiety", "nervous", "panic", "stress", "stressed", "worried", "worry"),
                "It sounds like you're carrying a lot of worry right now. That's exhausting. " +
                "Can you tell me what's weighing on you most?",

                "Anxiety can feel overwhelming. Try this: breathe in for 4 counts, hold for 4, " +
                "breathe out for 4. Repeat three times. Then let's talk about what's going on.",

                "You're not alone — many people feel this way. What situation is triggering " +
                "these feelings for you?");

        add(arr("sad", "depressed", "depression", "unhappy", "miserable", "down", "low"),
                "I'm really sorry you're feeling this way. Sadness can be heavy to carry. " +
                "Would you like to talk about what's been happening?",

                "Thank you for sharing that with me. Feeling low is valid — you don't have to " +
                "explain it or fix it right now. I'm here to listen.",

                "Sometimes just naming what we feel is the first step. You said you're feeling " +
                "sad — is this something that's been building up, or did something specific happen?");

        add(arr("angry", "anger", "furious", "frustrated", "mad", "rage"),
                "Anger is a real signal that something important to you has been threatened. " +
                "What happened to make you feel this way?",

                "I hear you — you're frustrated. That's completely valid. " +
                "Let's try to unpack where this feeling is coming from.",

                "It's okay to be angry. The key is understanding it. Can you describe " +
                "what triggered these feelings today?");

        add(arr("lonely", "alone", "isolated", "no friends", "nobody cares"),
                "Loneliness is one of the hardest feelings to sit with. I want you to know " +
                "that talking here is a step, and you don't have to face this alone.",

                "Feeling disconnected from others is really painful. Have there been times " +
                "recently when you did feel some connection, even briefly?",

                "You reached out — that matters. Tell me more about what your daily social " +
                "life looks like right now.");

        add(arr("sleep", "insomnia", "can't sleep", "tired", "exhausted", "fatigue"),
                "Sleep and mental health are deeply connected. Poor sleep makes everything " +
                "harder to cope with. How long has this been affecting you?",

                "Exhaustion wears us down in ways we don't always notice. Are you struggling " +
                "to fall asleep, staying asleep, or waking up too early?",

                "Try winding down with 10 minutes of calm breathing before bed. Would you " +
                "like to try a meditation session from this app to help you relax?");

        add(arr("work", "job", "boss", "career", "coworker", "office", "school", "study", "exam"),
                "Work and academic pressure can be a huge source of stress. What's the " +
                "biggest challenge you're dealing with there right now?",

                "Balancing responsibilities is really tough. It sounds like things feel " +
                "overwhelming — let's break it down. What feels most urgent to you?",

                "Many people struggle with this. Remember: your value as a person is not " +
                "defined by your productivity. What would help you most right now?");

        add(arr("relationship", "partner", "boyfriend", "girlfriend", "breakup", "divorce",
                "family", "parents", "friend", "friendship"),
                "Relationships shape so much of how we feel. It sounds like there's some " +
                "tension there. Would you like to talk through what's happening?",

                "Interpersonal pain can be really deep. I'm here to listen without judgment. " +
                "What's going on?",

                "Navigating relationships is one of life's hardest skills. What do you " +
                "feel is at the core of this situation?");

        add(arr("happy", "good", "great", "wonderful", "excited", "joy", "grateful"),
                "That's really wonderful to hear! What's been going well for you?",

                "It's great that you're feeling positive! Acknowledging good moments is " +
                "an important mental health practice. What contributed to this feeling?",

                "Hold on to that feeling! Is there anything you want to do to build on it?");

        add(arr("help", "advice", "what should i do", "don't know what to do"),
                "I'm here to help you think through things. Tell me more about the situation " +
                "and we'll work through it together.",

                "Let's figure this out together. What's the main problem you're facing?",

                "Sometimes just talking it out helps us find clarity. Start wherever feels " +
                "comfortable — what's going on?");

        add(arr("thank", "thanks", "thank you"),
                "You're very welcome. Remember — reaching out is a sign of strength, not weakness.",
                "I'm glad I could be here. How are you feeling now compared to when we started?",
                "Anytime. Take care of yourself. You deserve support.");
    }

    // ------------------------------------------------------------------ //

    private String followUp(String input) {
        // Try to give a contextual reply based on sentence length / content
        if (input.length() < 10) {
            return "Tell me more. I'm listening.";
        }

        List<String> generic = List.of(
                "That sounds really significant. Can you tell me more?",
                "I hear you. How long have you been feeling this way?",
                "Thank you for sharing that. What do you think is at the root of this?",
                "I appreciate you opening up. How has this been affecting your daily life?",
                "That must be difficult. What kind of support do you feel you need most right now?",
                "You're being very reflective — that's a real strength. What would feel helpful to explore?",
                "I'm here with you. What would you like to focus on today?"
        );
        return pick(generic);
    }

    private String crisisResponse() {
        return """
                I'm really concerned about what you've just shared. \
                Please know that you are not alone and your life has value.
                
                If you are in immediate danger, please contact:
                  - Emergency services: 119 (Korea) / 911 (US)
                  - Korea Crisis Helpline: 1393 (24/7, free)
                  - International Association for Suicide Prevention: https://www.iasp.info/resources/Crisis_Centres/
                
                Would you be willing to reach out to one of these right now? \
                I'm here with you.""";
    }

    // ------------------------------------------------------------------ //

    private void add(String[] keys, String... responses) {
        responseMap.put(keys, new ArrayList<>(Arrays.asList(responses)));
    }

    private static String[] arr(String... items) { return items; }

    private String pick(List<String> list) {
        return list.get(random.nextInt(list.size()));
    }

    private boolean containsAny(String text, String... keywords) {
        for (String kw : keywords) {
            if (text.contains(kw)) return true;
        }
        return false;
    }
}
