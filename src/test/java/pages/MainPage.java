package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends AbstractPage {
    @FindBy(xpath = "//a[@href=\"/compose/\"]")
    WebElement composeLetter;

    @FindBy(xpath = "//input[@tabindex=\"100\"]")
    WebElement addresseeInputXpath;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public MainPage clickToComposeLetter() {
        waitForElementPresence(composeLetter);
        composeLetter.click();
        return this;
    }

    public boolean isLetterOpen() {
        waitForElementPresence(addresseeInputXpath);
        return isElementPresent(addresseeInputXpath);
    }
}
