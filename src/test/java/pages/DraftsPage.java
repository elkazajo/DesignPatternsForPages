package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DraftsPage extends AbstractPage{
    @FindBy(xpath = "//a[@href=\"/drafts/\"]")
    WebElement drafts;
    @FindBy(xpath = "//span[@title=\"selenium.tester@mail.ru\"][1]")
    WebElement lastSaved;

    public DraftsPage(WebDriver driver) {
        super(driver);
    }

    public DraftsPage openDrafts() {
        drafts.click();
        return this;
    }

    public boolean isInDrafts() {
        waitForElementPresence(lastSaved);
        return isElementPresent(lastSaved);
    }
}
