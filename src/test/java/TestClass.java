import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.*;
import utils.WebDriverCreator;

public class TestClass {
    String URL = "https://mail.ru/";
    String userName = "selenium.tester";
    String userPassword = "PRARppro3*u3";
    String addressee = "selenium.tester@mail.ru";
    String subject = "Hello";
    String bodyText = "Hello World!";

    WebDriver driver;
    LoginPage loginPage;
    MainPage mainPage;
    LetterPage letterPage;
    DraftsPage draftsPage;
    DraftsLetterPage draftsLetterPage;
    LogoutPage logoutPage;

    @BeforeClass
    public void instanceCreator() {
        driver = new WebDriverCreator().setDriver();
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        letterPage = new LetterPage(driver);
        draftsPage = new DraftsPage(driver);
        draftsLetterPage = new DraftsLetterPage(driver);
        logoutPage = new LogoutPage(driver);
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void loginSuccessAssert() {
        loginPage.start(URL).inputUserName(userName)
                .clickLoginButton()
                .inputPassword(userPassword)
                .enterPasswordButton();
        Assert.assertTrue(loginPage.verifyLoginSuccess());
    }

    @Test(dependsOnMethods = { "loginSuccessAssert" })
    public void clickToComposeLetterAssert() {
        mainPage.clickToComposeLetter();
        Assert.assertTrue(mainPage.isLetterOpen());
    }

    @Test(dependsOnMethods = { "clickToComposeLetterAssert" })
    public void letterCreationAssert() {
        letterPage.enterAddressee(addressee)
                .enterSubject(subject)
                .enterBodyText(bodyText)
                .saveToDrafts()
                .closeLetterPage();
        Assert.assertTrue(letterPage.isStillOpen());
    }
    @Test(dependsOnMethods = { "letterCreationAssert" })
    public void letterIsInDraftsAssert() {
        draftsPage.openDrafts();
        Assert.assertTrue(draftsPage.isInDrafts());
    }

    @Test(dependsOnMethods = { "letterIsInDraftsAssert" })
    public void addresseeAssert() {
        draftsLetterPage.openLastSaved();
        Assert.assertEquals(draftsLetterPage.verifyAddressee(), addressee);
    }

    @Test(dependsOnMethods = { "addresseeAssert" })
    public void mailSentAssert() {
        draftsLetterPage.sendMail();
        Assert.assertTrue(draftsLetterPage.verifyMailIsSent());
    }

    @Test(dependsOnMethods = { "mailSentAssert" })
    public void logoutAssert() {
        logoutPage.pressDropdown().pressLogout();
        Assert.assertTrue(logoutPage.isLogout());
    }
}
