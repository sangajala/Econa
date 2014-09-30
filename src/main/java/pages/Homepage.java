package pages;


import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import static junit.framework.Assert.*;

/**
 * Created by SRI on 25-Sep-14.
 *
 */

public class Homepage extends basePage {


    private String homepage_url = "http://www.sparwelt.de/";

    public void getHomePage() {

        driver.get(homepage_url);

    }

 public void verifyListingAvailable(String listing){
     Assert.assertTrue(driver.findElement(By.xpath("html/body/div[2]/div[2]")).getText().contains(listing));
 }

  public void selectStaticLinks(String link){
      WebElement staticLink=driver.findElement(By.linkText(link));
      staticLink.click();
  }
}

