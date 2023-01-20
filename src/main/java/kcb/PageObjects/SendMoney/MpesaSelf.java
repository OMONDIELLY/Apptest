package kcb.PageObjects.SendMoney;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import kcb.BasePage;
import kcb.PageObjects.LoginPage;
import org.apache.log4j.Logger;

public class MpesaSelf extends BasePage {

    Logger logger = Logger.getLogger(MpesaSelf.class);

    public MpesaSelf(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id = "id_send_mpesa")
    public MobileElement sendMny;


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

    public MpesaSelf sendMoney() throws InterruptedException {
        waitForElement(sendMny);
        click(sendMny);
        logger.info("Clicked send money option");
        return this;

    }


    public MpesaSelf inputAmount(String amnt) throws InterruptedException {
        waitForElement(amountField);
        click(amountField);
        sendKeys(amountField,amnt);
        logger.info("Entered amount");
        hideKeyBoard();
        return this;


    }

    public MpesaSelf submit() throws InterruptedException {
        click(send);
        click(submitBtn);
        logger.info("Clicked submit ");
        sendCode();
        logger.info("Clicked pin code");
        return this;

    }

    public String getConfrimation(){
        logger.info("Getting status");
        return confSummary.getText();

    }

    public MpesaSelf confirm(){
        waitForElement(confirmationPg);
        confirmationPg.isDisplayed();
        click(confirmationPg);
        logger.info("Completed");
        return this;
    }

}
