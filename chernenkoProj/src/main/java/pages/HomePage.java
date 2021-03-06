package pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//div[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpares;

    @FindBy(xpath = ".//a[@href='/dictionary/providers']")
    private WebElement subMenuProviders;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarapresent(){
        return actionWithOurElements.isElementPresent(avatar);
    }

    public void checkAvatarIsPresent() {
        Assert.assertTrue("Avatar is not present", isAvatarapresent());
    }

    public void clickOnMenuDictionary (){
        actionWithOurElements.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares(){
        actionWithOurElements.clickOnElement(subMenuSpares);
    }


    public void clickOnSubMenuProviders() {
        actionWithOurElements.clickOnElement(subMenuProviders);
    }
}
