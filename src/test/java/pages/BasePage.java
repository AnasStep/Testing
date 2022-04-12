package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.LoadableComponent;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasePage extends LoadableComponent {
    private WebDriver webDriver;
    private final String basePageUrl = "https://ok.ru";

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public BasePage() {}

    @Override
    public void load() {
        this
                .webDriver
                .get(basePageUrl);
    }

    @Override //is it needed to add universal methods from loadable?
    public void isLoaded() throws Error {
        assertTrue(webDriver.getCurrentUrl().contains(basePageUrl), "Error of loading page!");
    }

    public void click (By elementXpath) {
        webDriver
                .findElement(elementXpath)
                .click();
    }

    public void writeTheText (By elementXpath, String string) {
        webDriver
                .findElement(elementXpath)
                .sendKeys(string);
    }

    public String getText (By elementXpath) {
        WebElement webElement;
        webElement = webDriver.findElement(elementXpath);
        return webElement.getText();
    }
}
