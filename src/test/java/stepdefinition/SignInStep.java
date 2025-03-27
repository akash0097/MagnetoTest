package stepdefinition;

import org.magentotest.repo.SignInRepo;
import org.openqa.selenium.WebDriver;

public class SignInStep {

    private final WebDriver driver = Hooks.driver;
    private final SignInRepo signInRepo = new SignInRepo(driver);

    //Step definitions
}
