package loginTest;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;


public class LoginTestWithPageObject extends ParentTest{
    @Test
    public  void  validLogIn() {
        logInPage.openPage();
        logInPage.enterLogin("Student");
        logInPage.enterPass("909090");
        logInPage.clickSubmitButton();

        checkAC("Avatar is not present", homePage.isAvatarPresent(), true);
    }
    @Test
    public void invalidLogIn(){
        logInPage.userLogIn("Student","906090");
        checkAC("Avatar should not be present",homePage.isAvatarPresent(),false);

    }
}

