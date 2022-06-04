package pageObject;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class PageObjectLoginPage {

    //1.кнопка "зарегистрироваться"
    @FindBy(how = How.LINK_TEXT,using = "Зарегистрироваться")
    private SelenideElement registerLink;

    //2.клик по кнопке "зарегистрироваться"
    public void clickRegisterLink() {
        registerLink.click();
    }

    //3.страница авторизации (для проверки открытия страницы авторизации)
    public void waitForLoadLoginPage(){
        $(byText("Вход")).shouldBe(visible,ofSeconds(8));
    }

    //4.коллекция инпутов (поля ввода email и password)
    @FindBy(how = How.CSS, using = "input.text.input__textfield.text_type_main-default")
    private ElementsCollection inputFieldsForRegister;

    public SelenideElement getInputFieldEmail(){

        return this.inputFieldsForRegister.get(0);
    }
    public SelenideElement getInputFieldPassword(){

        return this.inputFieldsForRegister.get(1);
    }

    //5.кнопка войти на форме авторизации
    @FindBy(how = How.XPATH,using = ".//form[@class='Auth_form__3qKeq mb-20']/button[text()='Войти']")
  //  @FindBy(how = How.CSS,using = "button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa")
    private SelenideElement loginButton;
    //6.клик на кнопку войти
    public void clickLogin() {
        loginButton.click();
    }


}
