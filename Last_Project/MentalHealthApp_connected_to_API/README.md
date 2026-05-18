# Mental Health Support App — v2 (AI-Powered)
### Java Console Application — Final Project

> **v2 upgrade**: The AI Counselor is now powered by the real **Anthropic Claude API**,
> giving genuine empathetic responses instead of keyword matching.

---

## Setup: Anthropic API Key

1. Go to **https://console.anthropic.com/** and sign in
2. Click **API Keys → Create Key** and copy it

**Set the key before running:**
```bash
# Windows Command Prompt
set ANTHROPIC_API_KEY=sk-ant-api03-...

# Windows PowerShell
$env:ANTHROPIC_API_KEY="sk-ant-api03-..."

# Mac / Linux
export ANTHROPIC_API_KEY=sk-ant-api03-...
```
Or paste it directly into `ChatbotEngine.java` at `API_KEY_HARD = "..."`.

---

## Features

| # | Feature | Description |
|---|---------|-------------|
| 1 | **Mood Tracker** | Log daily moods (1–5), add notes, view history & stats |
| 2 | **Meditation Timer** | Preset sessions: 2/5/10/15 min or custom |
| 3 | **AI Counselor (Claude)** | Real Claude API — remembers context across the whole session |

---

## Features

| # | Feature | Description |
|---|---------|-------------|
| 1 | **Mood Tracker** | Log daily moods (1–5 scale), add notes, view history & stats |
| 2 | **Meditation Timer** | Guided sessions: Breathing (2 min), Body Scan (5 min), Mindfulness (10 min), Deep Focus (15 min), Custom |
| 3 | **AI Counseling Chatbot** | Keyword-based empathetic chatbot "Serenity" with conversation history |

---

## Project Structure

```
MentalHealthApp/
├── src/
│   └── com/mentalhealth/
│       ├── Main.java                        ← Entry point
│       ├── ui/
│       │   └── MainMenuUI.java              ← Main menu
│       ├── mood/
│       │   └── MoodTracker.java             ← Mood tracking logic
│       ├── meditation/
│       │   └── MeditationTimer.java         ← Meditation timer
│       ├── chatbot/
│       │   ├── CounselingChatbot.java       ← Chat session manager
│       │   └── ChatbotEngine.java           ← Response/keyword engine
│       └── data/
│           └── MoodEntry.java               ← Mood data model
├── run.sh          ← Linux/Mac build & run
├── run.bat         ← Windows build & run
└── README.md
```

---

## How to Run

### Requirements
- **Java JDK 17 or higher** (download: https://adoptium.net/)
- Any terminal / command prompt

### Option 1 — Script (recommended)
```bash
# Linux / Mac
chmod +x run.sh
./run.sh

# Windows — double-click run.bat
# OR from Command Prompt:
run.bat
```

### Option 2 — Manual compile & run
```bash
mkdir out

# Linux/Mac
find src -name "*.java" | xargs javac -d out

# Windows
dir /s /b src\*.java > sources.txt
javac -d out @sources.txt

# Run (both platforms)
java -cp out com.mentalhealth.Main
```

### Option 3 — IDE (IntelliJ IDEA / Eclipse)
1. Open the `MentalHealthApp` folder as a project
2. Set source root to `src/`
3. Run `com.mentalhealth.Main`

---

## Usage Guide

### Main Menu
```
1. Mood Tracker
2. Meditation Timer
3. AI Counselor (Serenity)
4. About
0. Exit
```

### Mood Tracker
- Select option 1 to log a mood on a scale of 1–5
- Optionally add a text note
- View full history or stats/bar chart

### Meditation Timer
- Choose a preset session or enter a custom duration
- The timer counts down with milestone reminders printed every 30 seconds
- Terminal rings a bell (🔔) on completion

### AI Chatbot — Serenity
- Type naturally about how you're feeling
- Serenity responds with empathetic, supportive replies
- Type `history` to review the conversation
- Type `quit` or `0` to return to the menu

---

## Key Java Concepts Used

| Concept | Where |
|---------|-------|
| Enums | `MoodEntry.MoodLevel` |
| Collections (ArrayList, Map) | `MoodTracker`, `ChatbotEngine` |
| Streams & Lambdas | Mood statistics in `MoodTracker` |
| `Thread.sleep()` | Real-time countdown in `MeditationTimer` |
| OOP (encapsulation, separation of concerns) | All classes |
| Package structure | `com.mentalhealth.*` |
| Scanner (user input) | Shared `Scanner` instance across classes |

---

## Crisis Resources
This app displays emergency resources when crisis keywords are detected.
- **Korea**: 1393 (free, 24/7)
- **International**: https://www.iasp.info/resources/Crisis_Centres/

*This app is not a replacement for professional mental health care.*
