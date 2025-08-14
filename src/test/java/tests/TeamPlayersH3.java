package tests;

import pages.HomePage;
import pages.TeamsPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class TeamPlayersH3 {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);

            TeamsPage teamsPage = homePage.clickTeamsLink();
            teamsPage.clickFirstTeam();
            
            System.out.println("Players in First Team:");
            System.out.println("----------------------");
            List<String> playerNames = teamsPage.getAllTeamPlayerNames();
            playerNames.stream()
                .filter(name -> !name.isEmpty())
                .forEach(System.out::println);

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}