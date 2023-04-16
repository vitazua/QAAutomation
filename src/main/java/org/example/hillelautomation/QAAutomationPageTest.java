package org.example.hillelautomation;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class QAAutomationPageTest {

    private WebDriver driver;
    private QAAutomationPage qaAutomationPage;

    @BeforeTest
    public void setUp() {

        driver = WebDriverFactory.getDriver(BrowserType.CHROME);
        driver.manage().window().maximize();

        qaAutomationPage = new QAAutomationPage(driver);
        driver.get("https://ithillel.ua/courses/qa-automation");
    }

    @Test
    public void testGetCourseTitle() {

        String courseTitle = qaAutomationPage.getCourseTitle();
        Assert.assertEquals(courseTitle, "QA Automation");
    }

    @Test
    public void testGetCourseRate() {

        String courseRate = qaAutomationPage.getCourseRate();
        Assert.assertEquals(courseRate, "4.9");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
