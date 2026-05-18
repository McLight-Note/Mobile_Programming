package com.mentalhealth.mood;

import com.mentalhealth.data.MoodEntry;
import com.mentalhealth.data.MoodEntry.MoodLevel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Handles all mood tracking logic:
 *   - Log a new mood entry
 *   - View mood history
 *   - Show weekly mood summary
 */
public class MoodTracker {

    private final List<MoodEntry> entries = new ArrayList<>();
    private final Scanner scanner;

    public MoodTracker(Scanner scanner) {
        this.scanner = scanner;
    }

    /** Main entry point — shows the mood tracker sub-menu. */
    public void show() {
        boolean running = true;
        while (running) {
            System.out.println();
            System.out.println("--- Mood Tracker ---");
            System.out.println("1. Log my mood");
            System.out.println("2. View mood history");
            System.out.println("3. Mood summary / stats");
            System.out.println("0. Back to main menu");
            System.out.print("Choose: ");

            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1" -> logMood();
                case "2" -> viewHistory();
                case "3" -> showSummary();
                case "0" -> running = false;
                default  -> System.out.println("Please enter 0-3.");
            }
        }
    }

    // ------------------------------------------------------------------ //

    private void logMood() {
        System.out.println();
        System.out.println("How are you feeling right now?");
        System.out.println("  1 - Very Sad  😢");
        System.out.println("  2 - Sad       😔");
        System.out.println("  3 - Neutral   😐");
        System.out.println("  4 - Happy     😊");
        System.out.println("  5 - Very Happy 😄");
        System.out.print("Enter a number (1-5): ");

        int value;
        try {
            value = Integer.parseInt(scanner.nextLine().trim());
            if (value < 1 || value > 5) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            return;
        }

        MoodLevel mood = MoodLevel.fromValue(value);

        System.out.print("Add a short note (or press Enter to skip): ");
        String note = scanner.nextLine().trim();

        entries.add(new MoodEntry(mood, note));
        System.out.println();
        System.out.println("Mood logged! " + mood.getEmoji() + "  " + mood.getLabel());
        printMoodTip(mood);
    }

    private void viewHistory() {
        System.out.println();
        if (entries.isEmpty()) {
            System.out.println("No mood entries yet. Log your first mood!");
            return;
        }
        System.out.println("--- Your Mood History ---");
        for (int i = 0; i < entries.size(); i++) {
            System.out.printf("  %2d. %s%n", i + 1, entries.get(i));
        }
    }

    private void showSummary() {
        System.out.println();
        if (entries.isEmpty()) {
            System.out.println("No data yet. Start logging your mood!");
            return;
        }

        double avg = entries.stream()
                .mapToInt(e -> e.getMood().getValue())
                .average()
                .orElse(0);

        long happyCount = entries.stream()
                .filter(e -> e.getMood().getValue() >= 4)
                .count();

        long sadCount = entries.stream()
                .filter(e -> e.getMood().getValue() <= 2)
                .count();

        System.out.println("--- Mood Summary ---");
        System.out.printf("  Total entries : %d%n", entries.size());
        System.out.printf("  Average mood  : %.1f / 5.0%n", avg);
        System.out.printf("  Happy days    : %d%n", happyCount);
        System.out.printf("  Tough days    : %d%n", sadCount);
        System.out.println();

        // Simple ASCII bar chart of mood distribution
        System.out.println("  Distribution:");
        for (MoodLevel m : MoodLevel.values()) {
            long count = entries.stream()
                    .filter(e -> e.getMood() == m)
                    .count();
            String bar = "#".repeat((int) count);
            System.out.printf("  %s %-12s | %s (%d)%n",
                    m.getEmoji(), m.getLabel(), bar, count);
        }
    }

    // ------------------------------------------------------------------ //

    private void printMoodTip(MoodLevel mood) {
        System.out.println();
        switch (mood) {
            case VERY_SAD -> System.out.println(
                    "Tip: It's okay to feel this way. Consider talking to someone you trust,\n" +
                    "     or try a short meditation session from this app.");
            case SAD -> System.out.println(
                    "Tip: You're not alone. A short walk or a few deep breaths can help lift\n" +
                    "     your spirits. Try the meditation timer!");
            case NEUTRAL -> System.out.println(
                    "Tip: A neutral day is still a good day. Small acts of kindness —\n" +
                    "     to yourself or others — can shift the mood.");
            case HAPPY -> System.out.println(
                    "Tip: Great! Positive days are a good time to set intentions or\n" +
                    "     journal what made today good.");
            case VERY_HAPPY -> System.out.println(
                    "Tip: Wonderful! Celebrate this feeling. Consider sharing your\n" +
                    "     energy with someone who might need it today.");
        }
    }
}
