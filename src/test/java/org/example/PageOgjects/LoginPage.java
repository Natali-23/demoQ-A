package org.example.PageOgjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By enterLocator = By.xpath("//button[@data-testid='login-submit']");
    private final By errorMessageLocator = By.xpath("//div[@class='text-sm [&_p]:leading-relaxed']");


    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("вход на сайт")
    public LoginPage open() {
        driver.get("https://demoqa.ru/bank/login");
        return this;
    }

    @Step("ввести имя пользователя")
    public LoginPage username(String username) {
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(usernameLocator));
        name.clear();
        name.sendKeys(username);
        return this;
    }

    @Step("ввести пароль")
    public LoginPage password(String pass) {
        WebElement password = driver.findElement(passwordLocator);
        password.clear();
        password.sendKeys(pass);
        return this;
    }

    @Step("нажать на кнопку войти")
    public LoginPage enterButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(enterLocator));
        button.click();
        return this;

    }

    @Step("проверка логина")
    public String getUsernameValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator)).getAttribute("value");
    }

    @Step("проверка пароля")
    public String getPasswordValue() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator)).getAttribute("value");
    }

    @Step("проверка выскакивания сообщения об ошибке")
    public boolean isErrorMessageDisplayed() {
        try {
            WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
            return result.isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    @Step("проверка захода на сайт")
    public boolean isEnterSiteSuccess(String site) {
        try {
            wait.until(ExpectedConditions.urlToBe(site));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
}