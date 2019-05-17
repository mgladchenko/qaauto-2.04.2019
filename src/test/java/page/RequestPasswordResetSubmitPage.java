package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RequestPasswordResetSubmitPage extends BasePage {

    @FindBy(xpath = "//button[@id='resend-url']")
    private WebElement resendLinkButton;

    public RequestPasswordResetSubmitPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean isPageLoaded() {
        return resendLinkButton.isDisplayed()
                && driver.getCurrentUrl().equals("checkpoint/rp/request-password-reset-submit")
                && driver.getTitle().equals("Please check your mail for reset password link.  | LinkedIn");
    }

    public ChooseNewPasswordPage navigateToLinkFromEmail() {
        //driver.get(resetPasswordUrl);
        return new ChooseNewPasswordPage(driver);
    }
}
