package ru.deliver.zotov.autotests.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class InnerPage extends PageObject {
    private WebDriver driver = getDriver();

    @FindBy(xpath = "//li[contains(@class, 'item')]/a")
    private WebElementFacade userName;

    @FindBy(xpath = "//div[contains(@class, 'logo')]/a")
    private WebElementFacade logo;

    public String checkUserName(){
        return userName.getText();
    }

    public boolean isLoaded(){
        Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);
        wait.until(ExpectedConditions.visibilityOf(logo));
        if (logo.isDisplayed())
            return true;
        return false;
    }
}
