package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractPage {
    @FindBy(xpath = "//input[@name=\"login\"]")
    WebElement loginInputForm;

    @FindBy(xpath = "//button[@data-testid=\"enter-password\"]")
    WebElement loginButton;

    @FindBy(xpath = "//input[@data-testid=\"password-input\"]")
    WebElement passwordInputForm;

    @FindBy(xpath = "//button[@data-testid=\"login-to-mail\"]")
    WebElement enterButton;

    @FindBy(xpath = "//a[@href=\"/compose/\"]")
    WebElement composeLetter;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public LoginPage inputUserName(String userName) {
        loginInputForm.sendKeys(userName);
        return this;
    }

    public LoginPage enterPasswordButton() {
        enterButton.click();
        return this;
    }

    public LoginPage inputPassword(String userPassword) {
        waitForElementPresence(passwordInputForm);
        passwordInputForm.sendKeys(userPassword);
        return this;
    }

    public LoginPage clickLoginButton() {
        loginButton.click();
        return this;
    }

    public boolean verifyLoginSuccess() {
        waitForElementPresence(composeLetter);
        return isElementPresent(composeLetter);
    }

    public LoginPage start(String url) {
        openPage(url);
        return this;
    }

}
