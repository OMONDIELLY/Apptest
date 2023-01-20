package kcb.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import kcb.BasePage;
import org.apache.log4j.Logger;

public class LoginPage extends BasePage {

    Logger logger = Logger.getLogger(LoginPage.class);
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

    @AndroidFindBy(id =" com.kcbbankgroup.android:id/img_home")
    public MobileElement home;



    @AndroidFindBy(id ="com.kcbbankgroup.android:id/txt_home")
    public MobileElement appHomeWidget;


         public LoginPage enterGetStarted(){
               waitForElement(getStarted);
               logger.info("Clicked get started");
               click(getStarted);
               return this;
           }

          public LoginPage enterPhoneNo(String phoneNo){
                waitForElement(phone);
                clear(phone);
                sendKeys(phone, phoneNo);
                logger.info("Entered phone No");
                return this;
            }

            public LoginPage clickProceedBtn(){
                click(proceedBtn);
                logger.info("Clicked proceed button");
                return this;
            }

            public LoginPage tapAllow(){
                waitForElement(notifications);
                notifications.click();
                return this;
            }

           public LoginPage pinCode(){
                sendPin();
                logger.info("Entered pin code");
                return this;
           }

           public String  home(){
               waitForElement(appHomeWidget);
               appHomeWidget.isDisplayed();
               logger.info("Loading home icon");
               return appHomeWidget.getText();
           }

    }




