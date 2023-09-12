package appiumIntro;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ServerConnection {
    @Test
    public void connectServer() throws MalformedURLException, InterruptedException {
        File apkFile = new File("src/test/resources/ApiDemos-debug-newVersion.apk");
        DesiredCapabilities desiredCapabilities=new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName","Android");
        desiredCapabilities.setCapability("deviceName", "MyDevice2");
        desiredCapabilities.setCapability("app",apkFile.getAbsolutePath());
        URL appiumServerUrl= new URL ("http://0.0.0.0:4723/wd/hub");
        AndroidDriver<AndroidElement> driver = new AndroidDriver<>(appiumServerUrl,desiredCapabilities);
        AndroidElement appButton=driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']"));
        appButton.click();
        //TO DO: ClickAPP -> Alarm
        // -> Alarm Controller-> validate first button "one shot Alarm"
        Thread.sleep(1000);
       AndroidElement alarmButton=driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Alarm']"));
       alarmButton.click();

       AndroidElement alarmController=driver.findElement(By.id("android:id/text1"));
        Thread.sleep(1000);
        alarmController=driver.findElement(By.id("android:id/text1"));
       alarmController.click();

       //AndroidElement firstButton= driver.findElement(By.xpath("//*[@resource-id='io.appium.android.apis:id/one_shot']"));
       // Assert.assertEquals("One Shot Alarm",firstButton.getText());
        List<AndroidElement> listOfButtons=driver.findElements(By.className("android.widget.Button"));
        AndroidElement firstButton2=listOfButtons.get(0);
        Assert.assertEquals("ONE SHOT ALARM",firstButton2.getText());

        //i did this
        System.out.println("buki");


    }
}
