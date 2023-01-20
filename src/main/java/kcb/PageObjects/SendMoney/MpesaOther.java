package kcb.PageObjects.SendMoney;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import kcb.BasePage;
import org.apache.log4j.Logger;

public class MpesaOther extends BasePage {

    Logger logger = Logger.getLogger(MpesaOther.class);
    public MpesaOther(AppiumDriver<MobileElement> driver) {
        super(driver);
    }


    @AndroidFindBy(id = "id_send_mpesa")
    public MobileElement sendMny;

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/radio_other")
    public MobileElement sendOther;

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/recipient_acc")
    public MobileElement inputRecepientNumber;

    @AndroidFindBy(xpath = "//android.widget.EditText[contains(@resource-id,'com.kcbbankgroup.android:id/amount')]")
    public MobileElement amountField;

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/link_submit")
    public MobileElement send;


    @AndroidFindBy(id= "com.kcbbankgroup.android:id/link_proceed")
    public MobileElement submitBtn;


    @AndroidFindBy(id = "com.kcbbankgroup.android:id/status_summary")
    public MobileElement confSummary;


    @AndroidFindBy(id = "com.kcbbankgroup.android:id/link_status_1")
    public MobileElement confirmationPg;

    public MpesaOther sendMoney(String phoneNo) throws InterruptedException {
        waitForElement(sendMny);
        click(sendMny);
        logger.info("Clicked send money option");
        click(sendOther);
        logger.info("Clicked other option");
        sendKeys(inputRecepientNumber,phoneNo);
        logger.info("Entered phone no");
        return this;

    }


    public MpesaOther inputAmount(String amnt) throws InterruptedException {
        waitForElement(amountField);
        click(amountField);
        sendKeys(amountField,amnt);
        logger.info("Entered amount");
        hideKeyBoard();
        return this;


    }

    public MpesaOther submit() throws InterruptedException {
        click(send);
        click(submitBtn);
        logger.info("Entered pin");
        return this;

    }

    public String getConfrimation(){
        logger.info("Getting status");
        return confSummary.getText();

    }

    public MpesaOther confirm(){
        waitForElement(confirmationPg);
        confirmationPg.isDisplayed();

        click(confirmationPg);
        logger.info("Completed");
        return this;
    }
}
