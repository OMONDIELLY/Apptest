package kcb.PageObectTests.BuyAirtime;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import kcb.BaseTest;
import kcb.PageObjects.BuyAirtime.SafaricomAirtimeOther;
import kcb.PageObjects.BuyAirtime.SafaricomAirtimeSelf;
import kcb.PageObjects.HomePage;
import kcb.utils.JSONUtils;
import org.json.JSONObject;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

import static kcb.BaseTest.driver;
import static kcb.DataConstants.*;
import static kcb.DataConstants.TEST_DATA_JSON_AMOUNT;

public class SafaricomAirtimeOtherTests extends BaseTest {


    HomePage homePage;
    SafaricomAirtimeOther safAirTimeOther;

    @Test(priority = 3)
    public void buyAirtimeSafSelf() throws MalformedURLException, InterruptedException {

        homePage = new HomePage(driver);
        safAirTimeOther= new SafaricomAirtimeOther(driver);

        ExtentTest test = extentReporter.createTest("Buy Airtime Other","Send Money to other Mpesa");
        //reading json data
        JSONObject jsonObject=
                new JSONUtils()
                        .getJSONObject(TEST_DATA_JSON_FILE)
                        .getJSONObject(TEST_DATA_JSON_TRANSACTIONS);


        String othrPhoneNo = jsonObject.getString(TEST_DATA_JSON_OTHER_PHONE_NO);
        String amnt = jsonObject.getString(TEST_DATA_JSON_AMOUNT);

        try {
            safAirTimeOther.buyAirtime(othrPhoneNo)
                    .inputAmount(amnt)
                    .submitPurchase().finishPurchs();

            test.log(Status.INFO, "Waiting for confirmation");

            test.log(Status.PASS, "Buy Airtime Success");
        }catch (StaleElementReferenceException err){
            err.printStackTrace();
        }

    }
}
