package kcb.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import kcb.BasePage;
public class SignUpPage extends BasePage {

    public SignUpPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }
    @AndroidFindBy(id = "io.testproject.demo:id/country")
    public MobileElement enterCountry;

    @AndroidFindBy(id = "io.testproject.demo:id/address")
    public MobileElement enterAddress;

    @AndroidFindBy(id = "io.testproject.demo:id/email")
    public MobileElement enterEmail;

    @AndroidFindBy(id = "io.testproject.demo:id/phone")
    public MobileElement enterPhoneNo;

    @AndroidFindBy(id = "io.testproject.demo:id/save")
    public MobileElement save;

    public void clickEnterCountry(String countryName){
        waitForElement(enterCountry);
        clear(enterCountry);
        sendKeys(enterCountry, countryName);
    }


    public void clickEnterAddress(String address){
        waitForElement(enterAddress);
        clear(enterAddress);
        sendKeys(enterAddress, address);
    }


    public void clickEnterEmail(String email){
        waitForElement(enterEmail);
        clear(enterEmail);
        sendKeys(enterEmail, email);
    }

    public void clickEnterPhone(String phoneNo){
        waitForElement(enterPhoneNo);
        clear(enterPhoneNo);
        sendKeys(enterPhoneNo, phoneNo);
    }

    public void saveDetails(){
        waitForElement(save);
        click(save);
    }

}
