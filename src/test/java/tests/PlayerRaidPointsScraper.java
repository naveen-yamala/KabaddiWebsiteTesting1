package tests;

import pages.HomePage;
import pages.StatsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class PlayerRaidPointsScraper {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);

            StatsPage statsPage = homePage.clickStatsLink();
            statsPage.waitForRaidPointsTable();

            System.out.println(statsPage.getRaidPointsHeaders());
            System.out.println("-----------------------------------");
            List<WebElement> rows = statsPage.getRaidPointsRows();

            for (WebElement row : rows) {
                String playerName = row.findElement(By.xpath("./td[3]")).getText().trim();
                String points = row.findElement(By.xpath("./td[4]")).getText().trim();
                System.out.println(playerName + "\t\t" + points);
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}