package stepdefinition;

import org.magentotest.repo.CreateAnAccountRepo;
import org.openqa.selenium.WebDriver;

public class CreateAnAccountStep {

    private final WebDriver driver = Hooks.driver;
    private final CreateAnAccountRepo createAnAccountRepo = new CreateAnAccountRepo(driver);

    //Step definition
}
