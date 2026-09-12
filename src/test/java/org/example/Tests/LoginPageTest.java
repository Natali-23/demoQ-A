package org.example.Tests;


import io.qameta.allure.*;
import org.example.BaseTest;
import org.example.PageObjects.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@Epic("Элементы интерфейса")
@Feature("Взаимодействие с сайтом")
public class LoginPageTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeEach
    public void setupPage() {
        loginPage = new LoginPage(getDriver(), getWait());
    }

    @Test
    @Story("Удачный вход в банк")
    @DisplayName("вход в банк по правильному логину и паролю")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest() {

        loginPage.open()
                .username("testuser")
                .password("password")
                .enterButton();
        Assertions.assertTrue(loginPage.isEnterSiteSuccess("https://demoqa.ru/bank"), "Переход в личный кабинет не выполнен после ввода верных данных");
    }

    @ParameterizedTest(name = "Запуск #{index}: Проверка с паролем [{0}]")
    @ValueSource(strings = {"wrongpassword", "  "})
    @Story(" вход в банк с неправильным паролем")
    @DisplayName("вход в банк с неправильным паролем")
    @Severity(SeverityLevel.CRITICAL)
    public void negativeLoginTest(String wrongPassword) {

        loginPage.open()
                .username("testuser")
                .password(wrongPassword)
                .enterButton();
        Assertions.assertTrue(loginPage.isErrorMessageDisplayed(), "Сообщение об ошибке не появилось после ввода неверного пароля");
    }


}