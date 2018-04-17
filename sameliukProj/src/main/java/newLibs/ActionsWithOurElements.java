package newLibs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        logger = Logger.getLogger(getClass());
    }

    public void enterTextIntoElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");

        } catch (Exception e) {
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

    public void click(WebElement webElement) {
        try {
            webElement.click();
            logger.info("submitButton Вход was clicked");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");

        }
    }
}
