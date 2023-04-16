package org.example.hillelautomation;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ButtonWrapper {    private final WebDriver driver;
    private final WebElement element;

    public ButtonWrapper(WebDriver driver, By by) {
        this.driver = driver;
        this.element = driver.findElement(by);
    }

    public void click() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    public boolean isClickable() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            wait.until(ExpectedConditions.elementToBeClickable(element));
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void clickAndVerifyTitle() {
        String originalTitle = driver.getTitle();
        click();
        WebDriverWait wait = new WebDriverWait(driver, 10);
        try {
            wait.until(ExpectedConditions.stalenessOf(driver.findElement(By.xpath("//h1[text()='QA Automation']"))));
        } catch (NoSuchElementException e) {
            System.out.println("Element 'QA Automation' not found on the page, test passed.");
            return;
        }
        String newTitle = driver.getTitle();
        if (originalTitle.equals(newTitle)) {
            throw new RuntimeException("Title did not change after clicking on the element.");
        }
    }
}