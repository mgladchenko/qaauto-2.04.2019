import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTest {

    @Test
    public void basicSearchTest() {
        String userEmail = "linkedin.tst.yanina@gmail.com";
        String userPassword = "Test123!";
        String searchTerm = "HR";

        Assert.assertTrue(loginPage.isPageLoaded(), "Login page is not loaded.");

        HomePage homePage = loginPage.login(userEmail, userPassword);
        Assert.assertTrue(homePage.isPageLoaded(), "Home page is not loaded.");

        SearchResultsPage searchResultsPage = homePage.search(searchTerm);
        Assert.assertTrue(searchResultsPage.isPageLoaded(), "SearchResults page is not loaded.");

        Assert.assertEquals(searchResultsPage.getSearchResultsCount(), 10,
                "Search results count is wrong.");

        List<String> searchResults = searchResultsPage.getSearchResultsText();

        for (String searchResult : searchResults) {
            Assert.assertTrue(searchResult.contains(searchTerm),
                    "Search term: " + searchTerm + " not found in: \n" + searchResult);
        }

    }


}
