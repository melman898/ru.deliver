package ru.deliver.zotov.autotests.steps.serenity;

import net.thucydides.core.annotations.Step;
import org.slf4j.LoggerFactory;
import ru.deliver.zotov.autotests.pages.InnerPage;
import ru.deliver.zotov.autotests.pages.LoginPage;
import ru.deliver.zotov.autotests.pages.MainDeliverPage;


/**
 * Created by USERrr on 23.07.2017.
 */
public class PageSteps {
    MainDeliverPage mainDeliverPage;
    LoginPage loginPage;
    InnerPage innerPage;

    private static final org.slf4j.Logger logger = LoggerFactory.getLogger(PageSteps.class);

    @Step
    public boolean checkErrorMsg(String alertMsg){
        logger.info("Ожидаемое значения = " + alertMsg+ " = " + " Актуально значение = " +loginPage.getAlertMsg());
        if (loginPage.getAlertMsg().equals(alertMsg)){
            return true;
        }
        else logger.info("Сообщение об ошибке не верное");
        return false;
    }

    @Step
    public void checkUserName(String userName){
        logger.info("Ожидаемое значения = " + userName+ " = " + " Актуально значение = " +innerPage.checkUserName());
        if (innerPage.checkUserName().equals(userName)){
            logger.info("Успешно");
        }
        else logger.info("Имя пользователя не верно");
    }
    @Step
    public void pageIsLoaded(String pageName){
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (pageName){
            case "Главная страница":
                if (!mainDeliverPage.isLoaded()){
                    logger.info("Ошибка при загрузке страницы "+pageName);
                }
                break;
            case "Страница авторизации":
                if (!innerPage.isLoaded()){
                    logger.info("Ошибка при загрузке страницы "+pageName);
                } break;
            case "Авторизованная зона":
                if (!loginPage.isLoaded()){
                    logger.info("Ошибка при загрузке страницы "+pageName);
                } break;
        }
    }
}
