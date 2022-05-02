package gmail.asteroster.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;

@Owner("LutSerg")
@Severity(SeverityLevel.BLOCKER)
@Feature("Задачи в репозитории")
@Story("Просмотр названий зачад в репозитории")
@Link(value = "Тестовый сайт", url = "https://github.com/")

public class LambdaWithStepTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUENAME = "Listeners NamedBy";

    @Test
    @DisplayName("Тест с проверкой названия Issue с лямбда тестом")
    void testWithLambdaSteps () {
    SelenideLogger.addListener("allure", new AllureSelenide());
    step("Открываем главную страницу", () -> {
        open("https://github.com/");
            });

    step("Ищем реопзиторий " + REPOSITORY, () -> {
            $(".header-search-input").click();
            $(".header-search-input").sendKeys(REPOSITORY);
            $(".header-search-input").submit();
    });

    step("Переходим по ссылке репозитория " + REPOSITORY, () -> {
        $(By.linkText(REPOSITORY)).click();
    });

    step("Проверяем что существует Issue с названием " + ISSUENAME, () -> {
        $(By.partialLinkText("Issues")).click();
        $(withText(ISSUENAME)).shouldBe(Condition.visible);
        Allure.getLifecycle().addAttachment(
                "Исходник страницы,",
                "text/html",
                "html",
                WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8));
            }
    );

        }
}
