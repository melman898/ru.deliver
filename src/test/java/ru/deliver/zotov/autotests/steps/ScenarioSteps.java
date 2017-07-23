package ru.deliver.zotov.autotests.steps;

import net.thucydides.core.annotations.Steps;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.slf4j.LoggerFactory;
import ru.deliver.zotov.autotests.steps.serenity.PageSteps;
import ru.deliver.zotov.autotests.steps.serenity.UserSteps;


public class ScenarioSteps {
    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(ScenarioSteps.class);
    @Steps
    PageSteps pageSteps;

    @Steps
    UserSteps userSteps;

    @Given("Открывается главная страница")
    public void openMainPage() {
        userSteps.openMainPage();
    }

    @Then("Загружена страница \"$pageName\"")
    public void stepLoadedPage(String pageName) {
        pageSteps.pageIsLoaded("Главная страница");
        logger.info(String.format("Загружена страница [%s]",pageName));
    }
    @When("Выполнено нажатие на кнопку войти")
    public void goToLogin(){
        userSteps.logIn();
    }

    @When("Заполняются поля логин значением \"$login\" и пароль значением \"$password\"")
    public void typeLogPass(String login,String password) {
        userSteps.typeLogin(login);
        userSteps.typePassword(password);
    }

    @When("Проверяется валидация полей логин и пароль")
    public void checkFields() {
        userSteps.typeLogin("ldsldsadsa");
        userSteps.typePassword("dsadsadasd");
        userSteps.enter();
        if (pageSteps.checkErrorMsg("Не верный логин или пароль")){
            logger.info(String.format("Сообщение об ошибке верно"));
        }
    }
    @Then("Проверяется значение поля userName = \"$userName\"")
    public void checkUserName(String userName) {
        pageSteps.checkUserName(userName);
    }
}
