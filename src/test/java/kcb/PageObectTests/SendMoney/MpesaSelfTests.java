package kcb.PageObectTests.SendMoney;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import kcb.BaseTest;
import kcb.PageObjects.HomePage;
import kcb.PageObjects.LoginPage;
import kcb.PageObjects.SendMoney.MpesaSelf;
import kcb.utils.JSONUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static kcb.DataConstants.*;
import static kcb.DataConstants.TEST_DATA_JSON_AMOUNT;

public class MpesaSelfTests extends BaseTest {
    HomePage homePage;
    MpesaSelf mpesaSelf;


    @Test
    public void testMpesaSelf() throws InterruptedException {

        homePage = new HomePage(driver);
        mpesaSelf = new MpesaSelf(driver);
        ExtentTest test = extentReporter.createTest("Send Money", "Send to self mpesa");

        JSONObject jsonObject=
                new JSONUtils()
                        .getJSONObject(TEST_DATA_JSON_FILE)
                        .getJSONObject(TEST_DATA_JSON_TRANSACTIONS);

        String amnt = jsonObject.getString(TEST_DATA_JSON_AMOUNT);
        mpesaSelf.sendMoney().inputAmount(amnt).
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
