package ru.deliver.zotov.autotests.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage  extends PageObject{
    private WebDriver driver = getDriver();

    @FindBy(xpath = "//div[contains(@class, 'auth')]")
    private WebElementFacade auth;

    @FindBy(xpath = "//input[@name='email']")
    private WebElementFacade loginField;

    @FindBy(xpath = "//input[@name='password']")
    private WebElementFacade passwordField;

    @FindBy(xpath = "//button[contains(@class, 'submit')]")
    private WebElementFacade enterButton;

    @FindBy(xpath = "//div//div[contains(@class, 'alert')]")
    private WebElementFacade alertMessage;

    public void clickEnterButton(){
        enterButton.click();
    }

    public void typeLogin(String login){
        loginField.sendKeys(login);
    }

    public void typePassword(String Password){
        loginField.sendKeys(Password);
    }

    public String getAlertMsg(){
        return alertMessage.getText();
    }

    public boolean isLoaded(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(auth));
        if (auth.isDisplayed())
            return true;
        return false;
    }
}
