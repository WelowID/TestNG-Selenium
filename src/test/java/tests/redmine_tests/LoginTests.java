package tests.redmine_tests;

import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;
import pages.HomePage;
import pages.LoginBasePage;

public class LoginTests extends BaseSeleniumTest {

    //*************DATA PROVIDERS*************

    @DataProvider(name = "valid-accounts")
    public Object[][] validAccountsProvider() {
        return new Object[][] {
                { "user", "bitnami1"}
        };
    }

    @DataProvider(name = "invalid-accounts")
    public Object[][] invalidAccountsProvider() {
        return new Object[][] {
                { "user", ""},
                {"", "asd"},
                {"hola", "chau"}
        };
    }

    //**************TESTS METHODS**************

    @Test(dataProvider = "valid-accounts", priority = 0)
    public void validLoginTest(String user, String password) {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);
        LoginBasePage loginHomePage = new LoginBasePage(driver);

        //*************PAGE METHODS********************
        homePage.goToRedmine()
                .goToLoginPage()
                .loginToRedmine(user, password);
        loginHomePage.verifyUserLogedAs(user);
    }

    @Test(dataProvider = "invalid-accounts", priority = 1)
    public void invalidLoginTest(String user, String password) {
        //*************PAGE INSTANTIATIONS*************
        HomePage homePage = new HomePage(driver);

        //*************PAGE METHODS********************
        homePage.goToRedmine()
                .goToLoginPage()
                .loginToRedmine(user, password)
                .verifyLoginError("Invalid user or password");
    }

}
