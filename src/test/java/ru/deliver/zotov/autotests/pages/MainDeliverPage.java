package ru.deliver.zotov.autotests.pages;

import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DefaultUrl("https://www.icandeliver.ru/")
public class MainDeliverPage extends PageObject{
    private WebDriver driver = getDriver();

    @FindBy(xpath = "//span//a[@name='/enter']")
    private WebElementFacade enterButton;

    @FindBy(xpath = "//div[contains(@class, 'logo')]/a")
    private WebElementFacade logo;

    public void clickEnterButton(){
        enterButton.click();
    }

    public boolean isLoaded(){
        if (logo.isDisplayed())
            return true;
        return false;
    }
}
