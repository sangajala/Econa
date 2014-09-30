package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

/**
 * Created by Sasikala on 29/09/2014.
 */
public class VoucherPage extends basePage{



    private String voucher_page;

    public void getVoucherPage() {

        WebElement voucherpage = driver.findElement(By.xpath("html/body/div[2]/header/div[2]/nav/ul/li[3]/div[1]/a"));
        voucherpage.click();
    }
    public String getDealPresent(){
        WebElement content=driver.findElement(By.xpath(".//*[@id='panels-econa']/div[1]/div[1]/h1"));
        String dealName=content.getText();
        return dealName;
    }
}
