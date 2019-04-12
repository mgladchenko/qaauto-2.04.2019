import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BadCodeExample {
    public static void main(String[] args) {
        System.out.println("Hello world!!!");
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");

        String searchTerm = "Selenium";
        WebElement searchField = driver.findElement(By.xpath("//*[@name='q']"));
        searchField.sendKeys(searchTerm);
        searchField.sendKeys(Keys.ENTER);

        List<WebElement> searchResults = driver.findElements(By.xpath("//div[@class='srg']/div[@class='g']"));

        System.out.println("Search results count: " + searchResults.size());

        //for each WebElement searchResult in searchResults print text block
        for (WebElement searchResult : searchResults) {
            String searchResultText = searchResult.getText();
            if (searchResultText.toLowerCase().contains(searchTerm.toLowerCase())) {
                System.out.println("Search term " + searchTerm + " found in: \n" + searchResultText);
            } else {
                System.out.println("Search term " + searchTerm + " NOT found in: \n" + searchResultText);
            }
        }


    }
}
