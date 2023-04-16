package org.example.hillelautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class CheckPage {
    public static void main(String[] args) {

        for (BrowserType browserType : BrowserType.values()) {
            WebDriver driver = WebDriverFactory.getDriver(browserType);
            driver.get("https://ithillel.ua/");

            WebElement testingTab = driver.findElement(By.cssSelector(".course-cat-bar_icon[alt='Тестування']"));
            testingTab.click();

            WebElement pageTitle = driver.findElement(By.cssSelector(".hero-title"));
            Assert.assertEquals(pageTitle.getText(), "Курси тестування у Києві");
        }

    }
}
