package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.login.LoginPage;
import pages.login.MainPage;
import utils.User;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestEnter {

    @Test
    public void testLogin() {
        WebDriver driver = new ChromeDriver();
        User user = new User.Builder()
                .login("111")
                .password("3434")
                .name("АнастасСтеп")
                .build();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.load();
        MainPage mainPage = new MainPage(driver);
        loginPage.login(driver, user);
        mainPage.load();
        assertEquals(mainPage.getFullUserName(driver), user.getName());
    }
}
