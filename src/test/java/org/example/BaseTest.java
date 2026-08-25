package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {
    private WebDriver driver;

    @BeforeEach
    public void setup(){
        driver = new ChromeDriver();
    }


    public WebDriver getDriver() {
        return driver;
    }

    @AfterEach
    public void teardown(){
        driver.quit();
    }
}
