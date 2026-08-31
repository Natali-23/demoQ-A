package org.example.Tests;


import io.qameta.allure.*;
import org.example.BaseTest;
import org.example.PageOgjects.DemoQaLoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Элементы интерфейса")
@Feature("Взаимодействие с сайтом")
public class LoginPageTest extends BaseTest {
    private DemoQaLoginPage loginPage;
    @BeforeEach
    public void setupPage(){
        loginPage = new DemoQaLoginPage(getDriver(),getWait());
    }

    @Test
    @Story("Удачный вход в банк")
    @DisplayName("вход в банк по логину и паролю")
    @Severity(SeverityLevel.CRITICAL)
    public void loginTest(){

        loginPage.open()
                .username("testuser")
                .password("password")
                .enterButton();
        Assertions.assertEquals("testuser",loginPage.getUsernameValue());
        Assertions.assertEquals("password",loginPage.getPasswordValue());
    }

}