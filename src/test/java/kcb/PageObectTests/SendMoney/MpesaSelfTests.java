package kcb.PageObectTests.SendMoney;

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

        mpesaSelf.sendMoney().inputAmount("2").
                submit();
        mpesaSelf.getConfrimation();

        String Actual = mpesaSelf.getConfrimation();
        String Expected ="Your request is being processed, please wait for the confirmation message.";
        Assert.assertEquals(Actual,Expected);
        mpesaSelf.confirm();

        Thread.sleep(2000);

    }
}
