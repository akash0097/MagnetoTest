package stepdefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.magentotest.repo.CreateAnAccountRepo;
import org.magentotest.repo.SignInRepo;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utility.Support;

public class CreateAnAccountStep {

    private final WebDriver driver = Hooks.driver;
    private final CreateAnAccountRepo createAnAccountRepo = new CreateAnAccountRepo(driver);
    private final SignInRepo signInRepo = new SignInRepo(driver);

    @Given("click on the create an account link")
    public void click_on_the_create_an_account_link() {
        createAnAccountRepo.ClickOnCreateAnAccountLink();
    }

    @Then("verify user is navigated to create new customer account landing page")
    public void verify_user_is_navigated_to_create_new_customer_account_landing_page() {
        Assert.assertEquals(createAnAccountRepo.getPageTitle(), "Create New Customer Account");
    }

    @And("enter correct details")
    public void enter_correct_details() {
        createAnAccountRepo.EnterFirstName();
        createAnAccountRepo.EnterLastName();
        createAnAccountRepo.EnterEmail();
        createAnAccountRepo.EnterPassword();
        createAnAccountRepo.EnterConfirmPassword();
    }

    @And("click on create an account button")
    public void click_on_create_an_account_button() {
        Support.scrollToBottom(driver);
        createAnAccountRepo.ClickOnCreateAnAccountButton();
    }

    @Then("verify the registering success message")
    public void verify_the_registering_success_message() {
        Assert.assertTrue(createAnAccountRepo.isRegisteringSuccessMsgDisplayed());
    }

    @And("sign out the application")
    public void sign_out_the_application() {
        createAnAccountRepo.ClickOnGreetingMenuExpandIcon();
        createAnAccountRepo.ClickOnSignOutLink();
    }

    @And("enter correct credentials")
    public void enter_correct_credentials() {
        signInRepo.EnterGeneratedEmail(createAnAccountRepo.getGeneratedEmail());
        signInRepo.EnterPassword();
    }

    @And("click on sign in button")
    public void click_on_sign_in_button() {
        signInRepo.ClickOnSignInBtn();
    }

    @Then("verify user is signed in successfully")
    public void verify_user_is_signed_in_successfully() {
        Assert.assertTrue (createAnAccountRepo.getLandingPageGreetingText().contains("Welcome"));
    }
}
