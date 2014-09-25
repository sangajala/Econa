package behatfeatures;

import static org.junit.Assert.*;
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

/**
 * Created by Sasikala on 25/09/2014.
 */
public class Search {
    private WebDriver driver;
    private String homepage_url = "http://www.sparwelt.de/";

    @Before
    public void startBrowser()
    {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Utils.driver = driver;
    }
    @When("^Consumer enters a complete vendor name \"(.*?)\" in the search box$")
    public void consumer_enters_a_complete_vendor_name_in_the_search_box(String arg1) throws Throwable {

    }
    @When("^Consumer selects a vendor from the drop-down suggestion$")
    public void consumer_selects_a_vendor_from_the_drop_down_suggestion() throws Throwable {

    }

    @Then("^A drop-down menu with suggestions should be shown$")
    public void a_drop_down_menu_with_suggestions_should_be_shown() throws Throwable {



    }

    @Then("^Drop-down suggestions should match the searched vendor$")
    public void drop_down_suggestions_should_match_the_searched_vendor() throws Throwable {

    }

    @When("^Consumer clicks the search button$")
    public void consumer_clicks_the_search_button() throws Throwable {
  }

    @Then("^New screen with search results for the vendor should be shown$")
    public void new_screen_with_search_results_for_the_vendor_should_be_shown() throws Throwable {

    }

    @When("^Consumer enters a part of vendor name \"(.*?)\" in the search box$")
    public void consumer_enters_a_part_of_vendor_name_in_the_search_box(String arg1) throws Throwable {

    }


    @Given("^Consumer is in the Vouchers Page$")
    public void consumer_is_in_the_Vouchers_Page() throws Throwable {
   }



    @After
    public void close_Browser()
    {
        driver.quit();
    }


}
