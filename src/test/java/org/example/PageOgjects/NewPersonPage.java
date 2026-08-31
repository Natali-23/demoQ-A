package org.example.PageOgjects;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Epic("Элементы интерфейса")
@Feature("Взаимодействие с сайтом")
public class NewPersonPage {
    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    private WebDriverWait wait;
    private WebDriver driver;

    private final By firstNameLocator = By.id("firstName");
    private final By lastNameLocator = By.id("lastName");
    private final By emailLocator = By.id("email");
    private final By usernameLocator = By.id("username");
    private final By passwordLocator = By.id("password");
    private final By confirmPasswordLocator = By.id("confirmPassword");
    private final By registerButtonLocator = By.xpath("//button[@data-testid = 'register-submit']");

    public NewPersonPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public NewPersonPage site(String site) {
        driver.get(site);
        wait.until(ExpectedConditions.urlToBe(site));
        return this;
    }
    @Step("ввод имени пользователя")
    public NewPersonPage firstName(String firstName){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(firstNameLocator));
        element.clear();
        element.sendKeys(firstName);
        return this;
    }

    @Step("ввод фамилии пользователя")
    public NewPersonPage lastName(String lastName){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(lastNameLocator));
       element.clear();
       element.sendKeys(lastName);
        return  this;
    }

    @Step("ввод пароля")
    public NewPersonPage email(String email){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(emailLocator));
        element.clear();
        element.sendKeys(email);
        return this;
    }

    @Step("ввод имени пользователя")
public NewPersonPage username(String username){
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(usernameLocator));
       element.clear();
       element.sendKeys(username);
        return this;
    }

    @Step("ввод паспорта")
public NewPersonPage password(String password){
       WebElement element = wait.until(ExpectedConditions.elementToBeClickable(passwordLocator));
       element.clear();
       element.sendKeys(password);
        return this;
    }

    @Step("ввод повторения паспорта")
    public NewPersonPage confirmPassword(String confirmPassword){
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(confirmPasswordLocator));
        element.clear();
        element.sendKeys(confirmPassword);
        return this;
    }

    @Step("нажатие кнопки зарегестрироваться")
    public void registerButton(){
        driver.findElement(registerButtonLocator).click();

    }

}
