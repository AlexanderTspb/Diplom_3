import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;
import pageobject.PageObjectLoginPage;
import pageobject.PageObjectMainPageStellar;
import pageobject.PageObjectRegisterPage;

import static com.codeborne.selenide.Selenide.*;

public class RegisterCheckErrorTest {
    private User user;

    @Test
    @Description("Регистрация пользователя с недопустимой длиной пароля")
    @DisplayName("Регистрация пользователя с недопустимой длиной пароля(меньше допустимого)")
    public void CheckErrorNotificationByRegisterUserWithUncorrectPassword() {
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
        String password = RandomStringUtils.randomAlphabetic(4);
        registerPage.getInputFieldName().setValue(name);
        registerPage.getInputFieldEmail().setValue(email);
        registerPage.getInputFieldPassword().setValue(password);
        registerPage.clickRegister();
        registerPage.incorrectPasswordNotification();
    }
}
