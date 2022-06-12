import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Test;
import pageobject.PageObjectLkPage;
import pageobject.PageObjectLoginPage;
import pageobject.PageObjectMainPageStellar;
import pageobject.PageObjectRegisterPage;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class RegisterTest {
    private User user;
    private String accessToken;
    private UserClient userClient;

    @After
    public void tearDown() {

        PageObjectLoginPage logPage = open("https://stellarburgers.nomoreparties.site/account", PageObjectLoginPage.class);
        String email = user.email;
        String password = user.password;
        logPage.getInputFieldEmail().setValue(email);
        logPage.getInputFieldPassword().setValue(password);
        logPage.clickLogin();
        PageObjectMainPageStellar mainPageS = page(PageObjectMainPageStellar.class);
        mainPageS.waitForLoadMainPage();
        //получение токена посредством Selenide localStorage
        accessToken = Objects.requireNonNull(localStorage().getItem("accessToken")).substring(7);
        System.out.println("ТОКЕН ДЛЯ УДАЛЕНИЯ СОЗДАННОГО ПОЛЬЗОВАТЕЛЯ  " + accessToken);
        mainPageS.clickLkButton();
        PageObjectLkPage lkPage = page(PageObjectLkPage.class);
        lkPage.waitForLoadLkPage();
        lkPage.clickExitButton();
        logPage.waitForLoadLoginPage();
        userClient = new UserClient();
        userClient.deleteAccessToken(accessToken);
        System.out.println("Конец теста");
    }

    @Test
    @Description("Регистрация пользователя")
    @DisplayName("Регистрация пользователя с корректными параметрами")
    public void registerNewUserWithCorrectParameters() {
        // Для запуска в браузере EDGE
        //   Configuration.browser = Browsers.EDGE;
        PageObjectMainPageStellar mainPage = open("https://stellarburgers.nomoreparties.site", PageObjectMainPageStellar.class);
        mainPage.clickLkButton();
        PageObjectLoginPage loginPage = page(PageObjectLoginPage.class);
        //проверка что открылась страница авторизации ВХОД
        loginPage.waitForLoadLoginPage();
        loginPage.clickRegisterLink();
        PageObjectRegisterPage registerPage = page(PageObjectRegisterPage.class);
        registerPage.waitForLoadRegisterPage();
        user = User.getRandom();
        String name = user.name;
        String email = user.email;
        String password = user.password;
        registerPage.getInputFieldName().setValue(name);
        registerPage.getInputFieldEmail().setValue(email);
        registerPage.getInputFieldPassword().setValue(password);
        registerPage.clickRegister();
        loginPage.waitForLoadLoginPage();
    }
}
