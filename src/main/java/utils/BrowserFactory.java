package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

/**
 * Created by sriramangajala on 27/09/2014.
 */
public class BrowserFactory {

    public static WebDriver driver;

    public static WebDriver getDriver()
    {
        if(driver==null)
        {
            driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
            driver.manage().timeouts().pageLoadTimeout(10,TimeUnit.SECONDS);
            driver.manage().window().maximize();
            driver.get("http://www.sparwelt.de/");
            Utils.driver = driver;
            return driver;
        }
        else
            return driver;
    }
}
