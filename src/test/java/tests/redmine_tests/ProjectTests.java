package tests.redmine_tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginBasePage;
import utilities.Util;

import java.util.Random;

public class ProjectTests extends BaseSeleniumTest {

    //*************DATA PROVIDERS*************

    @DataProvider(name = "project-data")
    public Object[][] invalidAccountsProvider() {
        String strIdentifier = Util.generateIdentifier(3);
        String intIdentifier = String.valueOf(new Random().nextInt(9999));
        String identifier = strIdentifier + "-" + intIdentifier;
        return new Object[][] {
                { "Test Project", "This is a test project.", identifier, "", false, true, "test project"}
        };
    }

    //**************TESTS METHODS**************

    @Test(dataProvider = "project-data")
    public void validLoginTest(String name, String description, String identifier, String homepage, boolean isPublic, boolean inheritMembers, String parentProjectName) {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginHomePage = new LoginBasePage(driver);

        //*************PAGE METHODS********************
        homePage.goToRedmine()
                .goToLoginPage()
                .loginToRedmine("user", "bitnami1");
        loginHomePage.goToProjects()
                .goToNewProject()
                .createProject(name, description, identifier, homepage, isPublic, inheritMembers, parentProjectName)
                .verifyCreatedProjectNotice("Successful creation.");

    }

}
