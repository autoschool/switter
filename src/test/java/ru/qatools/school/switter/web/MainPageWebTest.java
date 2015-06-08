package ru.qatools.school.switter.web;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import ru.qatools.school.switter.rules.WebDriverRule;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

/**
 * eroshenkoam
 * 25/11/14
 */
public class MainPageWebTest {

    public WebDriver driver = new PhantomJSDriver();

    @Rule
    public WebDriverRule driverRule = new WebDriverRule(driver);

    public String baseUrl = driverRule.getBaseUrl();

    @Test
    public void testMainPageTitle() {
        driver.get(baseUrl);
        String title = driver.getTitle();
        assertThat(title, equalTo("Switter"));
    }

}
