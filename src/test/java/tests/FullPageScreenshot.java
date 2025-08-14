package tests;

import pages.HomePage;
import pages.TeamsPage;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FullPageScreenshot {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);

            TeamsPage teamsPage = homePage.clickTeamsLink();
            teamsPage.getRoyalCivilTeam().click();
            teamsPage.getSuneelPlayer().click();

            WebElement naveen = teamsPage.waitForElementToBeVisible(By.xpath("//h6[normalize-space()='Naveen Yamala']"));
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", naveen);
            Thread.sleep(1500); 

            ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
            Thread.sleep(1000); 

            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File destFile = new File("full_webpage_screenshot.png");
            Files.copy(screenshot.toPath(), destFile.toPath());
            System.out.println("Full webpage screenshot saved: " + destFile.getAbsolutePath());

        } catch (IOException | InterruptedException e) {
            System.err.println("Error while saving screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}