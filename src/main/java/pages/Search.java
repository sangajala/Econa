package pages;

import static org.junit.Assert.*;

import behatfeatures.Utils;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
//import org.junit.Before;
//import org.junit.After;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by Sasikala on 25/09/2014.
 */
public class Search {
    private WebDriver driver;
    private String homepage_url = "http://www.sparwelt.de/";
    private WebElement searchbox ;
    private String searchpage = "HomePage";
    private String selectedoption = " ";
    private String searchstring = " ";
    private boolean partialstring = false;
    @Before
    public void startBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Utils.driver = driver;
    }

    @Given("^Consumer is in the HomePage$")
    public void consumer_is_in_the_HomePage() throws Throwable {
        System.out.println("inside get url ");
        driver.get(homepage_url);
    }

    @When("^Consumer enters a complete vendor name \"(.*?)\" in the \"(.*?)\" search box$")
    public void consumer_enters_a_complete_vendor_name_in_the_search_box(String arg1, String arg2) throws Throwable {
       searchpage = arg2;
       if ( arg2.equals("HomePage"))       {
           searchbox = driver.findElement(By.id("searchform_search"));
           System.out.println("enter vendor name in homepage");
       }
       else  {
           searchbox = driver.findElement(By.id("voucher-search"));
           System.out.println("enter vendor name in voucherpage");
       }
       searchbox.sendKeys(arg1);
       searchstring = arg1.toLowerCase();
       System.out.println(searchstring);
    }

    @Then("^A drop-down menu with suggestions should be shown$")
    public void a_drop_down_menu_with_suggestions_should_be_shown() throws Throwable {

        if (searchpage.equals("HomePage")) {
            WebElement topsuggest = driver.findElement(By.xpath("//*[@id='topsuggest']/ul/li[1]/a"));
            System.out.println(topsuggest.getText());
            Assert.assertTrue(topsuggest.isDisplayed());
        }
        else {
            WebElement vouchersuggest = driver.findElement(By.xpath("//*[@id='vouchersuggest']/ul/li[1]/a"));
            Assert.assertTrue(vouchersuggest.isDisplayed());
            System.out.println("drop-down-menu is shown");
        }
        System.out.println("drop-down-menu is shown");
    }

    @Then("^Drop-down suggestions should match the searched vendor$")
    public void drop_down_suggestions_should_match_the_searched_vendor() throws Throwable {
        WebElement firstelement ;

        if ( searchpage.equals("HomePage")) {
             firstelement = driver.findElement(By.xpath("//*[@id='topsuggest']/ul/li[1]/a"));
        }
        else  {
            firstelement = driver.findElement(By.xpath("//*[@id='vouchersuggest']/ul/li[1]/a"));
        }
        String result = firstelement.getText().toLowerCase();
        Assert.assertTrue(result.contains(searchstring));
        System.out.println("drop-down suggestion match");
    }

    @When("^Consumer selects a vendor from the drop-down suggestion$")
    public void consumer_selects_a_vendor_from_the_drop_down_suggestion() throws Throwable {
        WebElement searchoption ;

        if (searchpage.equals("HomePage")) {
            searchoption = driver.findElement(By.xpath("//*[@id='topsuggest']/ul/li[1]/a"));
        }
        else   {
            searchoption = driver.findElement(By.xpath("//*[@id='vouchersuggest']/ul/li[1]/a"));
        }
        searchoption.click();
        System.out.println("consumer select a vendor ");
    }

    @When("^Consumer clicks the search button$")
    public void consumer_clicks_the_search_button() throws Throwable {
        WebElement searchbutton;

        if (searchpage.equals("HomePage")) {
            searchbutton = driver.findElement(By.xpath("//html/body/div[2]/header/div[3]/div/div[1]/form/div[1]/span/button"));
            searchbutton.click();
        }
        else {
            searchbutton = driver.findElement((By.xpath("//*[@id='scont-1-1']/div/form/div[3]/span/button")));
        }
        searchbutton.click();
        System.out.println("consumer selects a search button ");
    }

    @Then("^New screen with search results for the vendor should be shown$")
    public void new_screen_with_search_results_for_the_vendor_should_be_shown() throws Throwable {

        WebElement result;
        if ((searchpage.equals("HomePage)") | ( partialstring ) )) {
            result = driver.findElement(By.xpath("//*[@id='panels-econa']/div[1]/div[1]/h1"));
        }
        else
        {
            result = driver.findElement((By.xpath("//*[@id='panels-econa']/div[1]/div[1]/div/div/h1")));
        }

        String resultignorecase = result.getText().toLowerCase();
        System.out.println(resultignorecase);
        Assert.assertTrue(resultignorecase.contains(searchstring));
    }

    @When("^Consumer enters a part of vendor name \"(.*?)\" in the \"(.*?)\" search box$")
    public void consumer_enters_a_part_of_vendor_name_in_the_search_box(String arg1, String arg2) throws Throwable
    {
        consumer_enters_a_complete_vendor_name_in_the_search_box(arg1, arg2);
        partialstring = true;
    }

    @Given("^Consumer is in the Vouchers Page$")
    public void consumer_is_in_the_Vouchers_Page() throws Throwable {
        consumer_is_in_the_HomePage();

        WebElement voucherpage = driver.findElement(By.xpath("html/body/div[2]/header/div[2]/nav/ul/li[3]/div[1]/a"));
        voucherpage.click();
    }

    @After
    public void close_Browser(){    driver.quit();
    }
}
