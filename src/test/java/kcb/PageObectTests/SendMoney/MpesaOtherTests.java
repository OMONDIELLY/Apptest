package kcb.PageObectTests.SendMoney;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import kcb.BaseTest;
import kcb.PageObjects.HomePage;
import kcb.PageObjects.SendMoney.MpesaOther;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MpesaOtherTests extends BaseTest {

    HomePage homePage;
    MpesaOther mpesaOther;
    @Test
    public void testMpesaOther() throws InterruptedException {
        homePage = new HomePage(driver);
        mpesaOther = new MpesaOther(driver);
        ExtentTest test = extentReporter.createTest("Mpesa Other","Send Money to other Mpesa");

        mpesaOther.sendMoney("0720681195").inputAmount("2").
                submit();
        mpesaOther.getConfrimation();

        test.log(Status.INFO, "Waiting for confirmation");


        String Actual = mpesaOther.getConfrimation();
        String Expected ="Your request is being processed, please wait for the confirmation message.";
        Assert.assertEquals(Actual,Expected);

        test.log(Status.PASS, "Send Money Success");

        mpesaOther.confirm();
        if(!Actual.equals(Expected)){
            test.log(Status.FAIL, "Send money Failed");

        }


        Thread.sleep(2000);

    }
}

/*else {
            test.log(Status.PASS, "Send Money Success");
        }*/