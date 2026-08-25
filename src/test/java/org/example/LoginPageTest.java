package org.example;

import io.qameta.allure.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;

@Epic("Элементы интерфейса")
@Feature("Взаимодействие с сайтом")
public class LoginPageTest extends BaseTest {
    DemoQaLoginPage demoQaLogin;

    @BeforeEach
    public void setupPage(){
        demoQaLogin = new DemoQaLoginPage(getDriver());
    }


@Test
@Story("Удачный вход в банк")
@DisplayName("вход в банк по логину и паролю")
@Severity(SeverityLevel.CRITICAL)
public void enterInBank(){
    getDriver().get("https://demoqa.ru/bank/login");
demoQaLogin.Username("testuser");
demoQaLogin.Password("password");
demoQaLogin.clickLoginButton();
    Assertions.assertEquals(
            "testuser",
            getDriver().findElement(By.id("username")).getAttribute("value")
    );

    Assertions.assertEquals("password",getDriver().findElement(By.id("password")).getAttribute("value"));
 //   Assertions.assertEquals("https://demoqa.ru/bank",getDriver().getCurrentUrl());
}
}
