package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class PageObjectForgotPasswordPage {

    //1.Войти ссылка на странице "восстановление пароля"
    @FindBy(how = How.LINK_TEXT,using = "Войти")
    private SelenideElement loginLink;
    public void clickLoginLink() {
        loginLink.click();
    }


}
