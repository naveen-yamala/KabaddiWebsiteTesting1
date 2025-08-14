package tests;

import pages.HomePage;
import pages.TeamsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class AllTeamsPlayers {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);

            TeamsPage teamsPage = homePage.clickTeamsLink();
            
            List<WebElement> teamSvgs = teamsPage.getAllSvgIcons();
            List<String> teamSvgXPaths = new ArrayList<>();
            for (int i = 0; i < teamSvgs.size(); i++) {
                teamSvgXPaths.add("(//div[contains(@class, 'teams_section')]//h2//*[name()='svg'])[" + (i + 1) + "]");
            }

            for (String teamXPath : teamSvgXPaths) {
                WebElement svgIcon = teamsPage.waitForElementToBeClickable(By.xpath(teamXPath));
                String teamName = svgIcon.findElement(By.xpath("./ancestor::h2")).getText().trim();
                svgIcon.click();

                List<String> players = teamsPage.getAllTeamPlayerNames();
                System.out.println(teamName + ":");
                players.forEach(name -> {
                    if (!name.isEmpty()) System.out.println(" " + name);
                });
                System.out.println();
                teamsPage.navigateBack();
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}