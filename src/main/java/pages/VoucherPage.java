package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by Sasikala on 29/09/2014.
 */
public class VoucherPage extends Topnavigationmenu{

    private String selectedVendor = " ";
    private List<WebElement> vouchersList ;
    private WebElement firstVoucherCode;
    private WebElement firstVoucherOverlay;
    private WebElement textBoxText;
    private String voucherCode= " ";
    private String copy_messgage = "kopiert!";
    private String current_window = " ";
    private String current_url = "http://www.sparwelt.de";

    public void getVoucherPage() {

        WebElement voucherpage = driver.findElement(By.xpath("html/body/div[2]/header/div[2]/nav/ul/li[3]/div[1]/a"));
        voucherpage.click();
    }

    public void selectavendor(String vendor ) throws InterruptedException{

        WebElement vendor_select  = driver.findElement(By.partialLinkText(vendor));
        vendor_select.click();
        selectedVendor = vendor;
    }

    public void showVendorScreen( ){

        String vendorTitle = driver.findElement(By.xpath("//*[@id='panels-econa']/div[1]/div[1]/div/div/h1")).getText();
        assertTrue(vendorTitle.contains(selectedVendor));
    }

    public void check_Voucher_Displayed(){

        vouchersList = driver.findElements(By.xpath("//*[@id='panels-econa']/div[1]/div[3]/div/div[1]/div"));
        assertTrue(vouchersList.size()> 0);

        firstVoucherCode = driver.findElement(By.xpath("//*[@id='panels-econa']/div[1]/div[3]/div/div[1]/div/div[3]/div/div[1]/div[1]/a"));
        assertTrue(firstVoucherCode.isDisplayed());
    }

    public void check_Voucher_Overlay_displayed(){

        firstVoucherOverlay = driver.findElement(By.xpath("//*[@id='panels-econa']/div[1]/div[3]/div/div[1]/div/div[3]/div/div[1]/div[2]/div"));
        assertTrue(firstVoucherOverlay.isDisplayed());
    }

    public void select_Voucher(){

        firstVoucherCode.click();
    }

    public void vendor_shop_page(String vendorshopurl) throws InterruptedException{
        /*
        When the Voucher code is clicked, the vendor shop page is opened in a new window if done thru the script
        While doing the same manually, the vendor shop page is opened in a new tab
        The vendor shopper page is assigned the current windows handle and the sparwelt window is assigned a new windows handle,
        Also the windowshandle string is in the sorted order. So sometimes vendor shop page may be first in the Set<String> , sometime the sparwelt page would be the first.

        Since all of it looks very random, used the current url to handle the new window logic.

        Also, used the vendor page URL for asserting the new vendor page. The vendor page URL is not uniform at all.
        For example : if the vendor name is
        "Dress for less", the URL is "dress-for-less"
        "Frontline Shop", the URL is "frontlineshop"
        "C&A " , the URL is "c-and-a"
        So to avoid the above problem , I have made the part of URL to be sent as the input data
        */
        String vendorshopurl_lc = vendorshopurl.toLowerCase();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles.size());
        assertTrue(windowHandles.size() > 1);

        for ( String a : windowHandles) {
            driver.switchTo().window(a);
            String shopurl = driver.getCurrentUrl().toLowerCase();
            System.out.println(shopurl);
            if (!shopurl.startsWith(current_url)) {
                System.out.println("inside urlchecking");
                assertTrue(shopurl.contains(vendorshopurl_lc));
            }
            else{
                current_window = a;
            }
        }
        driver.switchTo().window(current_window);
        System.out.println("current url " +driver.getCurrentUrl()) ;
    }

    public void check_voucher_code_in_text_box() {

        textBoxText = driver.findElement(By.xpath("//*[@id='overlay']/div/div[1]/div[4]/div/div[2]/div[1]/span[1]"));
        voucherCode = textBoxText.getText();
        System.out.println(voucherCode);
        /* This set of code is required if there are no voucher required

        textBoxText = driver.findElement(By.xpath("//*[@id='overlay']/div/div[1]/div[4]/div/div/div/span"));
        voucherCode = textBoxText.getText();
        assertTrue((voucherCode.equals("kein Gutscheincode notwendig")));

         */
    }

    public void check_voucher_copy_icon(){
        WebElement copyIcon = driver.findElement(By.xpath("//*[@id='js-copy-code']"));
        copyIcon.click();
    }

    public void check_Voucher_Code_Copy_Message(){
        System.out.println(textBoxText.getText());
        assertTrue(!(textBoxText.getText().equals(copy_messgage)));
        System.out.println("copymessage verified");
    }

    public void check_Voucher_Code_In_ClipBoard() throws Exception{

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String clipboardData = (String) clipboard.getData(DataFlavor.stringFlavor);
        System.out.println(clipboardData);
        assertTrue(clipboardData.equals(voucherCode));
        System.out.println("clipboard verified");

    }
}
