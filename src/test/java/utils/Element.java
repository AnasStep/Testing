package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Element {

    private static By xpathElement;

    public Element(By xpath) {
        xpathElement = xpath;
    }

    public String getElementXpathByPosition(String position) {
        String string = xpathElement.toString();
        String newPosition = "[" + position + "]";
        return (string + newPosition);
    }

    public WebElement getElementByPosition(String position, WebDriver webDriver) {
        String xpath = getElementXpathByPosition(position);
        return webDriver.findElement(By.xpath(xpath));
    }

    public void clickToTheElement(WebDriver webDriver) {
        webDriver
                .findElement(xpathElement)
                .click();
    }
}
