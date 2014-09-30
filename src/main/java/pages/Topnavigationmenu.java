package pages;

import org.junit.Assert;

import java.util.List;
import java.util.Random;
//import org.junit.Before;
//import org.junit.After;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sasikala on 24/09/2014.
 */
public class Topnavigationmenu extends basePage {
    private List<WebElement> menulist ;
    private int min = 2, max = 4, randomNum = 0 ;
    public String selectedflyoutmenu = " ";
    private String menudesc = " ";
    private String title = " ";
    private String selectedVendor = " ";

    public void checkNavigation_menu(String topmenu) {
        List<WebElement> mainmenu = driver.findElements(By.partialLinkText(topmenu));
        assertTrue(mainmenu.size() > 0);
    }

    public void selectmenu(String topmenu) {
        WebElement mainmenu = driver.findElement(By.partialLinkText(topmenu));
        mainmenu.click();
    }

    public void verifyresultpage(String title) {
        String submenu = driver.getPageSource();
        assertTrue(submenu.contains(title));
    }
    public void selectaflyoutmenu(String flyoutmenu) throws InterruptedException
    {
        WebElement element = driver.findElement(By.linkText(flyoutmenu));
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
        selectedflyoutmenu = flyoutmenu;
    }
    public void showflyoutmenu(String flyoutsubmenu)
    {
        WebElement pagetitle = driver.findElement(By.partialLinkText(flyoutsubmenu));
        assertTrue(pagetitle.isDisplayed());
    }

    public void selectasubmenu() {

        if (selectedflyoutmenu.equals("Gutscheine")) {
            /*
            This is when we click a vendor randomly for the second time from the below submenus
            (not the first time(from Homepage), first time randonnum would be = 0)

            10 == "GutscheineShops von A-Z , 21 == Alle neue Gutscheine , 32 == Die Besten Gutscheine

            The below check is when we are going to the "Gutshiene menu" from any of the above mentioned screen,
            Then the xpath for the dropdown menus differ along with the number of items in the list,compared to going from the HomePage

            */

            if ((randomNum == 10 | randomNum == 21 | randomNum == 32)) {
                menulist = driver.findElements
                        (By.xpath("//html/body/div[1]/div[2]/ul/li[3]/descendant::a"));
                System.out.println(menulist.size());
                List<WebElement> list1 = menulist.subList(1, menulist.size());
                menulist = list1;
            }
            else {
                 menulist = driver.findElements
                        (By.xpath("//div[@class='row sub-navigation voucher-sub-nav collapse']/descendant::a"));
            }
        }
        else {
             menulist = driver.findElements
                    (By.xpath("//div[@class='row sub-navigation finance-sub-nav collapse']/descendant::a"));
        }

        min = 0; max = menulist.size() - 2 ;
        Random rand = new Random(); randomNum = rand.nextInt((max - min) + 1) + min;
        menudesc = menulist.get(randomNum).getText();
        menulist.get(randomNum).click();
    }

    public void showsubmenu()
    {
        /*
         The result screen headers and also the page info like Spartwelt>Girokonto are not uniform for the submenus
         under "Finanzen" and "Gutscheine". Each one is having different xpaths
         So there are many checks to get the correct result.
        */

        String xPath = " ";
        if (selectedflyoutmenu.equals("Finanzen")) {
            // 3 - ratenjredit 1-tagesweld 2- kreditkarte 0 - girokonto
            if (randomNum == 0 | randomNum == 2 ) {
                xPath = "//html/body/div[2]/div[2]/div[1]/ul/li[3]";
            }
            else {
                xPath = "//html/body/div[1]/div[4]/ul/li[5]/span";
            }
        }
        else {
            if (randomNum == 10 | randomNum == 21 | randomNum == 32) {
                xPath = "//html/body/div[1]/div[5]/div[1]/h1";
            } else {
                xPath = "//*[@id='panels-econa']/div[1]/div[1]/div/div/h1";
            }

            /*Under "Gutscheine" the submenus 10, 21, 32 have different headers completely cannot be matched using the
            java.String contains functions, even after changing the strings to lowercases. So kind of hardcoded it
            */
            if (randomNum == 10) {
                menudesc = "Gutscheine für alle Anbieter & Shops von A-Z";
            } else {
                if (randomNum == 21) {
                    menudesc = "Neue Gutscheine";
                } else {
                    if (randomNum == 32) {
                        menudesc = "Beste Gutscheine";
                    }
                }
            }
        }
        System.out.println(selectedflyoutmenu);
        System.out.println(randomNum);
        System.out.println(menudesc);
        title = driver.findElement(By.xpath(xPath)).getText();
        System.out.println(title);
        boolean result = title.contains(menudesc);
        assertTrue(result);
        System.out.println("pass");
    }
}
