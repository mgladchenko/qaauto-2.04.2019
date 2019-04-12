import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

    @Test
    public void successfulLoginTest() {
        //System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.linkedin.com");
        Assert.assertEquals(driver.getTitle(), "LinkedIn: Log In or Sign Up ");
    }
}
