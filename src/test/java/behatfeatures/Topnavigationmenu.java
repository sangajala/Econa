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

import javax.xml.bind.SchemaOutputResolver;

/**
 * Created by Sasikala on 24/09/2014.
 */
public class Topnavigationmenu {
    private WebDriver driver;
    private String homepage_url = "http://www.sparwelt.de/";
    int min = 2, max = 4, randomNum = 2;
    List<WebElement> menulist;
    String menudesc = "" ;
    WebElement title = null;

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

        WebElement pagetitle = driver.findElement(By.partialLinkText(arg1));
        System.out.println(pagetitle.getText());
        System.out.println(pagetitle.isDisplayed());
        assertTrue(pagetitle.isDisplayed());

    }
    @When("^Consumer moves the mouse over \"(.*?)\" menu$" )
    public void Consumer_moves_the_mouse_over_menu(String arg1) throws Throwable {

        WebElement element = driver.findElement(By.linkText(arg1));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();

        if ( arg1.equals("Gutscheine")) {
            menulist = driver.findElements(By.xpath("//div[@class='row sub-navigation voucher-sub-nav collapse']/descendant::a"));
            System.out.println(menulist.size());
            min = 1 ; max = menulist.size() - 4;
            System.out.println(max +" " +min);
        }
        else {
            menulist = driver.findElements(By.xpath("//div[@class='row sub-navigation finance-sub-nav collapse']/descendant::a"));
            min = 0 ; max = 3;
        }

        Random rand = new Random();
        randomNum = rand.nextInt((max - min) + 1) + min;
        System.out.println(randomNum);
    }

    @When("^Selects a menu \"(.*?)\" from \"(.*?)\" menu$")
    public void selects_a_menu_from_menu(String arg1, String arg2) throws Throwable {
        String xPath = " ";

        if (menulist.size() <= 0 ) {
            System.out.println(" No menulist to click");
        }

        if (arg2.equals("Finanzen")) {
            if (arg1.contains("1")) {
                randomNum = 2;// 3 - ratenjredit 1-tagesweld 2- kreditkarte 0 - girokonto
                xPath = "html/body/div[2]/div[2]/div[1]/ul/li[3]";
            }
            else {
               randomNum = 3;
               xPath = "html/body/div[1]/div[4]/ul/li[5]/span";
           }
        }

        else {
           xPath = "//*[@id='panels-econa']/div[1]/div[1]/div/div/h1";
        }

        menudesc = menulist.get(randomNum).getText();
        menulist.get(randomNum).click();
        title = driver.findElement(By.xpath(xPath));
    }

    @Then("^Screen should show details of selected menu in the screen$")
    public void screen_should_show_details_of_selected_menu_in_the_screen() throws Throwable {
        System.out.println("vendor screen");
        String actual = title.getText();
        System.out.println(actual);
        boolean result = actual.contains(menudesc);
        assertTrue(result);
    }

    @After
    public void close_Browser(){    driver.quit();
    }


}
