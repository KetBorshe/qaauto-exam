

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;


public class SearchGoogleTest {

    private WebDriver driver;
    public SearchGooglePage searchGooglePage;

    @BeforeMethod
    public void beforeMethod() {
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        searchGooglePage = new SearchGooglePage(driver);
    }

    @AfterMethod
    public void afterMethod() {
        driver.quit();
    }

    String searchValue = "Selenium";

    @Test
    public void searchGoogle(){

        Assert.assertTrue(searchGooglePage.isPageLoaded(),
                "Search page was not loaded.");
        ResultGooglePage resultGooglePage = searchGooglePage.search(searchValue);
        Assert.assertEquals(resultGooglePage.getSearchResultsCount(),9, "The result on the first page was not equals 10");
        List<String> searchResults = resultGooglePage.getSearchResults();
        for(String searchResult : searchResults) {
            Assert.assertTrue(searchResult.contains(searchValue),"searchTerm: " +searchValue + " not found in : " +searchResult);
        }
        resultGooglePage.openSecondPage();

        List<String> searchResultsOnSecondPage = resultGooglePage.getSearchResults();
        for(String searchResult : searchResultsOnSecondPage) {
            Assert.assertTrue(searchResult.contains(searchValue.toLowerCase()),"searchTerm: " +searchValue + " not found in : " +searchResult);
        }


    }
}
