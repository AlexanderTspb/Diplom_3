package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static java.time.Duration.ofSeconds;

public class PageObjectRegisterPage {

    //1.страница регистрации (для проверки открытия страницы)
    //локатор надписи "Регистрация"
    @FindBy(how = How.XPATH, using = ".//div[@class='Auth_login__3hAey']/h2[text()='Регистрация']")
    private SelenideElement registerHead;
    //2.коллекция инпутов(поля ввода email,password и name)
    @FindBy(how = How.CSS, using = "input.text.input__textfield.text_type_main-default")
    private ElementsCollection inputFieldsForRegister;
    //3.Кнопка зарегистрироваться
    @FindBy(how = How.XPATH, using = ".//form[@class='Auth_form__3qKeq mb-20']/button[text()='Зарегистрироваться']")
    private SelenideElement registerButton;
    //4.Войти ссылка на странице регистрации
    @FindBy(how = How.LINK_TEXT, using = "Войти")
    private SelenideElement loginLink;
    //5.Подсказка об некорректном пароле
    @FindBy(how = How.XPATH, using = ".//div[@class='input__container']/p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordError;

    //6.метод ожидания загрузки страницы: проверили видимость надписи "Регистрация"
    @Step("Ожидание загрузки страницы регистрации - ждем появления надписи Регистрация")
    public void waitForLoadRegisterPage() {
        registerHead.shouldBe(Condition.visible, ofSeconds(8));
    }

    //7.вернуть поле ввода name
    @Step("Вернуть поле для ввода Name(страница регистрации)")
    public SelenideElement getInputFieldName() {
        return this.inputFieldsForRegister.get(0);
    }

    //.вернуть поле ввода password
    @Step("Вернуть поле для ввода Password(страница регистрации)")
    public SelenideElement getInputFieldPassword() {
        return this.inputFieldsForRegister.get(2);
    }

    //.вернуть поле ввода email
    @Step("Вернуть поле для ввода Email(страница регистрации)")
    public SelenideElement getInputFieldEmail() {
        return this.inputFieldsForRegister.get(1);
    }

    //8.Нажатие кнопки зарегистрироваться
    @Step("Клик по кнопке Зарегистрироваться(страница регистрации)")
    public void clickRegister() {
        registerButton.click();
    }

    //9.Клик по ссылке "войти"
    @Step("Клик по кнопке Войти(страница регистрации)")
    public void clickLoginLink() {
        loginLink.click();
    }

    //10.Видимость подсказки о некорректном пароле
    @Step("Проверка видимости подсказки о некорректном пароле(страница регистрации)")
    public void incorrectPasswordNotification() {
        incorrectPasswordError.shouldBe(Condition.visible);
    }
}
