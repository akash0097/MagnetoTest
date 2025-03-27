package org.magentotest.repo;

import com.sun.tools.javac.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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
        driver.findElement(this.signInLink).clear();
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public boolean isCustomerLoginHeaderDisplayed(){
        return driver.findElement(customerLoginHeaderText).isDisplayed();
    }

    public void EnterEmail(){
        driver.findElement(emailTextField).sendKeys(createAnAccountRepo.getGeneratedEmail());
    }

    public void EnterPassword(){
        driver.findElement(passwordTextField).sendKeys("Password@1234");
    }

    public void ClickOnSignInBtn(){
        driver.findElement(signInBtn).click();
    }
}
