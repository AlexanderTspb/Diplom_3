package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class PageObjectLkPage {

    //1.страница личного кабинета (для проверки открытия страницы)
    // метод ожидания загрузки страницы: проверили видимость надписи "Профиль"
    public void waitForLoadLkPage(){
        $(byText("Профиль")).shouldBe(visible,ofSeconds(8));
    }

    //2.Логотип Stellar Burgers для перехода на главную/конструктор
    @FindBy(how = How.XPATH,using = ".//a[@href='/']")
    private SelenideElement logoStellarisBurgers;
    public void clicklogoStellarisBurgers() {
        logoStellarisBurgers.click();
    }

    //3.Кнопка Конструктор в Личном Кабинете
    @FindBy(how = How.XPATH,using = ".//a[@href='/']")
    private SelenideElement constructorButton;
    public void clickConstructorButton() {
        constructorButton.click();
    }

    //4.кнопка выход в личном кабинете
    @FindBy(how = How.XPATH,using = ".//li[@class='Account_listItem__35dAP']/button[text()='Выход']")
    //  @FindBy(how = How.CSS,using = "button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa")
    private SelenideElement exitButton;
    public void clickExitButton() {
        exitButton.click();
    }

}
