package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static java.time.Duration.ofSeconds;

public class PageObjectLkPage {
    //1.локатор ссылки "Профиль"(для проверки открытия страницы)
    @FindBy(how = How.LINK_TEXT, using = "Профиль")
    private SelenideElement accountLink;
    //2.Логотип Stellar Burgers для перехода на главную/конструктор
    @FindBy(how = How.XPATH, using = ".//a[@href='/']")
    private SelenideElement logoStellarisBurgers;
    //3.Кнопка Конструктор в Личном Кабинете
    @FindBy(how = How.XPATH, using = ".//a[@href='/']")
    private SelenideElement constructorButton;
    //4.кнопка "Выход" в личном кабинете
    @FindBy(how = How.XPATH, using = ".//li[@class='Account_listItem__35dAP']/button[text()='Выход']")
    private SelenideElement exitButton;

    //5.Ожидание загрузки страницы ЛК(ждем появления надписи "Профили")
    @Step("Ожидание загрузки страницы ЛК - ждем появления надписи Профили")
    public void waitForLoadLkPage() {
        accountLink.shouldBe(Condition.visible, ofSeconds(8));
    }

    //6. Клик по логотипу Stellar Burgers
    @Step("Клик по логотипу Stellar Burgers(страница личного кабинета)")
    public void clicklogoStellarisBurgers() {
        logoStellarisBurgers.click();
    }

    //7.Клик по кнопке Конструктор
    @Step("Клик по кнопке корнструктор(страница личного кабинета)")
    public void clickConstructorButton() {
        constructorButton.click();
    }

    //8.Клик по кнопке Выход
    @Step("Клик по выход(страница личного кабинета)")
    public void clickExitButton() {
        exitButton.click();
    }
}
