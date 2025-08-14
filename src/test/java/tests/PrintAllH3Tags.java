package tests;

import pages.HomePage;
import pages.TeamsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class PrintAllH3Tags {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);
            
            TeamsPage teamsPage = homePage.clickTeamsLink();
            List<WebElement> h3Elements = teamsPage.getAllH3TeamNames();
            
            System.out.println("All <h3> tags on Teams page:");
            System.out.println("----------------------------");
            h3Elements.stream()
                .map(WebElement::getText)
                .filter(text -> !text.isEmpty())
                .forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}