package stepdefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.magentotest.repo.SignInRepo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SignInStep {

    private final WebDriver driver = Hooks.driver;
    private final SignInRepo signInRepo = new SignInRepo(driver);

    @Given("click on sign in link")
    public void click_on_sign_in_link(){
        signInRepo.ClickOnSignInLink();
    }

    @Then("verify user is navigated to customer login landing page")
    public void verify_user_is_navigated_to_customer_login_landing_page(){
        Assert.assertTrue(signInRepo.isCustomerLoginHeaderDisplayed());
    }
}
