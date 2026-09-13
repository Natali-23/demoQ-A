package org.example.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NewPersonPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By firstNameLocator = By.id("firstName");
    private final By lastNameLocator = By.id("lastName");
    private final By emailLocator = By.id("email");
    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By confirmPasswordLocator = By.id("confirmPassword");
    private final By registerButtonLocator =
            By.xpath("//button[@data-testid = 'register-submit']");
    private final By passwordDontMatchLocator = By.xpath("//*[@data-testid='register-confirm-password-error']");

    public NewPersonPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("проверка активности кнопки зарегистрироваться")
    public boolean isRegisterButtonDisplayed() {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(registerButtonLocator));
        return !element.isEnabled();
    }

    @Step("проверка что пароли не совпадают")
    public boolean isPasswordDontMatch() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordDontMatchLocator));
        return true;
    }

    @Step("Открытие страницы регистрации")
    public NewPersonPage site(String site) {
        driver.get(site);
        wait.until(ExpectedConditions.urlToBe(site));
        return this;
    }

    @Step("Ввод имени пользователя")
    public NewPersonPage firstName(String firstName) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(firstNameLocator));
        element.clear();
        element.sendKeys(firstName);
        return this;
    }

    @Step("Ввод фамилии пользователя")
    public NewPersonPage lastName(String lastName) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(lastNameLocator));
        element.clear();
        element.sendKeys(lastName);
        return this;
    }

    @Step("Ввод email")
    public NewPersonPage email(String email) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(emailLocator));
        element.clear();
        element.sendKeys(email);
        return this;
    }

    @Step("Ввод имени пользователя")
    public NewPersonPage username(String username) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(usernameLocator));
        element.clear();
        element.sendKeys(username);
        return this;
    }

    @Step("Ввод пароля")
    public NewPersonPage password(String password) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(passwordLocator));
        element.clear();
        element.sendKeys(password);
        return this;
    }

    @Step("Ввод подтверждения пароля")
    public NewPersonPage confirmPassword(String confirmPassword) {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(confirmPasswordLocator));
        element.clear();
        element.sendKeys(confirmPassword);
        return this;
    }

    @Step("Нажатие кнопки регистрации")
    public NewPersonPage registerButton() {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(registerButtonLocator));
        element.click();
        return this;
    }

    @Step("Проверка успешной регистрации")
    public boolean isRegistrationSuccess(String site) {
        return wait.until(ExpectedConditions.urlToBe(site));
    }

    @Step("Проверка неуспешной регистрации")
    public boolean isRegistrationFail(String site) {
        return !driver.getCurrentUrl().equals(site);
    }

}