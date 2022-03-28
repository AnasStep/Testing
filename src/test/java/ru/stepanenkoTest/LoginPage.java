package ru.stepanenkoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    private static final By loginXpath = By.xpath("//*[contains(@class, 'it h-mod') and contains(@name, 'st.email')]");
    private static final By passwordXpath = By.xpath("//*[contains(@class, 'it') and contains(@name, 'st.password')]");
    private static final By buttonXpath = By.xpath("//*[contains(@class, 'button-pro __wide') and contains(@data-l, 't,sign_in')]");

    public MainPage login(WebDriver webDriver, User user) {
        WebElement element;
        element = webDriver.findElement(loginXpath);
        element.sendKeys(user.getLogin());
        element = webDriver.findElement(passwordXpath);
        element.sendKeys(user.getPassword());
        element = webDriver.findElement(buttonXpath);
        element.click();
        return (new MainPage(webDriver.getCurrentUrl()));
    }
}
