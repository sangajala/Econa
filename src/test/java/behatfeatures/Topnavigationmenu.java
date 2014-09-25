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
 * Created by Sasikala on 24/09/2014.
 */
public class Topnavigationmenu {
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

    @Given("^Consumer is in the HomePage$")
    public void consumer_is_in_the_HomePage() throws Throwable {
        System.out.println("inside get url ");
        driver.get(homepage_url);
    }

    @Then("^\"(.*?)\" Navigation menus should be shown on the top of the screen$")
    public void navigation_menu_should_be_shown_in_the_top_of_the_screen(String arg1) throws Throwable {

        List<WebElement> mainmenu = driver.findElements(By.partialLinkText(arg1));
        assertTrue(mainmenu.size()>0 );
        System.out.println(arg1);
        System.out.println("Menu found successfully");
    }

    @When("^Consumer clicks a Navigation  menu \"(.*?)\"$")
    public void Consumer_clicks_a_Navigation_menu(String arg1) throws Throwable {
        WebElement mainmenu = driver.findElement(By.partialLinkText(arg1));
        System.out.println(arg1);
        mainmenu.click();
        System.out.println("menu clicked successfully");

    }

    @Then("^The \"(.*?)\" corresponding menu screen should be shown$")
    public void the_corresponding_menu_screen_should_be_shown(String arg1) throws Throwable {
        String submenu = driver.getPageSource();
        assertTrue(submenu.contains(arg1));
        System.out.println("corresponding menu found ");
    }
    @When("^Consumer moves the mouse over a menu with flyout \"(.*?)\"$")
    public void Consumer_moves_the_mouse_over_a_menu_with_flyout(String arg1) throws Throwable {
        WebElement element = driver.findElement(By.linkText(arg1));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    @Then("^\"(.*?)\" Flyoutmenu should be shown on the screen$")
    public void flyoutmenu_should_be_shown_on_the_screen(String arg1) throws Throwable {
        String titlepage = driver.getPageSource();
        assertTrue(titlepage.contains(arg1));
    }
    @When("^Consumer moves the mouse over \"(.*?)\" menu$" )
    public void Consumer_moves_the_mouse_over_menu(String arg1) throws Throwable {
        int min = 1, max = 30;
        Random rand = new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

    }
    @When("^Selects a vendor \"(.*?)\" from Finanzen menu$")
    public void selects_a_vendor_from_Finanzen_menu(String arg1) throws Throwable {

    }

    @When("^Selects a vendor \"(.*?)\" from Gutscheine menu$")
    public void selects_a_vendor_from_Gutscheine_menu(String arg1) throws Throwable {

    }

    @Then("^Screen should show details of selected vendor in the screen$")
    public void Screen_should_show_details_of_selected_vendor_in_the_screen() throws Throwable {

    }

    @After
    public void close_Browser(){    driver.quit();
    }


}
