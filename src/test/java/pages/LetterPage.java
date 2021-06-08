package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LetterPage extends AbstractPage{
    @FindBy(xpath =  "//input[@tabindex=\"100\"]")
    WebElement addresseeInput;
    @FindBy(xpath = "//input[@tabindex=\"400\"]")
    WebElement subject;
    @FindBy(xpath = "//div[@tabindex=\"505\"]")
    WebElement bodyText;
    @FindBy(xpath = "//span[@tabindex=\"580\"]")
    WebElement saveToDraftsButton;
    @FindBy(xpath = "//button[@tabindex=\"700\"]")
    WebElement closeLetterButton;

    public LetterPage(WebDriver driver) {
        super(driver);
    }

    public LetterPage enterAddressee(String addressee) {
        waitForElementPresence(addresseeInput);
        addresseeInput.sendKeys(addressee);
        return this;
    }

    public LetterPage enterSubject(String letterSubject) {
        subject.sendKeys(letterSubject);
        return this;
    }

    public LetterPage enterBodyText(String mailText) {
        bodyText.sendKeys(mailText);
        return this;
    }

    public LetterPage saveToDrafts() {
        saveToDraftsButton.click();
        return this;
    }

    public LetterPage closeLetterPage() {
        closeLetterButton.click();
        return this;
    }

    public boolean isStillOpen() {
        return isElementPresent(closeLetterButton);
    }
}
