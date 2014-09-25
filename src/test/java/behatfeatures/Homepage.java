package behatfeatures;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import static junit.framework.Assert.*;

/**
 * Created by SRI on 25-Sep-14.
 */
public class Homepage {

    public WebDriver driver;
    private String homepage_url = "http://www.sparwelt.de/";

    @Before
    public void startBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Utils.driver = driver;
    }

    @After
    public void stopBrowser() {
        driver.quit();
    }

    @Given("^consumer is in 'Home' page$")
    public void consumer_is_in_the_HomePage() throws Throwable {
        driver.get(homepage_url);
    }

}


