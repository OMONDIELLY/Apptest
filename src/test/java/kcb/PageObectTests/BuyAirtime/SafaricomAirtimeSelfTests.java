package kcb.PageObectTests.BuyAirtime;

import kcb.BaseTest;
import kcb.PageObjects.BuyAirtime.SafaricomAirtimeSelf;
import kcb.PageObjects.HomePage;
import kcb.utils.JSONUtils;
import org.json.JSONObject;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;
import java.net.MalformedURLException;
import static kcb.DataConstants.*;



public class SafaricomAirtimeSelfTests extends BaseTest {

    HomePage homePage;
    SafaricomAirtimeSelf safAirTime;

    @Test(priority = 3)
    public void buyAirtimeSafSelf() throws MalformedURLException, InterruptedException {

        homePage = new HomePage(driver);
        safAirTime= new SafaricomAirtimeSelf(driver);

   //reading data from json
        JSONObject jsonObject=
                new JSONUtils()
                        .getJSONObject(TEST_DATA_JSON_FILE)
                        .getJSONObject(TEST_DATA_JSON_TRANSACTIONS);

        String amnt = jsonObject.getString(TEST_DATA_JSON_AMOUNT);


        try {
            safAirTime.buyAirtime()
             .inputAmount(amnt)
                    .submitPurchase().finishPurchs();
        }catch (StaleElementReferenceException err){
            err.printStackTrace();
        }

    }

}

