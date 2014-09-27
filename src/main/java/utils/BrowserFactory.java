package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by sriramangajala on 27/09/2014.
 */
public class BrowserFactory {

    private static WebDriver driver;

    public static WebDriver getDriver()
    {
        if(driver==null)
        {
            return new FirefoxDriver();
        }
        else
            return driver;

    }
}
