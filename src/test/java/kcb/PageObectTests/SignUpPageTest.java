package kcb.PageObectTests;

import kcb.PageObjects.SignUpPage;
import org.testng.annotations.Test;
import kcb.BaseTest;
public class SignUpPageTest extends BaseTest {

    SignUpPage signUpPage;

    @Test
    public void testSignUp()  {
        signUpPage = new SignUpPage(driver);
        signUpPage.clickEnterCountry("Kenya");
        signUpPage.clickEnterAddress("40100");
        signUpPage.clickEnterEmail("obare@gmail.com");
        signUpPage.clickEnterPhone("0799945282");

    }


}
