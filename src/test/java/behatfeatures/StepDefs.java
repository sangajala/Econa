package behatfeatures;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import utils.BrowserFactory;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by sriramangajala on 27/09/2014.
 */
public class StepDefs {

    public static WebDriver driver = BrowserFactory.getDriver();

    private String homepage_url = "http://www.sparwelt.de/";
    int min = 2, max = 4, randomNum = 2;
    List<WebElement> menulist;
    String menudesc = "" ;
    WebElement title = null;





    @Then("^\"(.*?)\" Navigation menus should be shown on the top of the screen$")
    public void navigation_menu_should_be_shown_in_the_top_of_the_screen(String arg1) throws Throwable {

        List<WebElement> mainmenu = driver.findElements(By.partialLinkText(arg1));
        Assert.assertTrue(mainmenu.size() > 0);
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
        Assert.assertTrue(submenu.contains(arg1));
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
        Assert.assertTrue(pagetitle.isDisplayed());

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
        Assert.assertTrue(result);
    }



    private WebElement searchbox ;
    private String searchpage = "HomePage";
    private String selectedoption = " ";
    private String searchstring = " ";
    private boolean partialstring = false;



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


    @Before
    public void startBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver = driver;
    }

    @org.junit.After
    public void stopBrowser() {
        driver.quit();
    }




    @Given("^consumer is in Home page$")
    public void consumer_is_in_the_HomePage() {
        driver.get(homepage_url);
    }

    @Then ("^the slider automatically switches every three seconds$")
    public void the_slider_automatically_switches_every_three_seconds() throws  Throwable{
        WebElement image=driver.findElement(By.xpath(".//*[@id='js-index-slider']/div/div[2]/a/img"));
        String text=image.getText();
        Thread.sleep(3000);
        String text1=image.getText();
        Thread.sleep(3000);
        String text2=image.getText();
        String img[]=new String[3];
        img[0]=text;
        img[1]=text1;
        img[2]=text2;

    }
    WebElement deal1 = driver.findElement(By.xpath(".//*[@id='home-slide-side-position-1']"));
    WebElement deal2 = driver.findElement(By.xpath(".//*[@id='home-slide-side-position-2']"));
    WebElement deal3 = driver.findElement(By.xpath(".//*[@id='home-slide-side-position-3']"));
    String dealText1 = deal1.getText();
    String dealText2 = deal2.getText();
    String dealText3 = deal3.getText();

    @When("^consumer selects deal1 in current deals highlights$")
    public void comsumer_selects_deal1_in_current_deals_highlights() {
        deal1.click();
        System.out.println(dealText1);
    }

    @Then("^page navigates to Schnäppchen page$")
    public void page_navigates_to_Schnäppchen_page() {
        String url=driver.getPageSource();
        Assert.assertTrue(url.contains("Schnäppchen"));

    }

    @And("^the corresponding deal1 page appears$")
    public void the_corresponding_deal1_page_appears() {
        Assert.assertTrue(driver.findElement(By.linkText(dealText1)).isDisplayed());

    }
    @When("^consumer selects Home page$")
    public void consumer_selects_Home_page(){

    }


    @And("^consumer selects deal2 in current deals highlights$")
    private void comsumer_selects_deal2_in_current_deals_highlights() {
        deal2.click();
        System.out.println(dealText2);
    }

    @And("^the corresponding deal2 page appears$")
    public void the_corresponding_deal2_page_appears() {
        Assert.assertTrue(driver.findElement(By.linkText(dealText2)).isDisplayed());

    }


    @And("^consumer selects deal3 in current deals highlights$")
    public void comsumer_selects_deal3_in_current_deals_highlights() {
        deal3.click();
        System.out.println(dealText3);
    }

    @And("^the corresponding deal3 page appears$")
    public void the_corresponding_deal3_page_appears() {
        Assert.assertTrue(driver.findElement(By.linkText(dealText3)).isDisplayed());

    }

    @Then("^listings must appear with headings \"(.*?)\"$")
    public void listings_must_appear_with_headings(String List) throws Throwable {
        Assert.assertTrue(driver.findElement(By.linkText(List)).isDisplayed());
    }

    @Then("^Beliebteste Schnäppchen listing should have elements$")
    public void Beliebteste_Schnäppchen_listing_should_have_elements() throws Throwable{
        if(driver.findElements(By.id("js-sorted-bargain")).size() != 0){
            System.out.println("Element is Present");
        }else{
            System.out.println("Element is Absent");
        }

    }
    @Then("^Beliebteste Gutscheine listing should have elements$")
    public void Beliebteste_Gutscheine_listing_should_have_elements() throws Throwable{
        if(driver.findElements(By.xpath("")).size() != 0){
            System.out.println("Element is Present");
        }else{
            System.out.println("Element is Absent");
        }

    }

    @Then("^Aktuelle Schnäppchen listing should have elements$")
    public void Aktuelle_Schnäppchen_listing_should_have_elements() throws Throwable{
        if(driver.findElements(By.xpath("")).size() != 0){
            System.out.println("Element is Present");
        }else{
            System.out.println("Element is Absent");
        }
    }

    @Then("^Top-Ten Gutscheine listing should have elements$")
    public void Top_Ten_Gutscheine_listing_should_have_elements() throws Throwable{
        if(driver.findElements(By.xpath("")).size() != 0){
            System.out.println("Element is Present");
        }else{
            System.out.println("Element is Absent");
        }
    }

    @When("^selects element form Beliebteste Schnäppchen listing$")
    public void selects_element_from_Beliebteste_Schnäppchen_listing(){
        List<WebElement> element = driver.findElements(By.xpath(".//*[@id='js-sorted-bargain']"));
        if(element.size()>0){
        }
    }
    @Then("^corresponding Beliebteste Schnäppchen page appears$")
    public void corresponding_Beliebteste_Schnäppchenpage_appears()throws Throwable{


    }
    @When("^selects element form Beliebteste Gutscheine listing$")
    public void selects_element_from_Beliebteste_Gutscheine_listing() {
    }
    @Then("^corresponding Beliebteste Gutscheine page appears$")
    public void corresponding_Beliebteste_Gutscheine_appears()throws Throwable{


    }


    @When("^selects element form Aktuelle Schnäppchen listing$")
    public void selects_element_from_Aktuelle_Schnäppchen_listing(){
    }
    @Then("^corresponding Aktuelle Schnäppchen page appears$")
    public void corresponding_Aktuelle_Schnäppchen_page_appears()throws Throwable{


    }
    @When("^select all elements one after one form Top-Ten Gutscheine listing$")
    public void select_all_elements_one_after_one_from_Top_Ten_Gutscheine_listing(){
    }
    @Then("^corresponding pages appear$")
    public void corresponding_pages_appear()throws Throwable{


    }
    @When ("^consumer selects the link \"(.*?)\"$")
    public void consumer_selects_the_link(String Link) throws Throwable{
        WebElement link=driver.findElement(By.linkText(Link));
        link.click();

    }
    @Then("corresponding \"(.*?)\" page appears")
    public void correspondin_page_appears(String Link) throws Throwable{
        String url=driver.getPageSource();
        Assert.assertTrue(url.contains(Link));
    }
}
