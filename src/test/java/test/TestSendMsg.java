package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.User;
import utils.pages.LoginPage;
import utils.pages.MainPage;
import utils.pages.MessagePage;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestSendMsg {

    @Test
    public void testSendMessage () {
        WebDriver driver = new ChromeDriver();
        User user = new User("89897133605", "cntgfytyrj4859", "Анастасия Степаненко");
        driver.get("https://ok.ru");
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(driver, user);
        MessagePage messagePage = mainPage.openMessagePanel(driver);
        messagePage.enterTheMessage(driver, "msg");
        assertEquals(messagePage.getMessage(driver),"msg");
    }
}
