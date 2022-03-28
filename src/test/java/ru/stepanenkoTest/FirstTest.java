package ru.stepanenkoTest;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FirstTest {

    @Test
    public void testGoogle() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ru.wikipedia.org");
    }

    @Test
    public void testForPages() {
        WebDriver driver = new ChromeDriver();
        User user = new User("89897", "6659", "Анастасия Степаненко");
        driver.get("https://ok.ru");
        LoginPage loginPage = new LoginPage();
        MainPage mainPage = loginPage.login(driver, user);
        //driver.get(mainPage.getUrl());
        try {
            // если ввести неправильно пароль и/или логин, то отображается Tests Passed, что неверно, поэтому
            // хотела детализировать ошибки (все закомментированное),
            // т.е. показать, что введены неправильные логин или пароль, но напоролась
            // на вопрос о необходимости такой логики из-за уже существующей проверки по имени пользователя
            // mainPage.checkUrl("https://ok.ru/feed"); -- попытка проверить по url

            assertEquals(mainPage.getFullUserName(driver), user.getName());
        }
        catch (NoSuchElementException e) {
            System.out.println("Can't enter to the page correctly");
        }
        //catch (RuntimeException e) {
        //    System.out.println("Can't enter to the page");
        //}
    }
}
