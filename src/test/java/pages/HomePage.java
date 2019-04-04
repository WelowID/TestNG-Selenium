package pages;

import com.sun.xml.internal.rngom.parse.host.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class HomePage extends BasePage {

    //*********Constructor*********
    public HomePage (WebDriver driver) {
        super(driver);
    }

    //*********Page Variables*********
    private String baseURL = "http://192.168.64.2/";

    //*********WebElements*********
    private By loginButtonBy = By.className("login");
    private By registerButtonBy = By.className("register");

    //*********Page Methods*********
    public HomePage goToRedmine() {
        driver.get(baseURL);
        return this;
    }

    public LoginPage goToLoginPage() {
        click(loginButtonBy);
        return new LoginPage(driver);
    }

}
