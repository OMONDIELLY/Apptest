package kcb.PageObjects.BuyAirtime;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import kcb.BasePage;
import kcb.PageObjects.SendMoney.MpesaOther;
import org.apache.log4j.Logger;

import static java.lang.Thread.sleep;

public class SafaricomAirtimeOther extends BasePage {


    public SafaricomAirtimeOther(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    Logger logger = Logger.getLogger(SafaricomAirtimeOther.class);

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/id_img_buy_airtime")
    public MobileElement clickBuyAirtime;

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/radio_other")
    public MobileElement sendOther;


    @AndroidFindBy(id = "com.kcbbankgroup.android:id/recipient_acc")
    public MobileElement inputRecepientNumber;


    @AndroidFindBy(id = "com.kcbbankgroup.android:id/amount")
    public MobileElement inputAmountToBuy;


    @AndroidFindBy(id= "link_submit")
    public MobileElement submitBtn;

    @AndroidFindBy(id= "com.kcbbankgroup.android:id/link_proceed")
    public MobileElement proceedBtn;

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/status_action")
    public MobileElement finishPurch;

    public SafaricomAirtimeOther buyAirtime(String phoneNo) throws InterruptedException {
        sleep(1200);
        waitForElement(clickBuyAirtime);
        click(clickBuyAirtime);
        click(sendOther);
        sendKeys(inputRecepientNumber,phoneNo);
        logger.info("Entered phone no");
        return this;
    }

    public SafaricomAirtimeOther inputAmount(String amount) throws InterruptedException {
        waitForElement(inputAmountToBuy);
        inputAmountToBuy.isDisplayed();
        sendKeys(inputAmountToBuy, amount);
        hideKeyBoard();
        return this;
    }

    public SafaricomAirtimeOther submitPurchase() throws InterruptedException {
        waitForElement(submitBtn);
        submitBtn.isDisplayed();
        click(submitBtn);
        proceedBtn.click();
        //sendCode();
        return this;
    }

    public SafaricomAirtimeOther finishPurchs() throws InterruptedException {
        waitForElement(finishPurch);
        finishPurch.isDisplayed();
        click(finishPurch);
        return this;
    }
}
