import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage {
    private WebDriver driver;

    private WebElement searchResultsContainer;
    private List<WebElement> searchResultElements;

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
        initElements();
    }

    private void initElements() {
        searchResultsContainer = driver.findElement(By.xpath("//div[@class='search-results-container']"));
        searchResultElements = driver.findElements(By.xpath("//li[contains(@class, 'search-result__occluded-item')]"));
    }

    public boolean isPageLoaded() {
        return searchResultsContainer.isDisplayed();
    }

    public int getSearchResultsCount() {
        return searchResultElements.size();
    }

    public List<String> getSearchResultsText() {
        List<String> searchResultsList = new ArrayList<String>();
        for (WebElement searchResultElement : searchResultElements) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResultElement);
            String searchResultText = searchResultElement.getText();
            searchResultsList.add(searchResultText);
        }
        return searchResultsList;
    }
}
