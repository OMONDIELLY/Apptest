package kcb.PageObjects.BuyAirtime;

import kcb.BasePage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

import static java.lang.Thread.sleep;

public class SafaricomAirtimeSelf extends BasePage {

    public SafaricomAirtimeSelf(AppiumDriver appiumDriver) {
        super(appiumDriver);
    }

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/id_img_buy_airtime")
    public MobileElement clickBuyAirtime;

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/amount")
    public MobileElement inputAmountToBuy;


    @AndroidFindBy(id= "link_submit")
    public MobileElement submitBtn;

    @AndroidFindBy(id= "com.kcbbankgroup.android:id/link_proceed")
    public MobileElement proceedBtn;

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/status_action")
    public MobileElement finishPurch;
    public SafaricomAirtimeSelf buyAirtime() throws InterruptedException {
        sleep(1200);
        waitForElement(clickBuyAirtime);
        clickBuyAirtime.isDisplayed();
        click(clickBuyAirtime);
        return this;
    }

    public SafaricomAirtimeSelf inputAmount(String amount) throws InterruptedException {
        waitForElement(inputAmountToBuy);
        inputAmountToBuy.isDisplayed();
        sendKeys(inputAmountToBuy, amount);
        hideKeyBoard();
        return this;
    }

    public SafaricomAirtimeSelf submitPurchase() throws InterruptedException {
        waitForElement(submitBtn);
        submitBtn.isDisplayed();
        click(submitBtn);
        proceedBtn.click();
        //sendCode();
        return this;
    }

    public SafaricomAirtimeSelf finishPurchs() throws InterruptedException {
        waitForElement(finishPurch);
        finishPurch.isDisplayed();
        click(finishPurch);
        return this;
    }
}
