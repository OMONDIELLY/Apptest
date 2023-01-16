package kcb.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import kcb.BasePage;

public class LoginPage extends BasePage {
    public LoginPage(AppiumDriver<MobileElement> driver) {
                super(driver);
            }


    @AndroidFindBy(id="com.kcbbankgroup.android:id/link_skip")
   public MobileElement getStarted;

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/phone_number")
    public MobileElement phone;

    @AndroidFindBy(id = "com.kcbbankgroup.android:id/link_activate")
      public MobileElement proceedBtn;

      @AndroidFindBy(id = "com.android.permissioncontroller:id/permission_allow_button")
     public MobileElement notifications;

         public LoginPage enterUserName(){
               waitForElement(getStarted);
                click(getStarted);
               return this;
           }

          public LoginPage enterPhoneNo(String phoneNo){
                waitForElement(phone);
                clear(phone);
                sendKeys(phone, phoneNo);
                return this;
            }

            public LoginPage clickProceedBtn(){
                click(proceedBtn);
                return this;
            }

            public LoginPage tapAllow(){
                waitForElement(notifications);
                notifications.click();
                return this;
            }

           public LoginPage pinCode(){
                sendPin();
                return this;
           }

        }



