# 🏆 KABADDIWORKSPACES – Selenium Automation Framework

This project automates the **DPL Kabaddi** website (`https://dplkabaddi.vercel.app/`) using **Java**, **Selenium WebDriver**, and the **Page Object Model (POM)**.  
It is structured for **clarity, reusability, and maintainability**, with each feature having its own test case and page class.

---

## 📂 Project Structure & Purpose

src
└── main
└── java/pages # Page classes – reusable Selenium actions
└── test
└── java/tests # Test cases – scripts that use the page classes

### **1. Page Classes (main/java/pages)**
These classes **represent different pages of the application**.  
They contain locators and reusable methods that interact with web elements.

- **BasePage.java**
  - Core Selenium utilities: navigation, explicit waits, element visibility, and clickability.
  - Acts as the parent class for all other pages.

- **HomePage.java**
  - Entry point for navigation.
  - Methods to go to **Teams**, **Matches**, **Standings**, **Stats**.
  - Also retrieves header buttons and calculates load times for the main "VS Card" section.

- **TeamsPage.java**
  - Retrieves all team names and players.
  - Clicks a team and navigates back.
  - Supports selecting specific teams (e.g., "ROYAL CIVIL") or players.
  - Can return all SVG icons for dynamic navigation.

- **MatchesPage.java**
  - Handles **Completed Matches** section.
  - Retrieves match list and footer details.

- **StandingsPage.java**
  - Retrieves **Points Table** headers, rows, team names, and PD (Point Difference) values.
  - Waits for standings table to fully load.

- **StatsPage.java**
  - Extracts **Raid Points**, **Tackle Points**, and other tournament leader stats.
  - Waits for stats tables and retrieves specific rows.

---

### **2. Test Classes (test/java/tests)**
Each test focuses on a **single, specific functionality**.  
This ensures clarity and makes debugging easier.

- **AllTeamsPlayers.java**
  - Loops through all teams.
  - Clicks each one, retrieves and prints all player names.

- **FirstTeamTitle.java**
  - Clicks the first team.
  - Prints the browser tab’s page title.

- **FooterRetrieverAfterClicks.java**
  - Navigates to matches.
  - Clicks "Completed" and prints footer text.

- **FullPageScreenshot.java**
  - Navigates to a team and a player.
  - Scrolls the page and saves a full-page screenshot.

- **LoadingTimeCalculator.java**
  - Measures how long it takes for the "VS Card" section to load.

- **MatchDetailsScraper.java**
  - Retrieves recent completed match dates, types, and team names.

- **PlayerRaidPointsScraper.java**
  - Prints the **Raid Points** table headers and values.

- **PlayerTacklePointsScraper.java**
  - Prints the **Tackle Points** table headers and values.

- **PointsTableScraper.java**
  - Prints the standings table (with a row limit).

- **PrintAllH3Tags.java**
  - Prints all `<h3>` tags on the Teams page.

- **RetrieveHeaderButtons.java**
  - Lists all header buttons (text or icons).

- **StandingsPdChecker.java**
  - Finds the team with the highest and lowest PD (Point Difference).

- **TeamPlayersH3.java**
  - Lists all players in the first team.

- **TournamentStatsScraper.java**
  - Retrieves stats like Most Raid Points, Most Defence Points, Most Super 10s, Most High 5s.

---

## ⚙️ How It Works

1. **Launch ChromeDriver**  
   Each test starts by creating a new ChromeDriver instance and opening the base URL.

2. **Navigate Using HomePage**  
   From `HomePage.java`, navigation methods take you to **Teams**, **Matches**, **Standings**, or **Stats**.

3. **Page Objects Handle Locators**  
   Each page class defines `By` locators and methods to interact with the UI elements.

4. **Data Extraction or Actions**  
   Tests call these methods to retrieve data, click buttons, navigate between pages, or take screenshots.

5. **Test-Specific Output**  
   Each test prints relevant results in a clear format.

---

## 🚀 Running a Test Example

```bash
mvn test -Dtest=PointsTableScraper
