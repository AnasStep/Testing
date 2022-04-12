package pages.message;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.Element;

public class MessagePage extends BasePage {
    private static final By MESSAGE_XPATH = By.xpath("(//*[contains(@class, 'content chat-messages')]/" +
            "msg-message-list/div)[last()]");
    private static final By WRITE_MESSAGE_XPATH = By.xpath("//*[contains(@data-tsid, 'write-msg_portlet')]");
    private static final By USER_TO_WRITE_XPATH = By.xpath("//*[contains(@class, 'content')]/" +
            "msg-chats-list/msg-chats-list-item");
    //TODO: find help for running test: can't find the item and click to

    private String message;
    private String url;

    public MessagePage(String url) {
        this.url = url;
    }

    public MessagePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void writeTheText (WebDriver webDriver, String msg) {
        Element element = new Element(USER_TO_WRITE_XPATH);
        element
                .getElementByPosition("1", webDriver)
                .click();
        //TODO: solve the ? (can't click and don't go to the next step)
        webDriver
                .findElement(WRITE_MESSAGE_XPATH)
                .sendKeys(msg);
    }

    public String getText (WebDriver webDriver) {
        WebElement webElement;
        webElement = webDriver.findElement(MESSAGE_XPATH);
        return (message = webElement.getText());
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
