package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {

    @FindBy (xpath = ".//*[@data-original-title='Add']")
    private WebElement addButon;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }

    public void clickAddButton(){
        actionWithOurElements.clickOnElement(addButon);
    }

}