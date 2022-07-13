package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static java.time.Duration.ofSeconds;

public class PageObjectLoginPage {
    //1.кнопка "Зарегистрироваться"
    @FindBy(how = How.LINK_TEXT, using = "Зарегистрироваться")
    private SelenideElement registerLink;
    //2.локатор надписи "Вход"(для проверки открытия страницы авторизации)
    @FindBy(how = How.XPATH, using = ".//div[@class='Auth_login__3hAey']/h2[text()='Вход']")
    private SelenideElement loginHead;
    //3.коллекция инпутов (поля ввода email и password)
    @FindBy(how = How.CSS, using = "input.text.input__textfield.text_type_main-default")
    private ElementsCollection inputFieldsForRegister;
    //4.кнопка войти на форме авторизации
    @FindBy(how = How.XPATH, using = ".//form[@class='Auth_form__3qKeq mb-20']/button[text()='Войти']")
    //  @FindBy(how = How.CSS,using = "button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa")
    private SelenideElement loginButton;

    //5.клик по кнопке "зарегистрироваться"
    @Step("Клик по кнопке Зарегистрироваться(страница авторизации)")
    public void clickRegisterLink() {
        registerLink.click();
    }

    //6.страница авторизации (для проверки открытия страницы авторизации)
    @Step("Ожидание загрузки страницы авторизации - ждем появления надписи Вход")
    public void waitForLoadLoginPage() {
        loginHead.shouldBe(Condition.visible, ofSeconds(8));
    }

    //7.вернуть поле ввода email
    @Step("Вернуть поле для ввода Email(страница авторизации)")
    public SelenideElement getInputFieldEmail() {
        return this.inputFieldsForRegister.get(0);
    }

    //вернуть поле ввода password
    @Step("Вернуть поле для ввода Password(страница авторизации)")
    public SelenideElement getInputFieldPassword() {
        return this.inputFieldsForRegister.get(1);
    }

    //8.клик на кнопку войти
    @Step("Клик по кнопке Войти (страница авторизации)")
    public void clickLogin() {
        loginButton.click();
    }
}
