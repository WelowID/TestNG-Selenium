package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProjectsPage extends LoginBasePage{

    //*********Constructor*********
    public ProjectsPage(WebDriver driver) { super(driver); }

    //*********WebElements*********
    private By addProjectButtonBy = By.className("icon-add");

    //*********PageMethods*********
    public NewProjectPage goToNewProject() {
        click(addProjectButtonBy);
        return new NewProjectPage(driver);
    }

}
