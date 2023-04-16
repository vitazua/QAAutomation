package org.example.hillelautomation;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class QAAutomationPage {
    private WebDriver driver;

    @FindBy(className = "course-descriptor_header-text")
    private WebElement courseDescriptorHeader;

    @FindBy(className = "site-logo-link")
    private WebElement siteLogo;

    @FindBy(tagName = "strong")
    private WebElement courseTitle;

    @FindBy(className = "course-rating")
    private WebElement courseRate;

    public QAAutomationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getCourseTitle() {
        return this.courseTitle.getText();
    }

    public String getCourseRate() {
        return this.courseRate.getText();
    }

}