package providersTest;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewProviderTest extends ParentTest {
    final String nameOfCustName = "aaa";

    @Test
    public void addNewProviderTest(){
        loginPage.userLogin("Student","909090");
        homePage.checkAvatarIsPresent();
        homePage.checkCurrentUrl();
        homePage.clickOnMenuDictionary();
        homePage.clickOnSubMenuProviders();
        providersPage.checkCurrentUrl();
        providersPage.clickOnButtonPlus();
        editProvidersPage.checkCurrentUrl();
        editProvidersPage.enterCustName(nameOfCustName);
        editProvidersPage.enterCustAddress("aaa");
        editProvidersPage.enterCustPhone("111");
        editProvidersPage.selectCheckBoxPrivatePerson("check");
        editProvidersPage.clickButtonCreate();
        providersPage.checkCurrentUrl();

        checkAC("New Provider was not added",
                providersPage.isNewProviderAdded(nameOfCustName),
                true);
    }

    @After
    public void  deleteInNewPpovider(){
        while (providersPage.isProviderInList(nameOfCustName)){
            providersPage.clickOnProvider(nameOfCustName);
            editProvidersPage.clickButtonDelete();
        }
    }

}