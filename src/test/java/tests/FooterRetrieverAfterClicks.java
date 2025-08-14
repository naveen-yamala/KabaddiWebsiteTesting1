package tests;

import pages.HomePage;
import pages.MatchesPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FooterRetrieverAfterClicks {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);
            
            MatchesPage matchesPage = homePage.clickMatchesLink();
            matchesPage.clickCompletedLink();
            String footerText = matchesPage.getFooterText();
            
            System.out.println("========== FOOTER DETAILS ==========");
            System.out.println(footerText);
            System.out.println("====================================");
            
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}