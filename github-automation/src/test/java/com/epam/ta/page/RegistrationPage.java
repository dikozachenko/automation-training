package com.epam.ta.page;

import com.epam.ta.model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends AbstractPage {

    private static final String MAIN_URL = "https://city.travel/user/registration";

    private final static String XPATH_FOR_REGISTRATION_BUTTON = "//div[ @class='reg-bottom']";
    private final static String XPATH_FOR_INPUT_LAST_NAME ="//input[@name='surname']";
    private final static String XPATH_FOR_INPUT_FIRST_NAME ="//input[@name='name']";
    private final static String XPATH_FOR_INPUT_EMAIL ="//input[@name='email']";
    private final static String XPATH_FOR_INPUT_PASSWORD ="//input[@name='pass']";
    private final static String XPATH_FOR_CONFIRM_PASSWORD ="//input[@name='confirmpass']";

    private WebDriver driver;

    @FindBy(xpath = XPATH_FOR_INPUT_LAST_NAME)
    private WebElement lastName;

    @FindBy(xpath = XPATH_FOR_INPUT_FIRST_NAME)
    private WebElement firstName;

    @FindBy(xpath = XPATH_FOR_INPUT_EMAIL)
    private WebElement email;

    @FindBy(xpath = XPATH_FOR_INPUT_PASSWORD)
    private WebElement password;

    @FindBy(xpath = XPATH_FOR_CONFIRM_PASSWORD)
    private WebElement confirmPassword;

    @FindBy(xpath = XPATH_FOR_REGISTRATION_BUTTON)
    private WebElement regButton;

    @FindBy(xpath = "//div[@class='intro']")
    private WebElement message;


    public RegistrationPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    public RegistrationPage openPage() {
        driver.get(MAIN_URL);
        return this;
    }

    public RegistrationPage registration(User user){
        lastName.sendKeys(user.getLastName());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_INPUT_FIRST_NAME)));
        firstName.sendKeys(user.getFirstName());
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.presenceOfElementLocated(By.xpath(XPATH_FOR_INPUT_EMAIL)));
        email.sendKeys(user.getEmail());
        regButton = new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(By.xpath(XPATH_FOR_REGISTRATION_BUTTON)));
        regButton.click();
        return new RegistrationPage(driver);
    }

    public String message(){
        return this.message.getText();
    }
}
