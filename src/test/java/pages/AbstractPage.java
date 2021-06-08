package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractPage {
    private WebDriver driver;
    private static final long TIMEOUT_IN_SECONDS = 10;
    private static final long MILLIS = 500;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public boolean isElementPresent(WebElement element) {
        return element.isDisplayed();
    }

    public void waitForElementPresence(WebElement element) {
        new WebDriverWait(driver, TIMEOUT_IN_SECONDS).pollingEvery(Duration.ofMillis(MILLIS)).until(ExpectedConditions.visibilityOfAllElements(element));
    }

    protected void openPage(String url) {
        driver.get(url);
    }
}
