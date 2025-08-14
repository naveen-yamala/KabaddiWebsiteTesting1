package tests;

import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoadingTimeCalculator {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            long loadTimeMillis = homePage.getVSCardLoadTime(BASE_URL);
            double loadTimeSeconds = loadTimeMillis / 1000.0;
            System.out.printf("vsContainerLocator loaded in: %d ms (%.2f seconds)%n", loadTimeMillis, loadTimeSeconds);
            
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}