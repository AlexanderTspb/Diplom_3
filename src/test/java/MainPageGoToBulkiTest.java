import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageobject.PageObjectMainPageStellar;

import static com.codeborne.selenide.Selenide.*;

public class MainPageGoToBulkiTest {
    @Test
    @Description("Переход на главной странице в раздел булки конструктора")
    @DisplayName("Переход на главной странице в раздел Булки конструктора через нажатие на раздел")
    public void GoToBulkiTabInConstructorByClickingBulki() {
        // Для запуска в браузере EDGE
        //   Configuration.browser = Browsers.EDGE;
        PageObjectMainPageStellar mainPage = open("https://stellarburgers.nomoreparties.site", PageObjectMainPageStellar.class);
        mainPage.checkBulkiActive();
        mainPage.clickNachinkiUnActive();
        mainPage.checkBulkiUnActive();
        mainPage.clickBulkiUnActive();
        mainPage.checkBulkiActive();
    }
}
