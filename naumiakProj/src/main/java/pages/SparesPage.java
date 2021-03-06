package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage{

    @FindBy (xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonAdd;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickOnButtonAdd () {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public boolean isNewSpareAdded(String nameOfNewSpare) {
        return actionsWithOurElements.isElementPresent(".//*[text()='" + nameOfNewSpare + "']");
    }

    public boolean isSpareInList(String nameOfNewSpare) {
        return actionsWithOurElements.isElementInList(".//*[text()='" + nameOfNewSpare + "']");
    }

    public void clickOnSpare(String nameOfNewSpare) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + nameOfNewSpare + "']");
    }
}
