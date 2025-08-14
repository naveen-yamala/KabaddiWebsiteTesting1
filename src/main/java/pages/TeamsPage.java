package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.stream.Collectors;

public class TeamsPage extends BasePage {

    private final By teamSvgIcons = By.xpath("//div[contains(@class, 'teams_section')]//h2//*[name()='svg']");
    private final By teamNamesH3 = By.tagName("h3");
    private final By royalCivilTeam = By.xpath("//h3[normalize-space()='ROYAL CIVIL']");
    private final By suneelPlayer = By.xpath("//h3[normalize-space()='Suneel (C)']");
    private final By teamsLink = By.xpath("//a[normalize-space()='Teams']");

    public TeamsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getAllH3TeamNames() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(teamNamesH3, 0));
        return driver.findElements(teamNamesH3);
    }

    public void clickFirstTeam() {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(teamSvgIcons, 0));
        driver.findElements(teamSvgIcons).get(0).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(teamNamesH3));
    }

    public String getPageTitle() {
        wait.until(webDriver -> driver.getTitle() != null && !driver.getTitle().isEmpty());
        return driver.getTitle();
    }

    public List<String> getAllTeamPlayerNames() throws InterruptedException {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(teamNamesH3, 0));
        // Using Thread.sleep for a more realistic emulation of the original script
        Thread.sleep(5000); 
        return driver.findElements(teamNamesH3).stream()
                .map(WebElement::getText)
                .collect(Collectors.toList());
    }
    
    public void navigateBack() {
        driver.navigate().back();
        wait.until(ExpectedConditions.elementToBeClickable(teamsLink));
    }
    
    public WebElement getRoyalCivilTeam() {
        return waitForElementToBeClickable(royalCivilTeam);
    }
    
    public WebElement getSuneelPlayer() {
        return waitForElementToBeClickable(suneelPlayer);
    }
    
    public List<WebElement> getAllSvgIcons() {
        return driver.findElements(teamSvgIcons);
    }
}