package org.example.PageObjects;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By enterLocator = By.xpath("//button[@data-testid='login-submit']");
    private final By errorMessageLocator = By.xpath("//div[@class='text-sm [&_p]:leading-relaxed']");
    private final By transferMenuTabLocator = By.cssSelector("a[data-testid='nav-переводы']");

    public LoginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    @Step("вход по логину и паролю на других тестовых страницах")
    public LoginPage login(String username, String password) {
        driver.get("https://demoqa.ru/bank/login");
        WebElement nameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameLocator));
        nameElement.clear();
        nameElement.sendKeys(username);

        WebElement passwordElement = wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
        passwordElement.clear();
        passwordElement.sendKeys(password);
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(enterLocator));
        button.click();
        wait.until(ExpectedConditions.urlToBe("https://demoqa.ru/bank"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(transferMenuTabLocator));
        return this;
    }

    @Step("переход на страницу переводов денежных средств")
    public LoginPage clickToTransfer() throws InterruptedException {
        WebElement element = wait.until(
                ExpectedConditions.elementToBeClickable(transferMenuTabLocator));

        System.out.println("Перед кликом: " + driver.getCurrentUrl());
        System.out.println("href = " + element.getAttribute("href"));
        System.out.println("text = " + element.getText());
Thread.sleep(1000);
        element.click();

        System.out.println("После клика: " + driver.getCurrentUrl());

        wait.until(ExpectedConditions.urlToBe(
                "https://demoqa.ru/bank"));

        return this;
    }

//    @Step("переход на страницу переводов денежных средств")
//    public LoginPage clickToTransfer() {
//        WebElement element = wait.until(
//                ExpectedConditions.elementToBeClickable(transferMenuTabLocator));
//        element.click();
//        wait.until(ExpectedConditions.urlToBe(
//                "https://demoqa.ru/bank/transfer"));
//        return this;
//    }


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

    @Step("проверка выскакивания сообщения об ошибке")
    public boolean isErrorMessageDisplayed() {
        WebElement result = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));
        return result.isDisplayed();

    }

    @Step("проверка захода на сайт")
    public boolean isEnterSiteSuccess(String site) {
        return wait.until(ExpectedConditions.urlToBe(site));
    }
}