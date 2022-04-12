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
        //driver.get(mainPage.getUrl());
        //try {
            // если ввести неправильно пароль и/или логин, то отображается Tests Passed, что неверно, поэтому
            // хотела детализировать ошибки (все закомментированное),
            // т.е. показать, что введены неправильные логин или пароль, но напоролась
            // на вопрос о необходимости такой логики из-за уже существующей проверки по имени пользователя
            // mainPage.checkUrl("https://ok.ru/feed"); -- попытка проверить по url

            assertEquals(mainPage.getFullUserName(driver), user.getName());
        //}
        //catch (NoSuchElementException e) {
        //    System.out.println("Can't enter to the page correctly");
        //}
        //catch (RuntimeException e) {
        //    System.out.println("Can't enter to the page");
        //}
    }
}
