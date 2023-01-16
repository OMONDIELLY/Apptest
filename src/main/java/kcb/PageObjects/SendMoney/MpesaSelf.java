package kcb.PageObjects.SendMoney;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import kcb.BasePage;
import kcb.PageObjects.LoginPage;

public class MpesaSelf extends BasePage {

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
        System.out.println("Clicked send money");
        return this;

    }


    public MpesaSelf inputAmount(String amnt) throws InterruptedException {
        waitForElement(amountField);
        click(amountField);
        sendKeys(amountField,amnt);
        hideKeyBoard();
        System.out.println("Entered amount");
        return this;


    }

    public MpesaSelf submit() throws InterruptedException {
        //LoginPage loginPage = new LoginPage(driver);
        click(send);
        click(submitBtn);
        sendCode();
        System.out.println("Entered pin");
        return this;

    }

    public String getConfrimation(){
        System.out.println("Getting status");
        return confSummary.getText();

    }

    public MpesaSelf confirm(){
        waitForElement(confirmationPg);
        confirmationPg.isDisplayed();
        click(confirmationPg);
        System.out.println("completed");
        return this;
    }

}
