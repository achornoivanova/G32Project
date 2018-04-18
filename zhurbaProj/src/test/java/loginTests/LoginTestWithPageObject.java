package loginTests;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTestWithPageObject extends ParentTest {
    @Test
    public void validLogIn() {
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPassword("909090");
        loginPage.clickSubmitButton();

        checkAC("Avatar is NOT present", homePage.isAvatarPresent(), true);
    }

    @Test
    public void invalidLogIn(){
        loginPage.userLogin("Student", "909190");

        checkAC("Avatar should not be present", homePage.isAvatarPresent(), true);
    }
}
