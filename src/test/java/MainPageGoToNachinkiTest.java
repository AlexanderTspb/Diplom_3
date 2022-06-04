import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.PageObjectMainPageStellar;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPageGoToNachinkiTest {
    @Test
    @Description("Переход на главной странице в раздел начинки конструктора")
    @DisplayName("Переход на главной странице в раздел Начинки конструктора через нажатие на раздел")
    public void GoToNachinkiTabInConstructorByClickingNachinki() {
        // Для запуска в браузере EDGE
        //   Configuration.browser = Browsers.EDGE;
        sleep(2000);
        PageObjectMainPageStellar mainPage =  open("https://stellarburgers.nomoreparties.site", PageObjectMainPageStellar.class);
        mainPage.checkNachinkiUnActive();
        mainPage.clickNachinkiUnActive();
    //    sleep(5000);
        mainPage.checkNachinkiActive();

    }
}
