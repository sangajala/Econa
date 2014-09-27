package pages;

import utils.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.concurrent.TimeUnit;
//import org.junit.Before;
//import org.junit.After;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Sasikala on 25/09/2014.
 */
public class Search extends basePage{

    private String homepage_url = "http://www.sparwelt.de/";


    @After
    public void close_Browser(){    driver.quit();
    }
}
