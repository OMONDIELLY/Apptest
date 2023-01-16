package kcb;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public AppiumDriver driver;
   public static final long WAIT = 10;

            public BasePage(AppiumDriver<MobileElement> driver) {
               this.driver = driver;
               PageFactory.initElements(new AppiumFieldDecorator(driver, Duration.ofSeconds(10)), this);
            }


            protected boolean waitForElement(MobileElement element) {
                WebDriverWait wait = new WebDriverWait(driver, WAIT);
               try {
                        wait.until(ExpectedConditions.visibilityOf(element));
                        return true;
                    } catch (Exception ex) {
                       ex.printStackTrace();
                       throw new RuntimeException(ex);

                    }
              }

            public void clear(MobileElement element){
                waitForElement(element);
                element.clear();
           }

           public void click(MobileElement element){
                waitForElement(element);
                element.click();

          }

            public void sendKeys(MobileElement element, String text){
               waitForElement(element);
               element.sendKeys(text);
           }

         public void hideKeyBoard() {
        driver.hideKeyboard();
        }

          @AndroidFindBy(id = "number_2_holder")
          public MobileElement send2;

          @AndroidFindBy(id = "number_2_holder")
          public MobileElement sendtwo;

           @AndroidFindBy(id = "number_1_holder")
           public MobileElement send1;

           @AndroidFindBy(id = "number_9_holder")
           public MobileElement send9;

           @AndroidFindBy(id = "go_holder")
           public MobileElement okay;

           @AndroidFindBy(id = "com.google.android.gms:id/positive_button")
           public MobileElement processing;

           public void sendPin(){
               click(send2);
               click(sendtwo);
               click(send1);
               click(send9);
               click(okay);
               click(processing);

                }
         public void sendCode(){
              click(send2);
              click(sendtwo);
              click(send1);
              click(send9);
              click(okay);

    }

}
