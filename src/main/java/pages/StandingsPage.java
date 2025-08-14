package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.List;

public class StandingsPage extends BasePage {

    private final By pointsTable = By.xpath("//table[@aria-label='points table']");
    private final By tableHeaders = By.tagName("th");
    private final By tableRows = By.xpath("//tbody/tr");
    private final By teamNameCells = By.xpath("//tbody/tr/td[2]");
    private final By pdCells = By.xpath("//tbody/tr/td[8]");

    public StandingsPage(WebDriver driver) {
        super(driver);
    }

    public void waitForTableToLoad() {
        waitForElementToBeVisible(pointsTable);
    }

    public List<WebElement> getTableHeaders() {
        return waitForElementToBeVisible(pointsTable).findElements(tableHeaders);
    }

    public List<WebElement> getTableRows(int limit) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(tableRows, limit - 1));
        return driver.findElements(tableRows).subList(0, limit);
    }

    public List<WebElement> getTeamNameCells() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(teamNameCells, 0));
        return driver.findElements(teamNameCells);
    }

    public List<WebElement> getPdCells() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(pdCells, 0));
        return driver.findElements(pdCells);
    }
}