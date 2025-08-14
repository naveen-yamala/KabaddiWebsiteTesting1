package tests;

import pages.HomePage;
import pages.TeamsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstTeamTitle {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);

            TeamsPage teamsPage = homePage.clickTeamsLink();
            teamsPage.clickFirstTeam();
            String pageTitle = teamsPage.getPageTitle();
            System.out.println("Page Title: " + pageTitle);
            teamsPage.navigateBack();

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}