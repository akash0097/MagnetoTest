package org.magentotest.repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SignInRepo {

    private final WebDriver driver;
    private CreateAnAccountRepo createAnAccountRepo;

    public SignInRepo(WebDriver driver){
        this.driver = driver;
    }

    private final By signInLink = By.xpath("//div[@class='panel header']//a[contains(text(),'Sign In')]");
    private final By customerLoginHeaderText = By.xpath("//h1/span[contains(text(),'Customer Login')]");
    private final By emailTextField = By.xpath("//input[@id='email']");
    private final By passwordTextField = By.xpath("//input[@id='pass']");
    private final By signInBtn = By.xpath("//button[@class='action login primary']");

    public void ClickOnSignInLink() {
        driver.findElement(this.signInLink).click();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isCustomerLoginHeaderDisplayed(){
        return driver.findElement(customerLoginHeaderText).isDisplayed();
    }

    public void EnterEmail(){
        driver.findElement(emailTextField).sendKeys("abc@gmail.com");
    }

    public void EnterGeneratedEmail(String email){
        driver.findElement(emailTextField).sendKeys(email);
    }

    public void EnterPassword(){
        driver.findElement(passwordTextField).sendKeys("Password@1234");
    }

    public void ClickOnSignInBtn(){
        driver.findElement(signInBtn).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }
}
