package internetFrame.testcases;

import internetFrame.pages.LoginPage;
import internetFrame.utility.Init;
import internetFrame.pages.WelcomePG;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestLogin extends Init {


    @DataProvider
    public static Object[][] validCrend() {
        return new Object[][]{{"tomsmith", "SuperSecretPassword!"}};
    }

    @DataProvider
    public static Object[][] invalidCrend() {
        return new Object[][]{{"abc", "abc123"}};
    }

    @Test(dataProvider = "validCrend")
    public void testLogin(String username, String password) {
        WelcomePG  welcomePG = new WelcomePG(driver);
        welcomePG.verifyWPHead();
        welcomePG.clickOnLink("Form Authentication");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.verifyLoginCorrect(username, password);
    }

}
