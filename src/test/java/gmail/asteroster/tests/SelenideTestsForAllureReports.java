package gmail.asteroster.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


@Owner("LutSerg")
@Severity(SeverityLevel.BLOCKER)
@Feature("Задачи в репозитории")
@Story("Просмотр названий зачад в репозитории")
@Link(value = "Тестовый сайт", url = "https://github.com/")

public class SelenideTestsForAllureReports {
    @Test
    @DisplayName("Проверка названия Issue")
    void simpleSelenideTestWithListener () {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("https://github.com/");

        $(".header-search-input").click();
        $(".header-search-input").sendKeys("eroshenkoam/allure-example");
        $(".header-search-input").submit();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $(By.partialLinkText("Issues")).click();
        $(withText("Listeners NamedBy")).shouldBe(Condition.visible);
    }
}
