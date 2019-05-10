package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginSubmitPage extends BasePage{

    private WebElement userEmailValidationMessage;
    private WebElement userPasswordValidationMessage;

    public LoginSubmitPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        userEmailValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-username']"));
        userPasswordValidationMessage = driver.findElement(By.xpath("//div[@id='error-for-password']"));
    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("/uas/login-submit");
    }

    public String getUserEmailValidationMessage() {
        return userEmailValidationMessage.getText();
    }

    public String getUserPasswordValidationMessage() {
        return userPasswordValidationMessage.getText();
    }
}
