package utils;

import org.junit.AfterClass;
import org.junit.BeforeClass;

/**
 * Created by sriramangajala on 27/09/2014.
 */
public class Hooks {

    @BeforeClass
    public void openBrowser()
    {
        BrowserFactory.getDriver();
    }

    @AfterClass
    public void close()
    {
        BrowserFactory.getDriver().quit();

    }
}
