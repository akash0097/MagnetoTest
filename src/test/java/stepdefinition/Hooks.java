package stepdefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utility.ConfigReader;

public class Hooks {
    public static WebDriver driver;

    @Before
    public void setup() {
        String browser = ConfigReader.getProperty("browser");
        String baseUrl = ConfigReader.getProperty("baseUrl");

        if(browser.equals("Chrome")){
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(baseUrl);
        }
    }

    @After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
