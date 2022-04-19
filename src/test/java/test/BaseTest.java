package test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public abstract class BaseTest {
    protected static WebDriver driver;

    // is it important to get driver in each usage?
    // look at base page
    @BeforeAll
    static void setDriver() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ok.ru");
    }

    @AfterAll
    static void quitDriver() {
        driver.quit();
    }
}
