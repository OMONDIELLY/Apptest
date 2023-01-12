package kcb;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
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


}
