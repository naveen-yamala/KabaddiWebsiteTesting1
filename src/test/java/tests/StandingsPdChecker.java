package tests;

import pages.HomePage;
import pages.StandingsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class StandingsPdChecker {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);

            StandingsPage standingsPage = homePage.clickStandingsLink();
            standingsPage.waitForTableToLoad();

            List<WebElement> teamNameCells = standingsPage.getTeamNameCells();
            List<WebElement> pdCells = standingsPage.getPdCells();

            String maxTeam = "";
            String minTeam = "";
            int maxPd = Integer.MIN_VALUE;
            int minPd = Integer.MAX_VALUE;

            for (int i = 0; i < pdCells.size(); i++) {
                String teamName = teamNameCells.get(i).getText().trim();
                int pdValue = Integer.parseInt(pdCells.get(i).getText().trim());

                if (pdValue > maxPd) {
                    maxPd = pdValue;
                    maxTeam = teamName;
                }
                if (pdValue < minPd) {
                    minPd = pdValue;
                    minTeam = teamName;
                }
            }
            System.out.println("Max Pd: " + maxPd + " - Team: " + maxTeam);
            System.out.println("Min Pd: " + minPd + " - Team: " + minTeam);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}