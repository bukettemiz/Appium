package Locators;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AndroidUiAutomator {

    @Test
    public void androidUiAuthomator() throws MalformedURLException {
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();

        desiredCapabilities.setPlatform(Platform.ANDROID);
        desiredCapabilities.setCapability(MobileCapabilityType.APP,
                new File("src/test/resources/ApiDemos-debug-newVersion.apk").getAbsolutePath());

        desiredCapabilities.setCapability(MobileCapabilityType.APP, "MyDevice2");
        desiredCapabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,300);

        URL appiumServer= new URL ("http://0.0.0.0:4723/wd/hub");
        AndroidDriver<AndroidElement> driver=new AndroidDriver<AndroidElement>(appiumServer, desiredCapabilities);
        AndroidElement appButton=driver.findElementByAndroidUIAutomator("text(\"App\")");
        appButton.click();
    }
}
