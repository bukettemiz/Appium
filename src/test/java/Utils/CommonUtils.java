package Utils;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class CommonUtils {
    public static AndroidDriver getDriver() throws MalformedURLException {
        try{
            URL appiumServer = new URL("http://0.0.0.0:4723/wd/hub");
            DesiredCapabilities desiredCapabilities=getCaps("MyDevice2",
                    new File("src/test/resources/ApiDemos-debug-newVersion.apk").getAbsolutePath());
            AndroidDriver < AndroidElement> driver=new AndroidDriver<AndroidElement>(appiumServer,desiredCapabilities);
            return driver;
        }catch(Exception ex){
            throw new RuntimeException("Something went wrong ");
        }

    }
    public static DesiredCapabilities getCaps(String deviceName, String app){

        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,deviceName);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,app);
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);
        return desiredCapabilities;
    }
    public static void elementTap(AndroidDriver driver, AndroidElement element){
        TouchAction action =new TouchAction<>(driver);
        action.tap(TapOptions.tapOptions().withElement(ElementOption.element(element))).perform();
    }
    public static void longPress(AndroidDriver driver,AndroidElement element, int duration){
        TouchAction touchAction=new TouchAction<>(driver);
        touchAction.longPress(LongPressOptions.longPressOptions()
                .withElement(ElementOption.element(element))
                .withDuration(Duration.ofSeconds(duration))).perform();
    }

}
