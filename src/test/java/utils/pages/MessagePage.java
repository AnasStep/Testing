package utils.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MessagePage {
    private static final By MESSAGE_XPATH = By.xpath("(//*[contains(@class, 'content chat-messages')]//" +
            "msg-message-list//div)[last()]");
    private static final By WRITE_MESSAGE_XPATH = By.xpath("//*[contains(@data-tsid, 'write-msg_portlet')]");
    private static final By FIRST_USER_TO_WRITE_XPATH = By.xpath("//*[contains(@data-tsid, 'write-msg_portlet')]");

    private String message;
    private String url;

    MessagePage (String url) {
        this.url = url;
    }

    public void enterTheMessage (WebDriver webDriver, String msg) {
        WebElement webElement;
        webElement = webDriver.findElement(WRITE_MESSAGE_XPATH);
        webElement.sendKeys(msg);
    }

    public String getMessage (WebDriver webDriver) {
        WebElement webElement;
        webElement = webDriver.findElement(MESSAGE_XPATH);
        return (message = webElement.getText());
    }
}
