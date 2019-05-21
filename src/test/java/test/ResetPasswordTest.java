package test;

import org.testng.Assert;
import org.testng.annotations.Test;
import page.ChooseNewPasswordPage;
import page.RequestPasswordResetPage;
import page.RequestPasswordResetSubmitPage;

public class ResetPasswordTest extends BaseTest {

    @Test
    public void successfulPasswordResetTest() {
        String userEmail = "linkedin.tst.yanina@gmail.com";

        RequestPasswordResetPage requestPasswordResetPage =
                loginPage.clickOnForgotPasswordLink();
        Assert.assertTrue(requestPasswordResetPage.isPageLoaded(),
                "RequestPasswordReset page is not loaded.");

        RequestPasswordResetSubmitPage requestPasswordResetSubmitPage =
                requestPasswordResetPage.findAccount(userEmail);
        Assert.assertTrue(requestPasswordResetSubmitPage.isPageLoaded(),
                "RequestPasswordResetSubmit page is not loaded.");

        ChooseNewPasswordPage chooseNewPasswordPage =
                requestPasswordResetSubmitPage.navigateToLinkFromEmail(userEmail);
        Assert.assertTrue(chooseNewPasswordPage.isPageLoaded(),
                "ChooseNewPassword page is not loaded.");
    }


}
