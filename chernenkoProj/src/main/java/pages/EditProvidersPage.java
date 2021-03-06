package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditProvidersPage extends ParentPage {
    @FindBy(id = "prov_cus_proCustName")
    private WebElement nameOfCust;

    @FindBy(id = "prov_cus_proCustAddress")
    private WebElement addressOfCust;

    @FindBy(id = "prov_cus_proCustPhone")
    private WebElement phoneOfCust;

    @FindBy(xpath = ".//button[@type='submit']")
    private WebElement buttonCreate;

    @FindBy(id = "prov_cus_proCustIsFl")
    private WebElement privatePersonTypeOfChB;

    @FindBy(id = ".prov_cus_isOurFirm")
    private WebElement isOurFirmTypeOfChB;
    @FindBy(xpath = ".//button[@type='submit'][contains(text(),'Удалить')]")
    private WebElement buttonDelete;


    public EditProvidersPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/providers/edit");
    }

    public void enterCustName(String name) {
        actionWithOurElements.enterTextIntoElement(nameOfCust, name);
    }

    public void enterCustAddress(String address) {
        actionWithOurElements.enterTextIntoElement(addressOfCust, address);
    }

    public void enterCustPhone(String phone) {
        actionWithOurElements.enterTextIntoElement(phoneOfCust, phone);
    }

    public void clickButtonCreate() {
        actionWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectCheckBoxPrivatePerson(String neededState) {
        actionWithOurElements.setCheckBoxToNeededState(privatePersonTypeOfChB, neededState);
    }

    public void selectCheckBoxIsOurFirm(String neededState){
        actionWithOurElements.setCheckBoxToNeededState(isOurFirmTypeOfChB, neededState);
    }

    public void clickButtonDelete() {
        actionWithOurElements.clickOnElement(buttonDelete);
    }
}
