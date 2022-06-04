package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

import static java.time.Duration.ofSeconds;

public class PageObjectRegisterPage {

    //1.страница регистрации (для проверки открытия страницы)
    // метод ожидания загрузки страницы: проверили видимость надписи "Регистрация"
    public void waitForLoadRegisterPage(){
        $(byText("Регистрация")).shouldBe(visible,ofSeconds(8));
    }

    //2.коллекция инпутов(поля ввода email,password и name)
    @FindBy(how = How.CSS, using = "input.text.input__textfield.text_type_main-default")
    private ElementsCollection inputFieldsForRegister;

    public SelenideElement getInputFieldName(){

        return this.inputFieldsForRegister.get(0);
    }
    public SelenideElement getInputFieldPassword(){

        return this.inputFieldsForRegister.get(2);
    }
    public SelenideElement getInputFieldEmail(){

        return this.inputFieldsForRegister.get(1);
    }

    //3.Кнопка зарегистрироваться
    @FindBy(how = How.XPATH,using = ".//form[@class='Auth_form__3qKeq mb-20']/button[text()='Зарегистрироваться']")
    //  @FindBy(how = How.CSS,using = "button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa")
    private SelenideElement registerButton;

    //4.Нажатие кнопки зарегистрироваться
    public void clickRegister() {
        registerButton.click();
    }

    //5.Войти ссылка на странице регистрации
    @FindBy(how = How.LINK_TEXT,using = "Войти")
    private SelenideElement loginLink;

    //6.Клик по ссылке "войти"
    public void clickLoginLink() {
        loginLink.click();
    }

    //7.Подсказка об некорректном пароле
    @FindBy(how = How.XPATH,using = ".//div[@class='input__container']/p[text()='Некорректный пароль']")
    private SelenideElement incorrectPasswordError;

    //8.Видимость подсказки о некорректном пароле
    public void incorrectPasswordNotification() {
        incorrectPasswordError.shouldBe(visible);
    }

}
