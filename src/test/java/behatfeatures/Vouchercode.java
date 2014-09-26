package behatfeatures;

import static org.junit.Assert.*;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import java.util.List;
import java.util.concurrent.TimeUnit;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;



/**
 * Created by Sasikala on 25/09/2014.
 */
public class Vouchercode {
    private WebDriver driver;


    @When("^Consumer moves the mouse over \"(.*?)\" menu$")
    public void consumer_moves_the_mouse_over_menu(String arg1) throws Throwable {

    }

    @When("^Selects a vendor \"(.*?)\" from Gutscheine menu$")
    public void selects_a_vendor_from_Gutscheine_menu(String arg1) throws Throwable {

    }

    //@Then("^Screen should show details of selected vendor in the screen$")
   // public void screen_should_show_details_of_selected_vendor_in_the_screen() throws Throwable {

    //}

    @Then("^Vouchers from the selected vendor should be displayed$")
    public void vouchers_from_the_selected_vendor_should_be_displayed() throws Throwable {

    }

    @Then("^Voucher overlay should be shown$")
    public void voucher_overlay_should_be_shown() throws Throwable {

    }

    @When("^Consumer clicks a voucher$")
    public void consumer_clicks_a_voucher() throws Throwable {
   }

    @Then("^Vendors shop should be shown in a new window$")
    public void vendors_shop_should_be_shown_in_a_new_window() throws Throwable {
   }

    @Then("^Voucher code should be shown inside a text box in a new window$")
    public void voucher_code_should_be_shown_inside_a_text_box_in_a_new_window() throws Throwable {
   }

    @When("^Consumer clicks the copy icon in the screen$")
    public void consumer_clicks_the_copy_icon_in_the_screen() throws Throwable {
   }

    @Then("^A message saying \"(.*?)\" should be shown inside the text box$")
    public void a_message_saying_should_be_shown_inside_the_text_box(String arg1) throws Throwable {
   }

}
