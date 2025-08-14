package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class MatchesPage extends BasePage {

    private final By completedLink = By.xpath("//a[normalize-space()='Completed']");
    private final By footer = By.xpath("//div[@class='MuiBox-root css-ityk05']");
    private final By matchContainers = By.xpath("//div[@class='d_match']");

    public MatchesPage(WebDriver driver) {
        super(driver);
    }

    public void clickCompletedLink() {
        waitForElementToBeClickable(completedLink).click();
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(matchContainers));
    }

    public String getFooterText() {
        WebElement footerElement = waitForElementToBeVisible(footer);
        return footerElement.getText().trim();
    }

    public List<WebElement> getCompletedMatches() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(matchContainers));
        return driver.findElements(matchContainers);
    }
}