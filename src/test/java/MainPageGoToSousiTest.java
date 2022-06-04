import io.qameta.allure.Description;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import pageObject.PageObjectMainPageStellar;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPageGoToSousiTest {
    @Test
    @Description("Переход на главной странице в раздел Соусы конструктора")
    @DisplayName("Переход на главной странице в раздел Соусы конструктора через нажатие на раздел")
    public void GoToSousiTabInConstructorByClickingSousi() {
        // Для запуска в браузере EDGE
        //   Configuration.browser = Browsers.EDGE;
        sleep(2000);
        PageObjectMainPageStellar mainPage =  open("https://stellarburgers.nomoreparties.site", PageObjectMainPageStellar.class);
        mainPage.checkSousiUnActive();
        mainPage.clickSousiUnActive();
     //   sleep(5000);
        mainPage.checkSousiActive();

    }
}
