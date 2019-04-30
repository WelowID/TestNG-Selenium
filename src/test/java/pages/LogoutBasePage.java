package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LogoutBasePage extends BasePage{

    //*********Constructor*********
    public LogoutBasePage(WebDriver driver) { super(driver); }

    //*********WebElements*********
    private By loginButtonBy = By.className("login");
    private By registerButtonBy = By.className("register");
    private By homeButtonBy = By.className("home");
    private By projectsButtonBy = By.className("projects");
    private By helpButtonBy = By.className("help");

    //*********PageMethods*********
    public LoginPage goToLoginPage() {
        click(loginButtonBy);
        return new LoginPage(driver);
    }

}
