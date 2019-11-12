package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResultSearchPage {

    private WebDriver driver;
    private SearchQuery query;

    private WebElement arrivalDateInputSearch;


    public ResultSearchPage(WebDriver driver, SearchQuery query){
        this.driver = driver;
        this.query = query;
        PageFactory.initElements(driver, this);
    }

}