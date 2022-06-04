import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.PageObjectLkPage;
import pageObject.PageObjectLoginPage;
import pageObject.PageObjectMainPageStellar;
import pageObject.PageObjectRegisterPage;

import static com.codeborne.selenide.Selenide.*;

public class LoginFromMainPageSecondTest {

    private User user;
    private String email;
    private String password;

    @Before
    public void setUp() {

        user = User.getRandom();
        String name = user.name;
        email = user.email;
        password = user.password;

        PageObjectRegisterPage registerPage =  open("https://stellarburgers.nomoreparties.site/register", PageObjectRegisterPage.class);
        registerPage.getInputFieldName().setValue(name);
        registerPage.getInputFieldEmail().setValue(email);
        registerPage.getInputFieldPassword().setValue(password);
        sleep(2000);
        registerPage.clickRegister();
        sleep(2000);
    }
    @After
    public void tearDown() {
        PageObjectLkPage lkPage =  open("https://stellarburgers.nomoreparties.site/account", PageObjectLkPage.class);
        lkPage.clickExitButton();
        sleep(2000);
    }
    @Test
    @Description("Авторизация пользователя с главной страницы")
    @DisplayName("Авторизация пользователя с главной страницы через нажатие кнопки Войти в аккаунт")
    public void loginFromMainPageByClickingVoitiButton() {
        // Для запуска в браузере EDGE
        //   Configuration.browser = Browsers.EDGE;
        sleep(2000);
        PageObjectMainPageStellar mainPage =  open("https://stellarburgers.nomoreparties.site", PageObjectMainPageStellar.class);
        mainPage.clickLogin();
        PageObjectLoginPage loginPage = page(PageObjectLoginPage.class);
        //проверка что открылась страница авторизации ВХОД
        loginPage.waitForLoadLoginPage();
        loginPage.getInputFieldEmail().setValue(email);
        loginPage.getInputFieldPassword().setValue(password);
        loginPage.clickLogin();
        //проверка что открылась главная страница СОБЕРИТЕ БУРГЕР
        mainPage.waitForLoadMainPage();
     //   sleep(5000);

    }
}
