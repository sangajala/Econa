package behatfeatures;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.*;
import utils.BrowserFactory;

/**
 * Created by sriramangajala on 27/09/2014.
 */
public class StepDefs {

    public static WebDriver driver = BrowserFactory.getDriver();

    Homepage homePage = new Homepage();
    Search searchPage = new Search();
    Topnavigationmenu topNavigationMenuPage = new Topnavigationmenu();
    Vouchercode voucherCode = new Vouchercode();
    VoucherPage voucherPage = new VoucherPage();


    @Given("^Consumer is in the HomePage$")
    public void Consumer_is_in_the_HomePage() {
        homePage.getHomePage();
    }

    @Then("^\"(.*?)\" Navigation menus should be shown on the top of the screen$")
    public void navigation_menu_should_be_shown_in_the_top_of_the_screen(String topmenu) throws Throwable {
        topNavigationMenuPage.checkNavigation_menu(topmenu);
    }

    @When("^Consumer clicks a Navigation  menu \"(.*?)\"$")
    public void Consumer_clicks_a_Navigation_menu(String topmenu) throws Throwable {
        topNavigationMenuPage.selectmenu(topmenu);
    }

    @Then("^The \"(.*?)\" corresponding menu screen should be shown$")
    public void the_corresponding_menu_screen_should_be_shown(String resultpagetitle) throws Throwable {
        topNavigationMenuPage.verifyresultpage(resultpagetitle);
    }

    @When("^Consumer moves the mouse over a menu with flyout \"(.*?)\"$")
    public void Consumer_moves_the_mouse_over_a_menu_with_flyout(String flyoutmenu) throws Throwable {

        topNavigationMenuPage.selectaflyoutmenu(flyoutmenu);
    }

    @Then("^\"(.*?)\" Flyoutmenu should be shown on the screen$")
    public void flyoutmenu_should_be_shown_on_the_screen(String flyoutmenu) throws Throwable {
        topNavigationMenuPage.showflyoutmenu(flyoutmenu);
    }

    @When("^randomly selects a menu$")
    public void randomly_selects_a_menu() throws Throwable
    {
        topNavigationMenuPage.selectasubmenu();
    }
    @When("^randomly selects a different menu$")
    public void randomly_selects_a_different_menu() throws Throwable {
        topNavigationMenuPage.selectasubmenu();
    }

    @Then("^Screen should show details of selected submenu$")
    public void Screen_should_show_details_of_selected_submenu() throws Throwable
    {
        topNavigationMenuPage.showsubmenu();
    }

    @Given("^Consumer is in the Vouchers Page$")
    public void consumer_is_in_the_Vouchers_Page() throws Throwable {
        voucherPage.getVoucherPage();
    }

    @When("^Consumer enters \"(.*?)\" as keyword$")
    public void consumer_enters_as_keyword(String searchKeyword) throws Throwable {
        searchPage.searchForKeyword(searchKeyword);
    }

    @Then("^autocomplete should match with search criteria$")
    public void autocomplete_should_match_with_search_criteria() throws Throwable {
        searchPage.matchSearchKeyword();
    }

    @When("^select the search option$")
    public void select_the_search_option() throws Throwable {
        searchPage.selectSearchOption();
    }

    @Then("^the result page matching the search criteria should be shown$")
    public void the_result_page_matching_the_search_criteria_should_be_shown() throws Throwable {
        searchPage.searchResultPage();

    }
}
