package com.mentalhealth.meditation;

import java.util.Scanner;

/**
 * Guided meditation timer with multiple session types.
 * Uses Thread.sleep() to count down the timer in real time.
 */
public class MeditationTimer {

    /** Predefined meditation sessions. */
    public enum Session {
        BREATHING(   "Breathing Exercise",      2,
                "Focus only on your breath. Inhale for 4 seconds, hold for 4, exhale for 4."),
        BODY_SCAN(   "Body Scan Relaxation",     5,
                "Close your eyes. Slowly scan from the top of your head to your toes."),
        MINDFULNESS( "Mindfulness Meditation",  10,
                "Observe your thoughts without judgment. Let them pass like clouds."),
        DEEP_FOCUS(  "Deep Focus Session",      15,
                "Clear your mind completely. Return to this moment whenever you drift."),
        CUSTOM(      "Custom Duration",          0,
                "Set your own duration.");

        final String name;
        final int defaultMinutes;
        final String guidance;

        Session(String name, int defaultMinutes, String guidance) {
            this.name           = name;
            this.defaultMinutes = defaultMinutes;
            this.guidance       = guidance;
        }
    }

    private final Scanner scanner;

    public MeditationTimer(Scanner scanner) {
        this.scanner = scanner;
    }

    /** Main entry point — shows the meditation sub-menu. */
    public void show() {
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("--- Meditation Timer ---");
            System.out.println("Choose a session:");
            Session[] sessions = Session.values();
            for (int i = 0; i < sessions.length; i++) {
                Session s = sessions[i];
                String dur = s == Session.CUSTOM
                        ? "(you choose)"
                        : s.defaultMinutes + " min";
                System.out.printf("  %d. %-28s [%s]%n", i + 1, s.name, dur);
            }
            System.out.println("  0. Back to main menu");
            System.out.print("Choose: ");

            String input = scanner.nextLine().trim();
            if (input.equals("0")) {
                running = false;
                continue;
            }

            int choice;
            try {
                choice = Integer.parseInt(input) - 1;
                if (choice < 0 || choice >= sessions.length) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid option.");
                continue;
            }

            Session chosen = sessions[choice];
            int minutes    = chosen.defaultMinutes;

            if (chosen == Session.CUSTOM) {
                System.out.print("Enter duration in minutes (1-60): ");
                try {
                    minutes = Integer.parseInt(scanner.nextLine().trim());
                    if (minutes < 1 || minutes > 60) throw new NumberFormatException();
                } catch (NumberFormatException e) {
                    System.out.println("Invalid duration.");
                    continue;
                }
            }

            runTimer(chosen, minutes);
        }
    }

    // ------------------------------------------------------------------ //

    private void runTimer(Session session, int minutes) {
        int totalSeconds = minutes * 60;

        System.out.println();
        System.out.println("=".repeat(50));
        System.out.println("  " + session.name);
        System.out.println("  Duration: " + minutes + " minute" + (minutes > 1 ? "s" : ""));
        System.out.println("=".repeat(50));
        System.out.println();
        System.out.println("  " + session.guidance);
        System.out.println();
        System.out.println("  Starting in 3 seconds... Find a comfortable position.");
        System.out.println("  (Press Ctrl+C to stop early)");
        System.out.println();

        sleep(3000);

        System.out.println("  Begin. \uD83E\uDDD8");
        System.out.println();

        // Countdown loop — prints remaining time every 30 seconds
        int nextMilestone = totalSeconds; // first print at start
        for (int remaining = totalSeconds; remaining > 0; remaining--) {
            if (remaining == nextMilestone || remaining % 30 == 0 || remaining <= 10) {
                String timeStr = formatTime(remaining);
                System.out.printf("  \u23F1  %s remaining%n", timeStr);
                nextMilestone = -1; // only fire the "at start" print once
            }
            sleep(1000);
        }

        System.out.println();
        System.out.println("  \uD83D\uDD14  Session complete!  Great job.");
        System.out.println("  Take a moment to notice how you feel before moving on.");
        System.out.println();
    }

    private static String formatTime(int totalSeconds) {
        int m = totalSeconds / 60;
        int s = totalSeconds % 60;
        if (m > 0) {
            return String.format("%d:%02d", m, s);
        }
        return String.format("%d sec", s);
    }

    private static void sleep(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
