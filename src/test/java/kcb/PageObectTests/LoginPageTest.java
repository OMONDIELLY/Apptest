package kcb.PageObectTests;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import kcb.BaseTest;
import kcb.PageObjects.LoginPage;
import kcb.utils.JSONUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static kcb.DataConstants.*;

public class LoginPageTest extends BaseTest {

        
         LoginPage loginPage;

       
          @Test()
          public void testLogin() throws MalformedURLException {


             AndroidSetup();
             loginPage = new LoginPage(driver);

              JSONObject jsonObject_validCredentials =
                      new JSONUtils()
                              .getJSONObject(TEST_DATA_JSON_FILE)
                              .getJSONObject(TEST_DATA_JSON_VALID_USER);


             String phoneNo = jsonObject_validCredentials.getString(TEST_DATA_JSON_PHONE_NO);

             ExtentTest test = extentReporter.createTest("Login","Test valid user login");


             loginPage.enterGetStarted();
             test.log(Status.INFO,"Clicked get started and selected country");

             loginPage.enterPhoneNo(phoneNo).
                     clickProceedBtn().tapAllow().pinCode();
             test.log(Status.INFO, "Entered correct phone number and user pin");

             if(loginPage.home().equalsIgnoreCase("HOME")){
                 Assert.assertTrue(true);
                 test.log(Status.PASS,"User logged in succefully");
             }
             else{
                 Assert.assertTrue(false);
                 test.log(Status.FAIL, "Home page loading error ");
             }
          }


 

         }