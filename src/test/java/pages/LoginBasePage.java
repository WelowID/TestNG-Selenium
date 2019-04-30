package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginBasePage extends BasePage{

    //*********Constructor*********
    public LoginBasePage(WebDriver driver) { super(driver); }

    //*********WebElements*********
    private By logedAsLinkBy = By.xpath("//*[@id=\"loggedas\"]/a");
    private By myAccountButtonBy = By.className("my-account");
    private By logedoutButtonBy = By.className("logout");
    private By homeButtonBy = By.className("home");
    private By myPageButtonBy = By.className("my-page");
    private By projectsButtonBy = By.linkText("Projects");
    private By administrationButtonBy = By.className("administration");
    private By helpButton = By.className("help");

    //*********PageMethods*********
    public LoginBasePage verifyUserLogedAs(String username) {
        assertEquals(logedAsLinkBy, username);
        return new LoginBasePage(driver);
    }

    public ProjectsPage goToProjects(){
        click(projectsButtonBy);
        return new ProjectsPage(driver);
    }

}
