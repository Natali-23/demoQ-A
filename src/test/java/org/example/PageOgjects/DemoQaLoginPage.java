package org.example.PageOgjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DemoQaLoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By enterLocator = By.xpath("//button[@data-testid='login-submit']");


    public DemoQaLoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("вход на сайт")
    public DemoQaLoginPage open(){
        driver.get("https://demoqa.ru/bank/login");
        return this;
    }
    @Step("ввести имя пользователя")
    public DemoQaLoginPage username(String username) {
        WebElement name = wait.until(ExpectedConditions.elementToBeClickable(usernameLocator));
        name.clear();
        name.sendKeys(username);
        return this;
    }

    @Step("ввести пароль")
    public DemoQaLoginPage password(String pass) {
        WebElement password = driver.findElement(passwordLocator);
        password.clear();
        password.sendKeys(pass);
        return this;
    }

    @Step("нажать на кнопку войти")
    public DemoQaLoginPage enterButton(){
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(enterLocator));
        button.click();
        return this;

    }

    @Step("проверка логина")
    public String getUsernameValue(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator)).getAttribute("value");
    }

    @Step("проверка пароля")
    public String getPasswordValue(){
        return wait.until(ExpectedConditions.visibilityOfElementLocated(passwordLocator)).getAttribute("value");
    }

}