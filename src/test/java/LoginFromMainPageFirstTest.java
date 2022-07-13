import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageobject.PageObjectLkPage;
import pageobject.PageObjectLoginPage;
import pageobject.PageObjectMainPageStellar;
import pageobject.PageObjectRegisterPage;

import java.util.Objects;

import static com.codeborne.selenide.Selenide.*;

public class LoginFromMainPageFirstTest {
    private User user;
    private String email;
    private String password;
    private String accessToken;
    private UserClient userClient;

    @Before
    public void setUp() {
        user = User.getRandom();
        String name = user.name;
        email = user.email;
        password = user.password;
        PageObjectRegisterPage registerPage = open("https://stellarburgers.nomoreparties.site/register", PageObjectRegisterPage.class);
        registerPage.getInputFieldName().setValue(name);
        registerPage.getInputFieldEmail().setValue(email);
        registerPage.getInputFieldPassword().setValue(password);
        registerPage.clickRegister();
        PageObjectLoginPage loginPageS = page(PageObjectLoginPage.class);
        loginPageS.waitForLoadLoginPage();
    }

    @After
    public void tearDown() {
        PageObjectLkPage lkPage = open("https://stellarburgers.nomoreparties.site/account", PageObjectLkPage.class);
        lkPage.clickExitButton();
        PageObjectLoginPage logPage = page(PageObjectLoginPage.class);
        logPage.waitForLoadLoginPage();
        userClient = new UserClient();
        userClient.deleteAccessToken(accessToken);
        System.out.println("Конец теста");
    }

    @Test
    @Description("Авторизация пользователя с главной страницы")
    @DisplayName("Авторизация пользователя с главной страницы через нажатие кнопки Личный кабинет")
    public void loginFromMainPageByClickingLkButton() {
        // Для запуска в браузере EDGE
        //   Configuration.browser = Browsers.EDGE;
        PageObjectMainPageStellar mainPage = open("https://stellarburgers.nomoreparties.site", PageObjectMainPageStellar.class);
        mainPage.clickLkButton();
        PageObjectLoginPage loginPage = page(PageObjectLoginPage.class);
        //проверка что открылась страница авторизации ВХОД
        loginPage.waitForLoadLoginPage();
        loginPage.getInputFieldEmail().setValue(email);
        loginPage.getInputFieldPassword().setValue(password);
        loginPage.clickLogin();
        //проверка что открылась главная страница СОБЕРИТЕ БУРГЕР
        mainPage.waitForLoadMainPage();
        //получение токена посредством Selenide localStorage
        accessToken = Objects.requireNonNull(localStorage().getItem("accessToken")).substring(7);
        System.out.println("ТОКЕН ДЛЯ УДАЛЕНИЯ СОЗДАННОГО ПОЛЬЗОВАТЕЛЯ  " + accessToken);
    }
}
