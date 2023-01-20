package kcb.PageObectTests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import kcb.BaseTest;
import kcb.PageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    HomePage homePage;


    @Test
   public void testHomePage(){
                homePage = new HomePage(driver);
                ExtentTest test = extentReporter.createTest("Home Page","Test Home Page Loading");

                try {
                    test.log(Status.INFO, "Verifying home page details");
                    if(homePage.VerifyProfile().equalsIgnoreCase("ELLY O.")){
                               Assert.assertTrue(true);
                        test.log(Status.INFO, "Checking customer initials");
                          }
                    else{
                        Assert.assertTrue(false);
                        test.log(Status.FAIL, "Home page loading error ");
                      }
                } catch (Exception e ){
                        e.printStackTrace();
               }
                String Expected = "ELLY O.";
                String Actual = homePage.VerifyProfile();

                Assert.assertEquals(Expected, Actual);
                test.log(Status.PASS, "Homepage Loaded successfully");


           }

    @Test
    public void testHomeProfile(){
        homePage = new HomePage(driver);
        ExtentTest test = extentReporter.createTest("Customer profile","Check Customer Profile");

        try {
            homePage.clickPrf();
            String Actual = "ELLY OMONDI OBARE";
            String Expected = homePage.VerifyName();

            Assert.assertEquals(Actual, Expected);
            test.log(Status.PASS, "Customer profile check success");


        } catch (Exception e ){
            e.printStackTrace();
        }
        homePage.clickBck();


    }
}


   /* if(homePage.VerifyName().equalsIgnoreCase("ELLY OMONDI OBARE") &&  (homePage.VerifyNumber().equalsIgnoreCase("0799945282"))){
                test.log(Status.INFO,"Verifying customer name and number");
                Assert.assertEquals();
                test.log(Status.PASS, "Customer profile check success");

            }*/
           /* else
                Assert.assertTrue(false);
                test.log(Status.INFO, "Customer mismatch");
                test.log(Status.FAIL,"Customer profile not correct");
            */


/*
                if (!Expected.equals(Actual)){
                    test.log(Status.FAIL, "Details not correct");
                }else {
                    Assert.assertEquals(Expected, Actual);
                    test.log(Status.PASS, "Homepage Loaded successfully");
                }*/