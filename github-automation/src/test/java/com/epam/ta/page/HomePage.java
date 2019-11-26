package com.epam.ta.page;

import com.epam.ta.model.SearchQuery;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage{

    private static final String MAIN_URL = "https://city.travel/hotel";

    private final static String XPATH_FOR_SEARCH_BUTTON = "//input[@class='btn btn-lg']";
    private final static String XPATH_FOR_ROOMS_BUTTON = "//input[@id='dummypeople_hotel']";
    private final static String XPATH_FOR_ADULTS_SELECT = "//input[@class='spinner form-control' and @name = 'rooms[0][adults]']";
    private final static String XPATH_FOR_CHILDS_SELECT = "//input[@class='spinner form-control' and @name = 'rooms[0][kids][num]']";
    private final static String XPATH_FOR_DEPARTURE_DATE = "//input[@id='datein']";
    private final static String XPATH_FOR_ARRIVAL_DATE = "//input[@id='dateout']";
    private final static String XPATH_FOR_PLACE = "//input[@id='city-in']";
    private final static String XPATH_FOR_OK_BUTTON = "//input[@class='btn close-y]";

    private WebDriver driver;

    @FindBy(xpath = XPATH_FOR_PLACE)
    private WebElement place;

    @FindBy(xpath = XPATH_FOR_ARRIVAL_DATE)
    private WebElement arrivalDate;

    @FindBy(xpath = XPATH_FOR_DEPARTURE_DATE)
    private WebElement departureDate;

    @FindBy(xpath = XPATH_FOR_ADULTS_SELECT)
    private WebElement adults;

    @FindBy(xpath = XPATH_FOR_SEARCH_BUTTON)
    private WebElement searchButton;

    @FindBy(xpath = XPATH_FOR_CHILDS_SELECT)
    private WebElement childs;

    @FindBy(xpath = XPATH_FOR_ROOMS_BUTTON)
    private WebElement rooms;

    @FindBy(xpath = XPATH_FOR_OK_BUTTON)
    private WebElement okButton;

    @FindBy(xpath = "//div[@class='intro']")
    private WebElement errorMessage;

    public HomePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public HomePage openPage() {
        driver.get(MAIN_URL);
        return this;
    }

    public ResultSearchPage searchHotelsByParameters(SearchQuery query) {
        place.sendKeys(query.getPlace());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_ARRIVAL_DATE)));
        arrivalDate.sendKeys(query.getArrivalDate());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_DEPARTURE_DATE)));
        departureDate.sendKeys(query.getDepartureDate());
        rooms.click();
        adults.sendKeys(query.getAdults());
        childs.sendKeys(query.getChildren());
        okButton.click();
        searchButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_SEARCH_BUTTON)));
        searchButton.click();
        return new ResultSearchPage(driver, query);
    }

    public HomePage searchHotelsByWrongParameters(SearchQuery query) {
        place.clear();
        place.sendKeys(query.getPlace());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_ARRIVAL_DATE)));
        arrivalDate.sendKeys(query.getArrivalDate());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_DEPARTURE_DATE)));
        departureDate.sendKeys(query.getDepartureDate());
        searchButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_SEARCH_BUTTON)));
        searchButton.click();
        return new HomePage(driver);
    }

    public String errorMessage(){
        return this.errorMessage.getText();
    }

}
