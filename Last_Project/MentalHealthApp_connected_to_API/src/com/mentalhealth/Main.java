package com.mentalhealth;

import com.mentalhealth.ui.MainMenuUI;

/**
 * Mental Health Support Application
 * Features: Mood Tracker, Meditation Timer, AI Counseling Chatbot
 * 
 * @author Student Final Project
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("====================================");
        System.out.println("   Mental Health Support App");
        System.out.println("====================================");
        System.out.println("Welcome! This app is here to help.");
        System.out.println();

        MainMenuUI menu = new MainMenuUI();
        menu.start();
    }
}
