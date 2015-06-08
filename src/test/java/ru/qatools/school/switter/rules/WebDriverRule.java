package ru.qatools.school.switter.rules;

import org.junit.rules.ExternalResource;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;

/**
 * eroshenkoam
 * 25/11/14
 */
public class WebDriverRule extends ExternalResource {

    public WebDriver driver;

    public WebDriverRule(WebDriver driver) {
        this.driver = driver;
    }

    public String getBaseUrl() {
        return "http://localhost:8080";
    }

    public void before() {

    }

    public void after() {
        driver.close();
        driver.quit();
    }

}
