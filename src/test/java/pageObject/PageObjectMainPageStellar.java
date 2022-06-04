package pageObject;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static java.time.Duration.ofSeconds;

public class PageObjectMainPageStellar {

    //1.кнопка личный кабинет
    @FindBy(how = How.XPATH,using = ".//a[@href='/account']")
    private SelenideElement lkButton;
    public void clickLkButton() {
        lkButton.click();
    }

    //2.кнопка "Войти" в аккаунт
    //  @FindBy(how = How.CSS,using = "button.button_button__33qZ0.button_button_type_primary__1O7Bx.button_button_size_medium__3zxIa")
    @FindBy(how = How.XPATH,using = ".//div[@class='BurgerConstructor_basket__container__2fUl3 mt-10']/button[text()='Войти в аккаунт']")
    private SelenideElement loginButton;

    //3.Клик по кнопке "Войти"
    public void clickLogin() {
        loginButton.click();
    }

    //4.страница главная (для проверки открытия страницы)
    // метод ожидания загрузки страницы: проверили видимость надписи "Соберите бургер"
    public void waitForLoadMainPage(){
        $(byText("Соберите бургер")).shouldBe(visible,ofSeconds(8));
    }

    //-----БУЛКИ-----

    //5.вкладка булки(в конструкторе) активная
    //<div class="tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"><span class="text text_type_main-default">Булки</span></div>
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private SelenideElement bulkiIsActive;

    //6.Проверка видимости вкладки
    public void checkBulkiActive()
    {
        bulkiIsActive.shouldBe(visible);
    }

    //7.вкладка булки(в конструкторе) неактивная
    //<div class="tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect"><span class="text text_type_main-default">Булки</span></div>
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки']")
    private SelenideElement bulkiIsInActive;

    //7.Клик по вкладке Булки(когда неактивная)
    public void clickBulkiUnActive() {
        bulkiIsInActive.click();
    }

    //8.Проверка видимости вкладки Булки
    public void checkBulkiUnActive()
    {
        bulkiIsInActive.shouldBe(visible);
    }

    //---------СОУСЫ---------------

    //9.вкладка соусы(в конструкторе) активная
    //<div class="tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"><span class="text text_type_main-default">Булки</span></div>
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private SelenideElement sousiIsActive;

    //10.Проверка видимости вкладки Соусы
    public void checkSousiActive()
    {
        sousiIsActive.shouldBe(visible);
    }

    //11.вкладка соусы(в конструкторе) неактивная
    //@FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки>']")
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Соусы']")
    private SelenideElement sousiIsInActive;

    //12.Клик по вкладке Соусы(когда неактивная)
    public void clickSousiUnActive() {
        sousiIsInActive.click();
    }

    //13.Проверка видимости вкладки Соусы
    public void checkSousiUnActive()
    {
        sousiIsInActive.shouldBe(visible);
    }

    //------------Начинки-----------------

    //14.вкладка Начинки(в конструкторе) активная
    //<div class="tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect"><span class="text text_type_main-default">Булки</span></div>
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private SelenideElement nachinkiIsActive;

    //15.Проверка видимости вкладки Начинки
    public void checkNachinkiActive()
    {
        nachinkiIsActive.shouldBe(visible);
    }

    //16.вкладка Начинки(в конструкторе) неактивная
    //@FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG tab_tab_type_current__2BEPc pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Булки>']")
    @FindBy(how = How.XPATH, using = ".//div[@class='tab_tab__1SPyG  pt-4 pr-10 pb-4 pl-10 noselect']/span[text()='Начинки']")
    private SelenideElement nachinkiIsInActive;

    //17.Клик по вкладке Начинки(когда неактивная)
    public void clickNachinkiUnActive() {
        nachinkiIsInActive.click();
    }

    //18.Проверка видимости вкладки Начинки
    public void checkNachinkiUnActive()
    {
        nachinkiIsInActive.shouldBe(visible);
    }

}
