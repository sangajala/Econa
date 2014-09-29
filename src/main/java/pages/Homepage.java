package pages;


/**
 * Created by SRI on 25-Sep-14.
 */
public class Homepage extends basePage {

    private String homepage_url = "http://www.sparwelt.de/";

    public void getHomePage() {

        driver.get(homepage_url);

    }
}

