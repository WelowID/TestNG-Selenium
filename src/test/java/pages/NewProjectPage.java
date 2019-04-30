package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NewProjectPage extends LoginBasePage {

    //*********Constructor*********
    public NewProjectPage(WebDriver driver) { super(driver); }

    //*********WebElements*********
    private By projectNameTxtBy = By.id("project_name");
    private By projectDescriptionTxtBy = By.id("project_description");
    private By projectIdentifierTxtBy = By.id("project_identifier");
    private By projectHomePageTxtBy = By.id("project_homepage");
    private By projectIsPublicCBBy = By.id("project_is_public");
    private By projectInheritMembersCBBy = By.id("project_inherit_members");
    private By createButtonBy = By.name("commit");
    private By subprojectOfDropMenuBy = By.id("project_parent_id");
    private By createAndContinueButtonBy = By.name("continue");
    private String subprojectOfOptionMethod = "text()";

    public ProjectPage createProject(String name, String description, String identifier, String homepage, boolean isPublic, boolean inheritMembers, String parentProjectName) {
        writeText(projectNameTxtBy, name);
        writeText(projectDescriptionTxtBy, description);
        writeText(projectIdentifierTxtBy, identifier);
        writeText(projectHomePageTxtBy, homepage);
        if ((!isPublic && driver.findElement(projectIsPublicCBBy).isSelected()) || (isPublic && !driver.findElement(projectIsPublicCBBy).isSelected())) {
            click(projectIsPublicCBBy);
        }
        if ((!inheritMembers && driver.findElement(projectInheritMembersCBBy).isSelected()) || (inheritMembers && !driver.findElement(projectInheritMembersCBBy).isSelected())) {
            click(projectInheritMembersCBBy);
        }
        selectDropMenuOption(subprojectOfDropMenuBy, subprojectOfOptionBy(subprojectOfOptionMethod, parentProjectName));
        click(createButtonBy);
        return new ProjectPage(driver);
    }

    public ProjectPage createProject(String name, String description, String identifier, String homepage) {
        boolean isPublic = true;
        boolean inheritMembers = false;
        String parentProjectName = "";

        return createProject(name, description, identifier, homepage, isPublic, inheritMembers, parentProjectName);
    }

    private By subprojectOfOptionBy(String xpathMethod, String value) {
        return By.xpath("option[" + xpathMethod + "='" + value + "']");
    }

}
