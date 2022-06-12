package pageobject;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageObjectForgotPasswordPage {
    //1.Войти ссылка на странице "восстановление пароля"
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginLink;

    //2.Клик по ссылке
    @Step("Клик по ссылке войти(страница восстановления пароля)")
    public void clickLoginLink() {
        loginLink.click();
    }
}