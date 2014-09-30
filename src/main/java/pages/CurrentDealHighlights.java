package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebElement;

import javax.lang.model.element.Element;
import java.util.List;
import java.util.List.*;
import java.util.Random;

/**
 * Created by SRI on 30-Sep-14.
 */
public class CurrentDealHighlights extends Homepage {
    WebElement sliderImage = driver.findElement(By.xpath(".//*[@id='js-index-slider']/div/div[2]/a/img"));
    Actions action = new Actions(driver);


    public void  imagePresent(){
        if(driver.findElements(By.xpath(".//*[@id='js-index-slider']/div/div[2]/a/img")).size() != 0){
            System.out.println("Image is Present");
        }else{
            System.out.println("Image is Absent");
        }
    }
    public void sliderMoves(){

        for(int i=0; i<=3;i++){
            String Image=sliderImage.getAttribute("src");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            String changeImage=sliderImage.getAttribute("src");
            Assert.assertNotEquals(Image,changeImage);
        }

    }
    public WebElement RandomDeal(){
        int min = 1, max = 3;
        Random r = new Random();
        int num = r.nextInt((max - min) + 1) + min;
        String xpathstart=".//*[@id='home-slide-side-position-";
        String xpathend="']";
        WebElement deal=driver.findElement(By.xpath(xpathstart+num+xpathend));
        return deal;

    }
    public void selectRandomDeal(){
        RandomDeal().click();
    }
    public String getDealName(){
       String dealName=RandomDeal().getText();
        return dealName;

    }


}
