package pageobject;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static java.time.Duration.ofSeconds;

public class PageObjectMainPageStellar {
    //1.кнопка личный кабинет
    @FindBy(how = How.XPATH, using = ".//a[@href='/account']")
    private SelenideElement lkButton;
    //2.кнопка "Войти" в аккаунт
    @FindBy(how = How.XPATH, using = ".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;
    //3.локатор надписи "Соберите бургер"(для проверки открытия главной страницы)
    @FindBy(how = How.XPATH, using = ".//section[@class='BurgerIngredients_ingredients__1N8v2']/h1[text()='Соберите бургер']")
    private SelenideElement soberiteBurgerHead;
    //4.вкладка булки(в конструкторе) активная
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private SelenideElement bulkiIsActive;
    //5.вкладка булки(в конструкторе) неактивная
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private SelenideElement bulkiIsInActive;
    //6.вкладка соусы(в конструкторе) активная
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private SelenideElement sousiIsActive;
    //7.вкладка соусы(в конструкторе) неактивная
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private SelenideElement sousiIsInActive;
    //8.вкладка Начинки(в конструкторе) активная
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private SelenideElement nachinkiIsActive;
    //9.вкладка Начинки(в конструкторе) неактивная
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private SelenideElement nachinkiIsInActive;

    //10.клик по кнопке Личный кабинет
    @Step("Клик по кнопке Личный кабинет(главная страница)")
    public void clickLkButton() {
        lkButton.click();
    }

    //11.Клик по кнопке "Войти"
    @Step("Клик по кнопке Войти(главная страница)")
    public void clickLogin() {
        loginButton.click();
    }

    //12.Метод ожидания загрузки страницы: проверили видимость надписи "Соберите бургер"
    @Step("Ожидание загрузки главной страницы - ждем появления надписи Соберите бургер")
    public void waitForLoadMainPage() {
        soberiteBurgerHead.shouldBe(Condition.visible, ofSeconds(8));
    }

    //13.Проверка видимости вкладки булки
    @Step("Проверка видимости активной вкладки Булки в конструкторе(главная страница)")
    public void checkBulkiActive() {
        bulkiIsActive.shouldBe(Condition.visible);
    }

    //14.Клик по вкладке Булки(когда неактивная)
    @Step("Клик по неактивной вкладке Булки(главная страница)")
    public void clickBulkiUnActive() {
        bulkiIsInActive.click();
    }

    //15.Проверка видимости вкладки Булки
    @Step("Проверка видимости неактивной вкладки Булки в конструкторе(главная страница)")
    public void checkBulkiUnActive() {
        bulkiIsInActive.shouldBe(Condition.visible);
    }

    //16.Проверка видимости вкладки Соусы
    @Step("Проверка видимости активной вкладки Соусы в конструкторе(главная страница)")
    public void checkSousiActive() {
        sousiIsActive.shouldBe(Condition.visible);
    }

    //17.Клик по вкладке Соусы(когда неактивная)
    @Step("Клик по неактивной вкладке Соусы(главная страница)")
    public void clickSousiUnActive() {
        sousiIsInActive.click();
    }

    //18.Проверка видимости вкладки Соусы
    @Step("Проверка видимости неактивной вкладки Соусы в конструкторе(главная страница)")
    public void checkSousiUnActive() {
        sousiIsInActive.shouldBe(Condition.visible);
    }

    //19.Проверка видимости вкладки Начинки
    @Step("Проверка видимости активной вкладки Начинки в конструкторе(главная страница)")
    public void checkNachinkiActive() {
        nachinkiIsActive.shouldBe(Condition.visible);
    }

    //20.Клик по вкладке Начинки(когда неактивная)
    @Step("Клик по неактивной вкладке Начинки(главная страница)")
    public void clickNachinkiUnActive() {
        nachinkiIsInActive.click();
    }

    //21.Проверка видимости вкладки Начинки
    @Step("Проверка видимости неактивной вкладки Начинки в конструкторе(главная страница)")
    public void checkNachinkiUnActive() {
        nachinkiIsInActive.shouldBe(Condition.visible);
    }
}
