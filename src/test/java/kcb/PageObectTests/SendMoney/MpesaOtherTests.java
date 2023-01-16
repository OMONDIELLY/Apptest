package kcb.PageObectTests.SendMoney;

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

        mpesaOther.sendMoney("0720681195").inputAmount("2").
                submit();
        mpesaOther.getConfrimation();

        String Actual = mpesaOther.getConfrimation();
        String Expected ="Your request is being processed, please wait for the confirmation message.";
        Assert.assertEquals(Actual,Expected);
        mpesaOther.confirm();

        Thread.sleep(2000);

    }
}
