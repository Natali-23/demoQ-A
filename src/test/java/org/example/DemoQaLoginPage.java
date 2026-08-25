package org.example;

import io.qameta.allure.Step;
import org.junit.jupiter.api.condition.DisabledIfSystemProperties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoQaLoginPage {
    private final WebDriver driver;
    private final WebDriverWait wait;

    private final By loginLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By submitLocator = By.xpath("//button[@data-testid='login-submit']");

    public DemoQaLoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

@Step("username")
    public void Username(String username) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginLocator));
        element.clear();
        element.sendKeys(username);
    }
@Step("Password")
    public void Password(String password) {
        WebElement element = driver.findElement(passwordLocator);
        element.clear();
        element.sendKeys(password);
    }
@Step("Click Login Button")
    public void clickLoginButton() {
        WebElement element = driver.findElement(submitLocator);
        element.click();
    }


}
