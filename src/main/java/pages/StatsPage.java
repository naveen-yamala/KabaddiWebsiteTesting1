package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class StatsPage extends BasePage {

    private final By playerRaidPointsHeading = By.xpath("//h4[normalize-space()='Player Raid Points']");
    private final By playerRaidPointsRows = By.xpath("//h4[normalize-space()='Player Raid Points']/following::table[1]//tbody/tr");
    private final By playerRaidPointsNameHeader = By.xpath("(//th[@scope='col'][normalize-space()='Name'])[1]");
    private final By playerRaidPointsPointsHeader = By.xpath("(//th[@scope='col'][normalize-space()='Points'])[1]");
    
    private final By playerTacklePointsHeading = By.xpath("//h4[normalize-space()='Player Tackle Points']");
    private final By playerTacklePointsRows = By.xpath("//h4[normalize-space()='Player Tackle Points']/following::table[1]//tbody/tr");
    private final By playerTacklePointsNameHeader = By.xpath("(//th[@scope='col'][normalize-space()='Name'])[2]");
    private final By playerTacklePointsPointsHeader = By.xpath("(//th[@scope='col'][normalize-space()='Points'])[2]");

    private final By mostRaidPointsRow = By.xpath("(//tr[@item='[object Object]'])[1]");
    private final By mostDefencePointsRow = By.xpath("//body[1]/div[1]/div[3]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]");
    private final By mostSuper10sRow = By.xpath("//body[1]/div[1]/div[4]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]");
    private final By mostHigh5sRow = By.xpath("//body[1]/div[1]/div[5]/div[1]/div[1]/div[1]/table[1]/tbody[1]/tr[1]");


    public StatsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForRaidPointsTable() {
        waitForElementToBeVisible(playerRaidPointsHeading);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(playerRaidPointsRows, 0));
    }

    public String getRaidPointsHeaders() {
        String nameHeader = waitForElementToBeVisible(playerRaidPointsNameHeader).getText();
        String pointsHeader = waitForElementToBeVisible(playerRaidPointsPointsHeader).getText();
        return nameHeader + "\t\t" + pointsHeader;
    }

    public List<WebElement> getRaidPointsRows() {
        return driver.findElements(playerRaidPointsRows);
    }

    public void waitForTacklePointsTable() {
        waitForElementToBeVisible(playerTacklePointsHeading);
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(playerTacklePointsRows, 0));
    }

    public String getTacklePointsHeaders() {
        String nameHeader = waitForElementToBeVisible(playerTacklePointsNameHeader).getText();
        String pointsHeader = waitForElementToBeVisible(playerTacklePointsPointsHeader).getText();
        return nameHeader + "\t\t" + pointsHeader;
    }

    public List<WebElement> getTacklePointsRows() {
        return driver.findElements(playerTacklePointsRows);
    }
    
    public void waitForStatsTableToLoad() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(mostRaidPointsRow));
    }
    
    public String getMostRaidPointsText() {
        return waitForElementToBeVisible(mostRaidPointsRow).getText();
    }
    
    public String getMostDefencePointsText() {
        return waitForElementToBeVisible(mostDefencePointsRow).getText();
    }
    
    public String getMostSuper10sText() {
        return waitForElementToBeVisible(mostSuper10sRow).getText();
    }
    
    public String getMostHigh5sText() {
        return waitForElementToBeVisible(mostHigh5sRow).getText();
    }
}