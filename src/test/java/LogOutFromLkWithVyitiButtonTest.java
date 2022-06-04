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

public class LogOutFromLkWithVyitiButtonTest {

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

    @Test
    @Description("Выход из системы со страницы личного кабинета")
    @DisplayName("Выход из системы со страницы личного кабинета через нажатие кнопки Выход")
    public void logOutFromLkByClickingVihodButton() {
        // Для запуска в браузере EDGE
        //   Configuration.browser = Browsers.EDGE;
        sleep(2000);
        PageObjectMainPageStellar mainPage =  open("https://stellarburgers.nomoreparties.site", PageObjectMainPageStellar.class);
        mainPage.clickLkButton();
        PageObjectLoginPage loginPage = page(PageObjectLoginPage.class);
        //проверка что открылась страница авторизации ВХОД
        loginPage.waitForLoadLoginPage();
        loginPage.getInputFieldEmail().setValue(email);
        loginPage.getInputFieldPassword().setValue(password);
     //   sleep(2000);
        loginPage.clickLogin();
        //проверка что открылась главная страница СОБЕРИТЕ БУРГЕР
        mainPage.waitForLoadMainPage();
     //   sleep(2000);
        mainPage.clickLkButton();
        PageObjectLkPage lkPage = page(PageObjectLkPage.class);
        lkPage.waitForLoadLkPage();
     //   sleep(2000);
        lkPage.clickExitButton();
        loginPage.waitForLoadLoginPage();
      //  sleep(2000);

    }
}
