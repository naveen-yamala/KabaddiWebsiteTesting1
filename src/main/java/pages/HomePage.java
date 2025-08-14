package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage extends BasePage {

    private final By teamsLink = By.xpath("//a[normalize-space()='Teams']");
    private final By matchesLink = By.xpath("//a[normalize-space()='Matches']");
    private final By standingsLink = By.xpath("//a[normalize-space()='Standings']");
    private final By statsLink = By.xpath("//a[normalize-space()='Stats']");
    private final By vsContainer = By.xpath("//div[@class='vs_container']");
    private final By headerButtonsDiv = By.xpath("//div[@class='buttons']");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public TeamsPage clickTeamsLink() {
        waitForElementToBeClickable(teamsLink).click();
        return new TeamsPage(driver);
    }

    public MatchesPage clickMatchesLink() {
        waitForElementToBeClickable(matchesLink).click();
        return new MatchesPage(driver);
    }

    public StandingsPage clickStandingsLink() {
        waitForElementToBeClickable(standingsLink).click();
        return new StandingsPage(driver);
    }

    public StatsPage clickStatsLink() {
        waitForElementToBeClickable(statsLink).click();
        return new StatsPage(driver);
    }

    public long getVSCardLoadTime(String url) {
        long startTime = System.currentTimeMillis();
        driver.get(url);
        waitForElementToBeVisible(vsContainer);
        long endTime = System.currentTimeMillis();
        return endTime - startTime;
    }

    public List<WebElement> getHeaderButtons() {
        WebElement buttonsDiv = waitForElementToBeVisible(headerButtonsDiv);
        return buttonsDiv.findElements(By.xpath(".//button | .//a"));
    }
}