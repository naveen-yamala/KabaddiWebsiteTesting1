package tests;

import pages.HomePage;
import pages.StandingsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class PointsTableScraper {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);

            StandingsPage standingsPage = homePage.clickStandingsLink();
            standingsPage.waitForTableToLoad();

            List<WebElement> headers = standingsPage.getTableHeaders();
            for (WebElement header : headers) {
                System.out.print(header.getText().trim() + "\t\t");
            }
            System.out.println();

            List<WebElement> rows = standingsPage.getTableRows(5);
            for (WebElement row : rows) {
                List<WebElement> cells = row.findElements(By.tagName("td"));
                for (WebElement cell : cells) {
                    System.out.print(cell.getText().trim() + "\t");
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