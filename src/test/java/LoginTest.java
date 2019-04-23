import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest {

    @DataProvider
    public Object[][] validDataProvider() {
        return new Object[][]{
                { "linkedin.tst.yanina@gmail.com", "Test123!" },
                { "linkedin.TST.yanina@gmail.com", "Test123!" }
        };
    }

    @Test(dataProvider = "validDataProvider")
    public void successfulLoginTest(String userEmail, String userPassword) {
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up ");

        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(userEmail, userPassword);

        HomePage homePage = new HomePage(driver);
        Assert.assertTrue(homePage.isProfileMenuItemDisplayed(), "Home page is not loaded.");

        homePage.clickOnProfileMenuItem();

        Assert.assertEquals(homePage.getProfileUserNameText(), "Viktor Pavlik",
                "Wrong profile user name displayed.");
        driver.quit();
    }

    @Test
    public void negativeLoginWithEmptyFields() {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        LoginPage loginPage = new LoginPage(driver);
        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded.");

        loginPage.login("", "");

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded.");
    }



}
















