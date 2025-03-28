package org.magentotest.repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public class CreateAnAccountRepo {

    private final WebDriver driver;

    public CreateAnAccountRepo(WebDriver driver){
        this.driver = driver;
    }

    private final By createAnAccountLink = By.xpath("//div[@class='panel header']//a[contains(text(),'Create an Account')]");
    private final By firstNameTextField = By.xpath("//input[@id='firstname']");
    private final By lastNameTextField = By.xpath("//input[@id='lastname']");
    private final By email = By.xpath("//input[@id='email_address']");
    private final By password = By.xpath("//input[@id='password']");
    private final By confirmPassword = By.xpath("//input[@id='password-confirmation']");
    private final By createAnAccountBtn = By.xpath("//button[@title='Create an Account']/span");
    private final By registeringSuccessMeg = By.xpath("//div[@role='alert']//div[contains(text(),'Thank you for registering with Main Website Store.')]");
    private final By menuBesideGreetingExpandIcon = By.xpath("//div[@class='panel header']//button[@class='action switch']");
    private final By signOutLink = By.xpath("(//div[@class='panel header']//a[contains(text(),'Sign Out')])[1]");
    private final By landingPageGreetingText = By.xpath("(//li[@class='greet welcome']/span[contains(text(),'Welcome')])[1]");

    private String generatedEmail;

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void ClickOnCreateAnAccountLink(){
        driver.findElement(this.createAnAccountLink).click();
    }

    public void EnterFirstName(){
        driver.findElement(this.firstNameTextField).sendKeys("Auto FirstName");
    }

    public void EnterLastName(){
        driver.findElement(this.lastNameTextField).sendKeys("Auto LastName");
    }

    public void EnterEmail(){
        driver.findElement(email).sendKeys(getRandomEmailId());
    }

    public String getGeneratedEmail(){
        return generatedEmail;
    }

    public void EnterPassword(){
        driver.findElement(password).sendKeys("Password@1234");
    }

    public void EnterConfirmPassword(){
        driver.findElement(confirmPassword).sendKeys("Password@1234");
    }

    public void ClickOnCreateAnAccountButton(){

        driver.findElement(createAnAccountBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public boolean isRegisteringSuccessMsgDisplayed(){
        return driver.findElement(registeringSuccessMeg).isDisplayed();
    }

    public void ClickOnGreetingMenuExpandIcon(){
        driver.findElement(menuBesideGreetingExpandIcon).click();
    }

    public void ClickOnSignOutLink(){
        driver.findElement(signOutLink).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public String getLandingPageGreetingText(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        WebElement visibleElement = wait.until(ExpectedConditions.visibilityOfElementLocated(landingPageGreetingText));
        return driver.findElement(landingPageGreetingText).getText();
    }

    private String getRandomEmailId() {
        Random random = new Random();
        int randomNumber = random.nextInt(1000);
        generatedEmail = "AutomationTest" + randomNumber + "@gmail.com";
        return generatedEmail;
    }
}
