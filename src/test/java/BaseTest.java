import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    public static AppiumDriver driver;

    public static void AndroidSetup() throws MalformedURLException{
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("platformName", "Android");
        caps.setCapability("deviceName","RZ8T311NK4Z");
        caps.setCapability("autoAcceptAlerts", true);
        caps.setCapability("app",  "C:\\apkfiles\\kcb_uat10_11 (1).apk");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
    }



    public void tearDown(){
        if(null!=driver){
            driver.quit();
        }

    }

}
