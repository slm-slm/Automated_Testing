package hu.unideb.inf;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Optional;

public class HomePage {

    private static final String PAGE_URL = "http://automationpractice.com/";

    private static final By ACCOUNT_INFO = By.className("info-account");
    private static final By CART_WARNING = By.xpath("/html/body/div/div[2]/div/div[3]/div/p");
    private static final By CONTACT_ERROR = By.cssSelector("#center_column > div > ol > li");
    private static final By LOGIN_ERROR = By.xpath("//*[@id=\"center_column\"]/div[1]/ol/li");
    private static final By NEWSLETTER_ERROR = By.xpath("/html/body/div/div[2]/div/p");
    private static final By ORDER_HISTORY_ERROR = By.xpath("/html/body/div/div[2]/div/div[3]/div/div/p");
    private static final By SEARCH_RESULT_ERROR = By.xpath("/html/body/div/div[2]/div/div[3]/div[2]/p");
    private static final By SEARCH_RESULT_MESSAGE = By.className("heading-counter");
    private static final By SIGNUP_ERROR = By.xpath("/html[1]/body[1]/div[1]/div[2]/div[1]/div[3]/div[1]/div[1]/div[1]/form[1]/div[1]/div[1]/ol[1]/li[1]");

    @FindBy(className = "login")
    private WebElement signInLink;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButton;

    @FindBy(id = "SubmitCreate")
    private WebElement signUpButton;

    @FindBy(id = "contact-link")
    private WebElement contactUsLink;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[3]/div/div/div[3]/div/a")
    private WebElement cartLink;

    @FindBy(name = "submitNewsletter")
    private WebElement newsletterButton;

    @FindBy(name = "submit_search")
    private WebElement SearchButton;

    @FindBy(id = "submitMessage")
    private WebElement sendButton;

    @FindBy(xpath = "/html/body/div/div[2]/div/div[3]/div/div/div[1]/ul/li[1]/a")
    private WebElement orderHistoryButton;

    @FindBy(xpath = "/html/body/div/div[1]/header/div[2]/div/div/nav/div[2]/a")
    private WebElement signOutButton;

    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(PAGE_URL);
        PageFactory.initElements(driver, this);
    }

    public void clickSignInLink() {
        signInLink.click();
    }

    public void clickSignInButton() {
        signInButton.click();
    }

    public void clickSignUpButton() {
        signUpButton.click();
    }

    public void clickSignOutButton() {
        signOutButton.click();
    }

    public void clickCartLink() {
        cartLink.click();
    }

    public void clickNewsLetterButton() {
        newsletterButton.click();
    }

    public void clickSearchButton() {
        SearchButton.click();
    }

    public void clickOrderHistoryButton() {
        orderHistoryButton.click();
    }

    public Optional<String> getLoginError() {
        return getErrorMessage(LOGIN_ERROR);
    }

    public Optional<String> getContactError() {
        return getErrorMessage(CONTACT_ERROR);
    }

    public Optional<String> getCartWarningMessage() {
        return getErrorMessage(CART_WARNING);
    }

    public Optional<String> getSignUpError() {
        return getErrorMessage(SIGNUP_ERROR);
    }

    public Optional<String> getSearchResultMessage() {
        return getErrorMessage(SEARCH_RESULT_MESSAGE);
    }

    public Optional<String> getSearchResultError() {
        return getErrorMessage(SEARCH_RESULT_ERROR);
    }

    public Optional<String> getAccountInfoMessage() {
        return getErrorMessage(ACCOUNT_INFO);
    }

    public Optional<String> getOrderHistoryError() {
        return getErrorMessage(ORDER_HISTORY_ERROR);
    }
    public Optional<String> getNewsletterError() {
        return getErrorMessage(NEWSLETTER_ERROR);
    }

    public void fillField(String field, String value) {
        getField(By.id(field)).sendKeys(value);
    }

    public WebElement getField(By locator) {
        return driver.findElement(locator);
    }

    public WebElement getSignInLink() {
        return signInLink;
    }

    public WebElement getSignInButton() {
        return signInButton;
    }

    public WebElement getContactUsLink() {
        return contactUsLink;
    }

    public WebElement getSendButton() {
        return sendButton;
    }

    private Optional<String> getErrorMessage(By errorLocator) {
        Optional<WebElement> error = getError(errorLocator);
        if (error.isPresent()) {
            WebElement errorElement = error.get();
            return Optional.of(errorElement.getText());
        } else {
            return Optional.empty();
        }
    }

    private Optional<WebElement> getError(By errorLocator) {
        List<WebElement> elements = driver.findElements(errorLocator);
        if (elements.size() > 0) {
            return Optional.of(elements.get(0));
        } else {
            return Optional.empty();
        }
    }
}