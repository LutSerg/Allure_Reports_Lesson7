package gmail.asteroster.tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Owner("LutSerg")
@Severity(SeverityLevel.BLOCKER)
@Feature("Задачи в репозитории")
@Story("Просмотр названий зачад в репозитории")
@Link(value = "Тестовый сайт", url = "https://github.com/")

public class TestWithStepAnnotation {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private static final String ISSUENAME = "Listeners NamedBy";

    @Test
    @DisplayName("Тест с использованием аннотации Step")
    void annotationTest () {
    SelenideLogger.addListener("allure", new AllureSelenide());
    WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.shouldSeeIssueWithName(ISSUENAME);
    }
}
