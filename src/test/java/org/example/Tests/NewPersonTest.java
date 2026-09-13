package org.example.Tests;

import io.qameta.allure.*;
import org.example.BaseTest;
import org.example.LinksUrl;
import org.example.PageObjects.NewPersonPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@Epic("Регистрация пользователя")
@Feature("Регистрация")
public class NewPersonTest extends BaseTest {

    private NewPersonPage newPersonPage;

    @BeforeEach
    public void setUp() {
        newPersonPage = new NewPersonPage(getDriver(), getWait());
    }

    @Test
    @Story("Удачная регистрация пользователя")
    @DisplayName("Регистрация нового пользователя")
    @Severity(SeverityLevel.CRITICAL)
    public void newPersonSuccessTest() {

        newPersonPage.site(LinksUrl.REGISTRURL)
                .firstName("IvanTestUser")
                .lastName("IvanovTestUser")
                .email("test@mail.ru")
                .username("test")
                .password("testpassword")
                .confirmPassword("testpassword")
                .registerButton();

        Assertions.assertTrue(
                newPersonPage.isRegistrationSuccess("https://demoqa.ru/bank"),
                "Пользователь не был зарегистрирован");
    }


    @Test
    @Story("неуспешная регистрация пользователя без имени")
    @DisplayName("Регистрация нового пользователя без имени")
    @Severity(SeverityLevel.CRITICAL)
    public void registrationWithoutFirstNameTest() {
        newPersonPage
                .site("https://demoqa.ru/bank/register")
                .firstName("")
                .lastName("Ivanov")
                .email("test@mail.ru")
                .username("user1")
                .password("pass123")
                .confirmPassword("pass123")
                .registerButton();
        Assertions.assertTrue(
                newPersonPage.isRegistrationFail("https://demoqa.ru/bank"),
                "Регистрация прошла успешно");
    }

    @Test
    @Story("Неуспешная регистрация пользователя без фамилии")
    @DisplayName("Регистрация нового пользователя без фамилии")
    @Severity(SeverityLevel.CRITICAL)
    public void registrationWithoutLastNameTest() {
        newPersonPage
                .site("https://demoqa.ru/bank/register")
                .firstName("Ivan")
                .lastName("")
                .email("test@mail.ru")
                .username("user1")
                .password("pass123")
                .confirmPassword("pass123")
                .registerButton();
        Assertions.assertTrue(
                newPersonPage.isRegistrationFail("https://demoqa.ru/bank"),
                "Регистрация прошла успешно");
    }

    @Test
    @Story("неуспешная регистрация пользователя без имейла")
    @DisplayName("Регистрация нового пользователя без имейла")
    @Severity(SeverityLevel.CRITICAL)
    public void registrationWithoutEmailTest() {
        newPersonPage
                .site("https://demoqa.ru/bank/register")
                .firstName("Ivan")
                .lastName("Ivanov")
                .email("")
                .username("user1")
                .password("pass123")
                .confirmPassword("pass123")
                .registerButton();
        Assertions.assertTrue(
                newPersonPage.isRegistrationFail("https://demoqa.ru/bank"),
                "Регистрация прошла успешно");
    }

    @Test
    @Story("неуспешная регистрация пользователя без имейла")
    @DisplayName("Регистрация нового пользователя без имейла")
    @Severity(SeverityLevel.CRITICAL)
    public void registrationWithWrongEmailTest() {
        newPersonPage
                .site("https://demoqa.ru/bank/register")
                .firstName("Ivan")
                .lastName("Ivanov")
                .email("test.tu")
                .username("user1")
                .password("pass123")
                .confirmPassword("pass123")
                .registerButton();
        Assertions.assertTrue(
                newPersonPage.isRegistrationFail("https://demoqa.ru/bank"),
                "Регистрация прошла успешно");
    }

    @Test
    @Story("Неуспешная регистрация пользователя без логина")
    @DisplayName("Регистрация нового пользователя без логина")
    @Severity(SeverityLevel.CRITICAL)
    public void registrationWithoutUsernameTest() {
        newPersonPage
                .site("https://demoqa.ru/bank/register")
                .firstName("Ivan")
                .lastName("Ivanov")
                .email("test@mail.ru")
                .username("")
                .password("pass123")
                .confirmPassword("pass123")
                .registerButton();
        Assertions.assertTrue(
                newPersonPage.isRegistrationFail("https://demoqa.ru/bank"),
                "Регистрация прошла успешно");
    }

    @Test
    @Story("Неуспешная регистрация пользователя без пароля")
    @DisplayName("Регистрация нового пользователя без пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void registrationWithoutPasswordTest() {
        newPersonPage
                .site("https://demoqa.ru/bank/register")
                .firstName("Ivan")
                .lastName("Ivanov")
                .email("test@mail.ru")
                .username("user1")
                .password("")
                .confirmPassword("")
                .registerButton();
        Assertions.assertTrue(
                newPersonPage.isRegistrationFail("https://demoqa.ru/bank"),
                "Регистрация прошла успешно");
    }

    @Test
    @Story("Неуспешная регистрация пользователя без пароля")
    @DisplayName("Регистрация нового пользователя без пароля")
    @Severity(SeverityLevel.CRITICAL)
    public void registrationWithoutSamePasswordTest() {
        newPersonPage
                .site("https://demoqa.ru/bank/register")
                .firstName("Ivan")
                .lastName("Ivanov")
                .email("test@mail.ru")
                .username("user1")
                .password("1234")
                .confirmPassword("4321");

        Assertions.assertTrue(newPersonPage.isPasswordDontMatch(), "Ошибка о несовпадении паролей не появилась");
        Assertions.assertTrue(newPersonPage.isRegisterButtonDisplayed(), "Кнопка регистрации осталась активной!");
        Assertions.assertTrue(
                newPersonPage.isRegistrationFail("https://demoqa.ru/bank"),
                "Регистрация прошла успешно");

    }
}