package kcb.PageObectTests;

import kcb.BaseTest;
import kcb.PageObjects.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class HomePageTest extends BaseTest {

    HomePage homePage;

    @Test
   public void testHomePage(){
                homePage = new HomePage(driver);
                try {
                    if(homePage.VerifyProfile().equalsIgnoreCase("ELLY O.")){
                               Assert.assertTrue(true);
                          }
                    else{
                        Assert.assertTrue(false);
                      }
                } catch (Exception e ){
                        e.printStackTrace();
               }
                String Expected = "ELLY O.";
                String Actual = homePage.VerifyProfile();
                Assert.assertEquals(Expected, Actual);

           }

    @Test
    public void testHomeProfile(){
        homePage = new HomePage(driver);
        try {
            homePage.clickPrf();
            if(homePage.VerifyName().equalsIgnoreCase("ELLY OMONDI OBARE")){
                Assert.assertTrue(true);
            } else if (homePage.VerifyNumber().equalsIgnoreCase("0799945282")) {
                Assert.assertTrue(true);
            }
            else{
                Assert.assertTrue(false);
            }
        } catch (Exception e ){
            e.printStackTrace();
        }
        homePage.clickBck();


    }
}