package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

/**
 * Created by SRI on 30-Sep-14.
 */
public class PopularDeals extends Homepage {

    public void verifyListingHasElements(String listing){
        if(driver.findElements(By.xpath(".//*[@id='js-sorted-bargain']")).size() != 0){
            System.out.println("Listing has elements");
        }else{
            System.out.println("Listing doesn't have elements");
        }

    }

    public void selectElement(){
        List<WebElement> element = driver.findElements(By.xpath(".//*[@id='js-sorted-bargain']"));
        if(element.size()>0){
        }

    }

}
