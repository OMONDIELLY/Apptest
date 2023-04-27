package kcb.PageObectTests.SendMoney;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import kcb.BaseTest;
import kcb.PageObjects.HomePage;
import kcb.PageObjects.SendMoney.MpesaOther;
import kcb.utils.JSONUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static kcb.DataConstants.*;

public class MpesaOtherTests extends BaseTest {

    HomePage homePage;
    MpesaOther mpesaOther;
    @Test
    public void testMpesaOther() throws InterruptedException {
        homePage = new HomePage(driver);
        mpesaOther = new MpesaOther(driver);
        ExtentTest test = extentReporter.createTest("Mpesa Other","Send Money to other Mpesa");

//reading json data
        JSONObject jsonObject=
                new JSONUtils()
                        .getJSONObject(TEST_DATA_JSON_FILE)
                        .getJSONObject(TEST_DATA_JSON_TRANSACTIONS);


        String othrPhoneNo = jsonObject.getString(TEST_DATA_JSON_OTHER_PHONE_NO);
        String amnt = jsonObject.getString(TEST_DATA_JSON_AMOUNT);

        mpesaOther.sendMoney(othrPhoneNo).inputAmount(amnt).
                submit().getConfrimation();

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