package kcb.PageObectTests;

import kcb.PageObjects.LoginPage;
import kcb.PageObjects.SignUpPage;
import kcb.BaseTest;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginPageTest extends BaseTest {


    LoginPage loginPage;
    SignUpPage signUpPage;

    @Test
    public void testLogin() throws MalformedURLException {
         AndroidSetup();
        loginPage = new LoginPage(driver);
        loginPage.enterUserName("Elly");
        loginPage.enterPassword("12345");
        loginPage.clickBtn();

    }

    @Test
    public void testSignUp()  {
        signUpPage = new SignUpPage(driver);
        signUpPage.clickEnterCountry("Kenya");
        signUpPage.clickEnterAddress("40100");
        signUpPage.clickEnterEmail("obare@gmail.com");
        signUpPage.clickEnterPhone("0799945282");
        signUpPage.saveDetails();

    }
}
