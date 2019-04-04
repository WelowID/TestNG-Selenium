package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginHomePage extends BasePage {
    //*********Constructor*********
    public LoginHomePage(WebDriver driver) {
        super(driver);
    }

    //*********WebElements*********
    private By logedAsLinkBy = By.xpath("//*[@id=\"loggedas\"]/a");
    private By myAccountLinkBy = By.className("my-account");
    private By logedoutLinkBy = By.className("logout");

    //*********PageMethods*********
    public LoginHomePage verifyUserLogedAs(String username) {
        assertEquals(logedAsLinkBy, username);
        return this;
    }
}
