package tests;

import pages.HomePage;
import pages.StatsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TournamentStatsScraper {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);

            StatsPage statsPage = homePage.clickStatsLink();
            statsPage.waitForStatsTableToLoad();
            
            System.out.println("Most Raid Points: " + statsPage.getMostRaidPointsText());
            System.out.println("Most Defence Points: " + statsPage.getMostDefencePointsText());
            System.out.println("Most Super 10s: " + statsPage.getMostSuper10sText());
            System.out.println("Most High 5s: " + statsPage.getMostHigh5sText());

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}