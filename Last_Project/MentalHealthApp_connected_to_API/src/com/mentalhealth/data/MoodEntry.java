package com.mentalhealth.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Represents a single mood entry logged by the user.
 */
public class MoodEntry {

    public enum MoodLevel {
        VERY_SAD(1, "Very Sad", "😢"),
        SAD(2, "Sad", "😔"),
        NEUTRAL(3, "Neutral", "😐"),
        HAPPY(4, "Happy", "😊"),
        VERY_HAPPY(5, "Very Happy", "😄");

        private final int value;
        private final String label;
        private final String emoji;

        MoodLevel(int value, String label, String emoji) {
            this.value = value;
            this.label = label;
            this.emoji = emoji;
        }

        public int getValue()    { return value; }
        public String getLabel() { return label; }
        public String getEmoji() { return emoji; }

        public static MoodLevel fromValue(int value) {
            for (MoodLevel m : values()) {
                if (m.value == value) return m;
            }
            throw new IllegalArgumentException("Invalid mood value: " + value);
        }
    }

    private final MoodLevel mood;
    private final String note;
    private final LocalDateTime timestamp;

    public MoodEntry(MoodLevel mood, String note) {
        this.mood      = mood;
        this.note      = note;
        this.timestamp = LocalDateTime.now();
    }

    public MoodLevel getMood()      { return mood; }
    public String getNote()         { return note; }
    public LocalDateTime getTime()  { return timestamp; }

    @Override
    public String toString() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("MMM dd, yyyy  HH:mm");
        return String.format("[%s]  %s %s  |  \"%s\"",
                timestamp.format(fmt),
                mood.getEmoji(),
                mood.getLabel(),
                note.isEmpty() ? "No note" : note);
    }
}
