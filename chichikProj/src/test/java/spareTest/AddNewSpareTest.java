package spareTest;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import pages.SparesPage;
import parentTest.ParentTest;

public class AddNewSpareTest extends ParentTest {
    final String nameOfNewSpare = "UniqueSpareName";

    @Test
    public void addNewSpare() {
        loginPage.userLogIn("Student", "909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuSpare();
        sparePage.checkCurrentUrl();
        sparePage.deletingSparesWithName(nameOfNewSpare);
        sparePage.clickAddButton();
        editSparesPage.checkCurrentUrl();
        editSparesPage.enterSpareName(nameOfNewSpare);
        editSparesPage.selectSpareType("4");
        editSparesPage.clickButtonCreate();
        sparePage.checkCurrentUrl();


        checkAcceptanceCriteria("new spare wasn't added", sparePage.isNewSpareAdded(nameOfNewSpare), true);
    }

    @After
    public void deletingNewSpare() {
        sparePage.deletingSparesWithName(nameOfNewSpare);


    }
}

