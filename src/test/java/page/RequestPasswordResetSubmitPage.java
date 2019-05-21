package page;

import org.apache.commons.lang3.StringUtils;
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

    public ChooseNewPasswordPage navigateToLinkFromEmail(String userEmail) {
        String messageSubject = "here's the link to reset your password";
        String messageTo = userEmail;
        String messageFrom = "security-noreply@linkedin.com";

        String message = gMailService.waitMessage(messageSubject, messageTo, messageFrom, 180);
        System.out.println("Content: " + message);
        String resetPasswordLink = StringUtils.substringBetween(
                message,
                "<p style=\"margin:0;color:#4C4C4C;font-weight:400;font-size:16px;line-height:1.25;\"><a href=\"",
                "\" style=\"cursor:pointer;color:#008CC9;-webkit-text-size-adjust:100%;display:inline-block;text-decoration:none;-ms-text-size-adjust:100%;\">Reset my password")
                .replace("amp;", "");

        System.out.println(resetPasswordLink);
        driver.get(resetPasswordLink);
        return new ChooseNewPasswordPage(driver);
    }
}
