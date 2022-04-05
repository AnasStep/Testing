package test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestGoogleDriver {

    @Test
    public void testGoogle() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ru.wikipedia.org");
    }
}
