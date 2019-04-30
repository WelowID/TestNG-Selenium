package pages;

import org.openqa.selenium.WebDriver;

public class HomePage extends LogoutBasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    private String baseURL = "http://192.168.64.2/";

    //*********WebElements*********
    private LogoutBasePage topMenu = new LogoutBasePage(driver);

    //*********Page Methods*********
    public HomePage goToRedmine() {
        driver.get(baseURL);
        return this;
    }

}
