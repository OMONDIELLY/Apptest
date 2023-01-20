package kcb.PageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import kcb.BasePage;
import org.apache.log4j.Logger;

public class HomePage extends BasePage {

    private static Logger logger = Logger.getLogger(HomePage.class);

   public HomePage(AppiumDriver<MobileElement> driver) {
               super(driver);
            }

       @AndroidFindBy(id = "com.kcbbankgroup.android:id/txt_customer_name")
       public MobileElement profile;

      @AndroidFindBy(id ="com.kcbbankgroup.android:id/profile_image")
      public MobileElement profileStore;


      @AndroidFindBy(id = "com.kcbbankgroup.android:id/name")
      public MobileElement name;

      @AndroidFindBy(id = "com.kcbbankgroup.android:id/phone_number")
      public MobileElement phone;

      @AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc=\"Navigate up\"]")
      public MobileElement back;

    public String VerifyProfile(){
        logger.info("Checking Home Page and name");
           return profile.getText();
       }

    public void clickPrf(){
        click(profileStore);
    }

      public String VerifyName(){
        logger.info("Checking Customer name");
        return name.getText();
      }

    public String VerifyNumber(){
        logger.info("Checking Customer phone no");
        return phone.getText();
    }
    public void clickBck(){
        click(back);
    }

}
