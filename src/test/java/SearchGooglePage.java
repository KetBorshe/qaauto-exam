import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static java.lang.Thread.sleep;

public class SearchGooglePage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@name='q']")
    private WebElement searchField;

    public SearchGooglePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public ResultGooglePage search(String searchValue){
        searchField.sendKeys(searchValue);
        searchField.sendKeys(Keys.ENTER);
        try {
            sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return new ResultGooglePage(driver);
    }

    public boolean isPageLoaded() {
        return driver.getCurrentUrl().contains("www.google.com/");
    }

}
