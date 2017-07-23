package ru.deliver.zotov.autotests.steps.serenity;

import net.thucydides.core.annotations.Step;
import ru.deliver.zotov.autotests.pages.LoginPage;
import ru.deliver.zotov.autotests.pages.MainDeliverPage;

/**
 * Created by USERrr on 23.07.2017.
 */
public class UserSteps {

    MainDeliverPage mainDeliverPage;
    LoginPage loginPage;

    @Step
    public void enter(){
        mainDeliverPage.clickEnterButton();
    }
    @Step
    public void typeLogin(String login){
        loginPage.typeLogin(login);
    }
    @Step
    public void typePassword(String password){
        loginPage.typeLogin(password);
    }
    @Step
    public void logIn(){
        loginPage.clickEnterButton();
    }
    @Step
    public void openMainPage(){
        mainDeliverPage.open();
    }
}
