package org.example.Tests;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.example.PageOgjects.NewPersonPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("регистрация пользователя")
@Feature("регистрация")
public class NewPersonTest extends BaseTest {
private NewPersonPage newPersonPage;

@BeforeEach
public void setUp() {
    newPersonPage = new NewPersonPage(getDriver(),getWait());
}

@Test
@Story("удачная регистрация пользователя")
@DisplayName("регистрация нового пользователя")
@Severity(SeverityLevel.BLOCKER)
    public void newPersonTest(){
    newPersonPage.site("https://demoqa.ru/bank/register");
   newPersonPage.firstName("Ivan")
           .lastName("Ivanov")
           .email("test@mail.ru")
           .username("test")
           .password("testpassword")
           .confirmPassword("testpassword")
           .registerButton();

}

}
