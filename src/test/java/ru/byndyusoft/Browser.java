package ru.byndyusoft;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {
    public static WebDriver getDriver(BrowserName browserName) {
        switch (browserName) {
            case Chrome:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver();
            default:
                return null;
        }
    }
}
