package kcb.PageObectTests.BuyAirtime;

import kcb.BaseTest;
import kcb.PageObjects.BuyAirtime.SafaricomAirtimeSelf;
import kcb.PageObjects.HomePage;
import org.openqa.selenium.StaleElementReferenceException;
import org.testng.annotations.Test;
import java.net.MalformedURLException;


public class SafaricomAirtimeSelfTests extends BaseTest {

    HomePage homePage;
    SafaricomAirtimeSelf safAirTime;

    @Test(priority = 3)
    public void buyAirtimeSafSelf() throws MalformedURLException, InterruptedException {

        homePage = new HomePage(driver);
        safAirTime= new SafaricomAirtimeSelf(driver);
        try {
            safAirTime.buyAirtime()
             .inputAmount("1")
                    .submitPurchase().finishPurchs();
        }catch (StaleElementReferenceException err){
            err.printStackTrace();
        }

    }

}

