package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    @FindBy(name="_username")
    private WebElement inputLogin;
    @FindBy(id="password")
    private WebElement inputPass;
    @FindBy(tagName="button")
    private WebElement buttonSubmit;



    public LoginPage(WebDriver webDriver) { super(webDriver ,"/login");
    }

    public void openPage() {
        try {
            webDriver.get("http://v3.test.itpmgroup.com"); // http://v3.test.itpmgroup.com/login
            logger.info("Login Page was opened");
        } catch (Exception e) {
            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");

        }
    }
    public void enterLogin(String login) {
       // WebElement inputLogin = webDriver.findElement(By.name("_username")); by annotation @FindBy(name="_username")
        actionsWithOurElements.enterTextInToElement(inputLogin, login);
    }
    public void enterPass(String pass){
       // WebElement inputPass = webDriver.findElement(By.id("password")); by @FindBy(id="password")
        actionsWithOurElements.enterTextInToElement(inputPass, pass);
    }
    public void clickSubmitButton (){
       // WebElement buttonSubmit= webDriver.findElement(By.tagName("button")); by @FindBy(tagName="button")
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    public void userLogin(String login, String pass) {
        openPage();
        enterLogin(login);
        enterPass(pass);
        clickSubmitButton();


    }
}