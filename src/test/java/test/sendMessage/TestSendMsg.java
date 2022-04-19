package test.sendMessage;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import test.BaseTest;
import utils.User;
import pages.login.LoginPage;
import pages.login.MainPage;
import pages.message.MessagePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSendMsg extends BaseTest {

    @Test
    @Tag("message")
    public void testSendMessage () {
        WebDriver driver = new ChromeDriver();
        User user = new User.Builder()
                .login("898")
                .password("cn59")
                .name("А")
                .build();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        MainPage mainPage = loginPage.login(driver, user);
        MessagePage messagePage = mainPage.openMessagePanel(driver);
        messagePage.writeTheText(driver, "msg");
        assertEquals(messagePage.getText(driver),"msg", "Send message test was failed");
    }
}
