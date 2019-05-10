package page;

import org.openqa.selenium.WebDriver;

public abstract class BasePage {
    protected WebDriver driver;

    public abstract boolean isPageLoaded();
}
