package pages;

import behatfeatures.Utils;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

import cucumber.api.java.en.When;
import org.junit.Assert;
import org.junit.After;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;



/**
 * Created by SRI on 25-Sep-14.
 */
public class Homepage {

    public WebDriver driver;
    private String homepage_url = "http://www.sparwelt.de/";

    @Before
    public void startBrowser() {
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        Utils.driver = driver;
    }

    @After
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

