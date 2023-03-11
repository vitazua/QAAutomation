package org.example.hillelautomation;


import org.openqa.selenium.WebDriver;

public class Main {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver(ConfigProvider.BROWSER_TYPE);
        driver.get(ConfigProvider.BASE_URL);
        driver.quit();
    }
}