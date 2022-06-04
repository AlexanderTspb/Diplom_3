import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pageObject.*;

import static com.codeborne.selenide.Selenide.*;

public class LoginFromForgotPasswordPageTest {

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
    @Description("Авторизация пользователя со страницы Восстановление пароля")
    @DisplayName("Авторизация пользователя со страницы Восстановление пароля через нажатие кнопки Войти")
    public void loginFromForgotPasswordPageByClickingVoitiButton() {
        // Для запуска в браузере EDGE
        //   Configuration.browser = Browsers.EDGE;
        sleep(2000);
        PageObjectForgotPasswordPage forgotPasswordPage =  open("https://stellarburgers.nomoreparties.site/forgot-password", PageObjectForgotPasswordPage.class);
        forgotPasswordPage.clickLoginLink();
        PageObjectLoginPage loginPage = page(PageObjectLoginPage.class);
        //проверка что открылась страница авторизации ВХОД
        loginPage.waitForLoadLoginPage();
        loginPage.getInputFieldEmail().setValue(email);
        loginPage.getInputFieldPassword().setValue(password);
        loginPage.clickLogin();
        PageObjectMainPageStellar mainPage = page(PageObjectMainPageStellar.class);
        //проверка что открылась главная страница СОБЕРИТЕ БУРГЕР
        mainPage.waitForLoadMainPage();
    //    sleep(5000);

    }
}
