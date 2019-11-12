package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.HomePage;
import page.SearchQuery;

public class WebDriverCityTravelTest {
    private WebDriver driver;

    @BeforeMethod
    public void browserSetup(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\Диана\\Downloads\\chromedriver.exe");
        driver = new ChromeDriver();
    }


    @AfterMethod(alwaysRun = true)
    public void browserTearDown(){
        driver.quit();
        driver = null;
    }


    @Test
    public void searchHotelsInIncorrectCity(){
        SearchQuery hotelTerms = new SearchQuery("tdytsdytgliu", "14/11/2019", "16/11/2019", "2", "0");
        String addressOfExpectedPageForLongStay = new HomePage(driver)
                .openPage()
                .searchHotelsByWrongParameters(hotelTerms)
                .errorMessage();

        Assert.assertTrue(addressOfExpectedPageForLongStay.equals("Выбран неизвестный город"));
    }

}
