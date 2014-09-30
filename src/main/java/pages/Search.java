package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import org.junit.Before;
//import org.junit.After;
import java.util.List;
import java.util.concurrent.TimeoutException;

import static org.junit.Assert.*;

/**
 * Created by Sasikala on 25/09/2014.
 */
public class Search extends basePage {
    private WebElement searchBox;
    private WebElement dropdownBox;
    private WebElement firstDropdownElement ;
    private String searchString = " ";
    private String searchPg = "HomePage";
    private String homepage_url = "http://www.sparwelt.de/";
    private List<WebElement> result;
    private WebElement searchbutton;


    public void searchForKeyword(String searchKeyword) {
        if ( driver.getCurrentUrl().equals(homepage_url))       {
            searchBox = driver.findElement(By.id("searchform_search"));
            searchPg = "HomePage";
        }
        else  {
            searchBox = driver.findElement(By.id("voucher-search"));
            searchPg = "VoucherPage";
        }
        searchBox.sendKeys(searchKeyword);
        searchString = searchKeyword.toLowerCase();
    }

    public void matchSearchKeyword(){
        checkDropdownAppears();
        if ( searchPg.equals("HomePage")) {
            firstDropdownElement = driver.findElement(By.xpath("//*[@id='topsuggest']/ul/li[1]/a"));
        }
        else  {
            firstDropdownElement = driver.findElement(By.xpath("//*[@id='vouchersuggest']/ul/li[1]/a"));
        }
        String result = firstDropdownElement.getText().toLowerCase();
        assertTrue(result.contains(searchString));
    }
    public void checkDropdownAppears(){
        if (searchPg.equals("HomePage")) {
            dropdownBox = driver.findElement(By.xpath("//*[@id='topsuggest']/ul/li[1]/a"));
        }
        else {
            dropdownBox = driver.findElement(By.xpath("//*[@id='vouchersuggest']/ul/li[1]/a"));
        }
        System.out.println(dropdownBox.getText());
        assertTrue(dropdownBox.isDisplayed());
    }

    public void selectSearchOption() throws InterruptedException
    {

        if (searchPg.equals("HomePage")) {
            /*
             While doing a partial search  using the HomePage Search box, a extra click to the Search-text box or the Search-icon
             is required to perform the search action using the scripts. But while doing manually, it is not required.
             */
            searchBox.click();
            searchbutton = driver.findElement(
                    By.xpath("//html/body/div[2]/header/div[3]/div/div[1]/form/div[1]/span/button"));
        }
        else {
            searchbutton = driver.findElement((By.xpath("//*[@id='scont-1-1']/div/form/div[3]/span/button")));
        }
        searchbutton.click();
    }

    public void searchResultPage(){
        /* The landing result page header differs for the Homepage and Voucher page

        1) The header looks like Suche nach "searchkeyword" for below 3 searches, xpath=//*[@id='panels-econa']/div[1]/div[1]/h1
        HomePage Partial vendor name search -
        HomePage Full vendor name search
        Voucher Page Partial vendor name search
        2) The header looks like "Full vendor name" for below type of search, xpath=//*[@id='panels-econa']/div[1]/div[1]/div/div/h1
        Since we are not aware of what kind of search is performed, check for the presence of the elements using findElements
        */

        result =driver.findElements(By.xpath("//*[@id='panels-econa']/div[1]/div[1]/h1"));
        if ( result.size() <= 0 ) {
            result = driver.findElements(By.xpath("//*[@id='panels-econa']/div[1]/div[1]/div/div/h1"));
        }
        String resultignorecase = result.get(0).getText().toLowerCase();
        System.out.println(resultignorecase);
        assertTrue(resultignorecase.contains(searchString));
    }
}