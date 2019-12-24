package com.epam.ta.page;

import com.epam.ta.model.SearchQuery;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ResultSearchPage extends AbstractPage {

    private WebDriver driver;
    private SearchQuery query;

    private WebElement arrivalDateInputSearch;

    public ResultSearchPage(WebDriver driver, SearchQuery query) {
        super(driver);
        this.query = query;
        PageFactory.initElements(driver, this);
        logger.info("Opening search page");
    }

    @Override
    public ResultSearchPage openPage() {
        return this;
    }

}