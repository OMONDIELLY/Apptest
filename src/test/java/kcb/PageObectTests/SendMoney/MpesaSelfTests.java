package kcb.PageObectTests.SendMoney;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import kcb.BaseTest;
import kcb.PageObjects.HomePage;
import kcb.PageObjects.LoginPage;
import kcb.PageObjects.SendMoney.MpesaSelf;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MpesaSelfTests extends BaseTest {
    HomePage homePage;
    MpesaSelf mpesaSelf;


    @Test
    public void testMpesaSelf() throws InterruptedException {

        homePage = new HomePage(driver);
        mpesaSelf = new MpesaSelf(driver);
        ExtentTest test = extentReporter.createTest("Send Money", "Send to self mpesa");

        mpesaSelf.sendMoney().inputAmount("2").
                submit();

        test.log(Status.INFO,"Clicked send money, entered amount and submitted");
        mpesaSelf.getConfrimation();

        test.log(Status.INFO,"Waiting for Confirmation");

        String Actual = mpesaSelf.getConfrimation();
        String Expected ="Your request is being processed, please wait for the confirmation message.";
        mpesaSelf.confirm();
        Assert.assertEquals(Actual,Expected);
        test.log(Status.PASS,"Send money success");

        Thread.sleep(2000);

    }
}
