package tests;

import pages.HomePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class RetrieveHeaderButtons {

    private static final String BASE_URL = "https://dplkabaddi.vercel.app/";

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        try {
            HomePage homePage = new HomePage(driver);
            homePage.navigateTo(BASE_URL);

            List<WebElement> headerButtons = homePage.getHeaderButtons();
            System.out.println("Header Buttons Found:");
            System.out.println("----------------------");
            for (WebElement button : headerButtons) {
                String text = button.getText().trim();
                if (!text.isEmpty()) {
                    System.out.println(text);
                } else {
                    System.out.println("(Button without text, maybe an icon)");
                }
            }

        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}