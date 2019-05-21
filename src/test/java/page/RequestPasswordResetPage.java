package page;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import util.GMailService;

public class RequestPasswordResetPage extends BasePage {

    @FindBy(xpath = "//input[@id='username']")
    private WebElement userEmailField;

    @FindBy(xpath = "//*[@id='reset-password-submit-button']")
    private WebElement findAccountButton;

    public RequestPasswordResetPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RequestPasswordResetSubmitPage findAccount(String userEmail) {
        userEmailField.sendKeys(userEmail);
        gMailService.connect();
        findAccountButton.click();
        return new RequestPasswordResetSubmitPage(driver);
    }

    @Override
    public boolean isPageLoaded() {
        return findAccountButton.isDisplayed()
                && driver.getCurrentUrl().contains("uas/request-password-reset")
                && driver.getTitle().equals("Reset Password | LinkedIn");
    }
}
