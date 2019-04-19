import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.Thread.sleep;

public class LoginTest {

    @Test
    public void successfulLoginTest() {
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up ");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login("linkedin.tst.yanina@gmail.com", "Test123!");

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProfileMenuItemDisplayed(), "Home page is not loaded.");

        homePage.clickOnProfileMenuItem();

        Assert.assertEquals(homePage.getProfileUserNameText(), "Viktor Pavlik",
                "Wrong profile user name displayed.");
        driver.quit();
    }

    @Test
    public void negativeLoginTest() {

    }



}
