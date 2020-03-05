package internetFrame.pages;

import internetFrame.utility.Init;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import internetFrame.utility.ServicesMethods;
import org.apache.log4j.Logger;
import static org.apache.log4j.Logger.getLogger;
import static org.testng.Assert.assertEquals;

public class WelcomePG extends ServicesMethods {

    final static String TITLE = "The Internet";
    final static String HEADING = "Welcome to the-internet";
    String xpathHeading = "//h1";
    String xpathLink = "//ul/li/a[text()='**link**']";
    private static Logger logger = getLogger(Init.class.getName());

    public WelcomePG(WebDriver driver) {
        super(driver);
    }

    public void verifyWP() {
        String actualTitle = driver.getTitle();
        assertEquals(actualTitle, TITLE,
                "Actual title "+ actualTitle + "should be same as "+ TITLE);
        logger.info("# Title is: "+ actualTitle);
    }

    public void verifyWPHead() {
        String actualHead = getW(xpathHeading).getText();
        assertEquals(actualHead, HEADING,
                "Actual heading "+ actualHead + "Should be same as" + HEADING);
        logger.info("# Actual head: "+ actualHead);
    }

    public void clickOnLink(String link) {
        xpathLink = xpathLink.replace("**link**", link);
        click(By::xpath, xpathLink);
        logger.info("# Clic on element: "+ xpathLink);
    }

}
