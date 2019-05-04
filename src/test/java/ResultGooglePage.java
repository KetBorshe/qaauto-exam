import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.sleep;

public class ResultGooglePage {

    private WebDriver driver;

    public ResultGooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResults;

    @FindBy(xpath = "//div[@class='srg']/div[@class='g']")
    private List<WebElement> searchResultsOnSecondPage;

    @FindBy(xpath = "//a[@aria-label='Page 2']")
    private WebElement pageGoogle;

    public int getSearchResultsCount(){
        searchResults.size();
        return  searchResults.size();
    }
    public List<String> getSearchResults() {
        List<String> searchResultList = new ArrayList<String>();
        for (WebElement searchResult : searchResults){

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", searchResult);
            String searchResultText = searchResult.getText();
            searchResultList.add(searchResultText);
        }
        return searchResultList;
    }

    public void openSecondPage(){
        pageGoogle.click();
    }



}
