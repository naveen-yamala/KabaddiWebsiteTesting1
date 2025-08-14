package tests;

import pages.HomePage;
import pages.MatchesPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class MatchDetailsScraper {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);
            
            MatchesPage matchesPage = homePage.clickMatchesLink();
            matchesPage.clickCompletedLink();
            Thread.sleep(6000);

            List<WebElement> matches = matchesPage.getCompletedMatches();
            int totalMatches = Math.min(matches.size(), 8);

            for (int i = 0; i < totalMatches; i++) {
                WebElement match = matches.get(i);
                String matchDate = match.findElement(By.tagName("h2")).getText().trim();
                System.out.println(matchDate + ":");
                String matchType = match.findElement(By.tagName("h4")).getText().trim();
                List<WebElement> teams = match.findElements(By.tagName("h3"));
                if (teams.size() >= 2) {
                    String teamA = teams.get(0).getText().trim();
                    String teamB = teams.get(1).getText().trim();
                    System.out.println(" " + matchType + " : " + teamA + " vs " + teamB);
                }
                System.out.println();
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}