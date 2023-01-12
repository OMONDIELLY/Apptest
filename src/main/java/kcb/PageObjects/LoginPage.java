package kcb.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import kcb.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver<MobileElement> driver) {
        super(driver);
    }

    @AndroidFindBy(id ="io.testproject.demo:id/name")
    public MobileElement userName;


    @AndroidFindBy(id = "io.testproject.demo:id/password")
    public MobileElement password;


    @AndroidFindBy(id = "io.testproject.demo:id/login")
    public MobileElement loginBtn;


    public void enterUserName(String name){
        waitForElement(userName);
        clear(userName);
        sendKeys(userName, name);
    }

    public void enterPassword(String pass){
        waitForElement(password);
        clear(password);
        sendKeys(password, pass);
    }

    public void clickBtn(){
        click(loginBtn);
    }
}
