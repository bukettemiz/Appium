package topAction;

import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class TapAction {
    @Test
     public void taptests() throws MalformedURLException {


        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.DEVICE_NAME,"MyDevice2");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);
        desiredCapabilities.setCapability(MobileCapabilityType.APP, new File);
        URL appiumServerUrl= new URL ("http://0.0.0.0:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(appiumServerUrl,desiredCapabilities);
        AndroidElement contentButton=driver.findElement(By.xpath("//android.widget.TextView[@text='Conte']"));
        TouchAction action=new TouchAction<>(driver);
        action.tap(TapOptions.tapOptions().(ElementOption.element(contentButton))).perform();
        {



    }
}
