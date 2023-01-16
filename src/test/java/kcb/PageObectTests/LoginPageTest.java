package kcb.PageObectTests;

import kcb.BaseTest;
import kcb.PageObjects.LoginPage;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class LoginPageTest extends BaseTest {

        
         LoginPage loginPage;

       
          @Test()
    public void testLogin() throws MalformedURLException {
                AndroidSetup();
             loginPage = new LoginPage(driver);
               loginPage.enterUserName().
                             enterPhoneNo("799945282").
                           clickProceedBtn().tapAllow().pinCode();
        
               }
 

         }