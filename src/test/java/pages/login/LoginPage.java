package pages.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.BasePage;
import utils.User;

public class LoginPage extends BasePage {

    private static final By LOGIN_XPATH = By.xpath("//*[contains(@class, 'it h-mod') and contains(@name, 'st.email')]");
    private static final By PASSWORD_XPATH = By.xpath("//*[contains(@class, 'it') and contains(@name, 'st.password')]");
    private static final By BUTTON_XPATH = By.xpath("//*[contains(@class, 'button-pro __wide') and contains(@data-l, 't,sign_in')]");

    public LoginPage (WebDriver webDriver) {
        super(webDriver);
    }

    public MainPage login(WebDriver webDriver, User user) {
        WebElement element;
        element = webDriver.findElement(LOGIN_XPATH);
        element.sendKeys(user.getLogin());
        element = webDriver.findElement(PASSWORD_XPATH);
        element.sendKeys(user.getPassword());
        element = webDriver.findElement(BUTTON_XPATH);
        element.click();
        return (new MainPage(webDriver.getCurrentUrl()));
    }
}
