package utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage {
    private static final By FULL_USER_NAME_XPATH = By.xpath("//*[contains(@class, 'tico ellip')]");
    private static final By MSG_PANEL_XPATH = By.xpath("//*[contains(@class, 'toolbar_nav_i') and" +
            "contains(@data-l, 't,messages')]");

    private String fullUserName;
    private String url;

    MainPage(String url) {
        this.url = url;
    }

    public String getFullUserName (WebDriver webDriver) {
        WebElement userName = webDriver.findElement(FULL_USER_NAME_XPATH);
        fullUserName = userName.getText();
        return fullUserName;
    }

    public MessagePage openMessagePanel (WebDriver webDriver) {
        WebElement element;
        element = webDriver.findElement(MSG_PANEL_XPATH);
        element.click();
        return (new MessagePage(webDriver.getCurrentUrl()));
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
