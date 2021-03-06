package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    @FindBy(name = "_username")
    private WebElement inputLogin;

    @FindBy(id = "password")
    private WebElement inputPassword;

    @FindBy(tagName = "button")
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super (webDriver, "/logon");
    }

    @Step
    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com");
            logger.info("Login Page was opened SUCCESSFULLY.");
        } catch (Exception e) {
            logger.error("Login Page was NOT opened.");
            Assert.fail("Login Page was NOT opened.");
        }
    }

    @Step
    public void enterLogin(String login){
//        WebElement inputLogin = webDriver.findElement(By.name("_username"));                                          // declared in annotation '@FindBy'
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }

    @Step
    public void enterPassword(String password){
//        WebElement inputPassword = webDriver.findElement(By.id("password"));                                          // declared in annotation '@FindBy'
        actionsWithOurElements.enterTextInToElement(inputPassword, password);
    }

    @Step
    public void clickSubmitButton(){
//        WebElement buttonSubmit = webDriver.findElement(By.tagName("button"));                                        -- declared in annotation '@FindBy'
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    @Step
    public void userLogIn(String login, String password) {
        openPage();
        enterLogin(login);
        enterPassword(password);
        clickSubmitButton();
    }
}
