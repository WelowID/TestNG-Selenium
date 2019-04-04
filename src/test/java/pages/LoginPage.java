package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    //*********Constructor*********
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //*********WebElements*********
    private By usernameTxtBy = By.id("username");
    private By passwordTxtBy = By.id("password");
    private By submitButtonBy = By.id("login-submit");
    private By flashErrorBy = By.id("flash_error");

    //*********PageMethods*********
    public LoginPage loginToRedmine(String username, String password) {
        writeText(usernameTxtBy, username);
        writeText(passwordTxtBy, password);
        click(submitButtonBy);
        return this;
    }

    public LoginPage verifyLoginError(String expectedErrorText) {
        assertEquals(flashErrorBy,  expectedErrorText);
        return this;
    }

}
