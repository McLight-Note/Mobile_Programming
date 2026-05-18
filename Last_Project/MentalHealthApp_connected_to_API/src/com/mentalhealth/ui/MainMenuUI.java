package com.mentalhealth.ui;

import com.mentalhealth.chatbot.CounselingChatbot;
import com.mentalhealth.meditation.MeditationTimer;
import com.mentalhealth.mood.MoodTracker;

import java.util.Scanner;

/**
 * Main menu — ties together the three core features.
 */
public class MainMenuUI {

    private final Scanner scanner;
    private final MoodTracker     moodTracker;
    private final MeditationTimer meditationTimer;
    private final CounselingChatbot chatbot;

    public MainMenuUI() {
        this.scanner         = new Scanner(System.in);
        this.moodTracker     = new MoodTracker(scanner);
        this.meditationTimer = new MeditationTimer(scanner);
        this.chatbot         = new CounselingChatbot(scanner);
    }

    /** Application main loop. */
    public void start() {
        printWelcomeBanner();

        boolean running = true;
        while (running) {
            printMenu();
            System.out.print("Your choice: ");
            String input = scanner.nextLine().trim();

            switch (input) {
                case "1" -> moodTracker.show();
                case "2" -> meditationTimer.show();
                case "3" -> chatbot.show();
                case "4" -> printAbout();
                case "0" -> {
                    running = false;
                    printGoodbye();
                }
                default  -> System.out.println("Please enter a number from the menu (0-4).");
            }
        }

        scanner.close();
    }

    // ------------------------------------------------------------------ //

    private void printWelcomeBanner() {
        System.out.println();
        System.out.println("*".repeat(50));
        System.out.println("*                                              *");
        System.out.println("*      MENTAL HEALTH SUPPORT APPLICATION      *");
        System.out.println("*            Your safe space to heal           *");
        System.out.println("*                                              *");
        System.out.println("*".repeat(50));
        System.out.println();
        System.out.println("  This app provides tools for self-care:");
        System.out.println("  - Track your mood over time");
        System.out.println("  - Guided meditation sessions");
        System.out.println("  - An AI counseling chatbot");
        System.out.println();
        System.out.println("  NOTE: This app is not a replacement for");
        System.out.println("  professional mental health care.");
        System.out.println();
    }

    private void printMenu() {
        System.out.println();
        System.out.println("======= MAIN MENU =======");
        System.out.println("  1.  Mood Tracker       \uD83D\uDCC8");
        System.out.println("  2.  Meditation Timer   \uD83E\uDDD8");
        System.out.println("  3.  AI Counselor       \uD83D\uDCAC");
        System.out.println("  4.  About This App     \u2139\uFE0F");
        System.out.println("  0.  Exit");
        System.out.println("=========================");
    }

    private void printAbout() {
        System.out.println();
        System.out.println("--- About Mental Health Support App ---");
        System.out.println();
        System.out.println("  Version  : 1.0.0");
        System.out.println("  Language : Java");
        System.out.println("  Purpose  : Final Project — Mental Health App");
        System.out.println();
        System.out.println("  Features:");
        System.out.println("    1. Mood Tracker     — Log and review your daily mood.");
        System.out.println("    2. Meditation Timer — Guided sessions from 2 to 15 min.");
        System.out.println("    3. AI Chatbot       — Talk through what's on your mind.");
        System.out.println();
        System.out.println("  Crisis Resources:");
        System.out.println("    Korea:         1393 (free, 24/7)");
        System.out.println("    International: https://www.iasp.info/resources/Crisis_Centres/");
        System.out.println();
    }

    private void printGoodbye() {
        System.out.println();
        System.out.println("  Take care of yourself. You matter. 💙");
        System.out.println("  Goodbye!");
        System.out.println();
    }
}
