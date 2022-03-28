package ru.stepanenkoTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private static final By fullUserNameXpath = By.xpath("//*[contains(@class, 'tico ellip')]");
    private String fullUserName;
    private String url;

    MainPage(String url) {
        this.url = url;
    }

    public String getFullUserName (WebDriver webDriver) {
        WebElement userName = webDriver.findElement(fullUserNameXpath);
        fullUserName = userName.getText();
        return fullUserName;
    }

    public String getUrl() {
        return url;
    }

    //public boolean checkUrl(String url) {
    //    if (url.equals(this.url)) {
    //        return true;
    //    }
    //    else throw new RuntimeException();
    //}
}
