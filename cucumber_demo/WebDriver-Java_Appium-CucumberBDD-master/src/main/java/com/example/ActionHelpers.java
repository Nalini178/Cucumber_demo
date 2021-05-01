package com.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.google.common.collect.ImmutableMap;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.stream.Stream;

public class ActionHelpers {

    public static String[] iPhoneList={"iPhone 12","iPhone 12 mini","iPhone 12 Pro","iPhone 12 Pro Max"};
    public static ChromeOptions chromeOptions;
    public static AndroidDriver browser;
    public static String uuid;

    public static void launchBrowserUrl(String os, String urlToLaunch) throws MalformedURLException {
        DesiredCapabilities dCap = new DesiredCapabilities();
        if(os.equalsIgnoreCase("ios")){
            //getSimulatorUDID();
            dCap.setCapability("browserName", "Safari");
            dCap.setCapability("platformName", "iOS");
            dCap.setCapability("automationName", "XCUITest");
            dCap.setCapability("safariIgnoreFraudWarning", false);
            dCap.setCapability("deviceName", "iPhone 12 Pro Max");
            dCap.setCapability("udid", uuid);
           // browser = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), dCap);
        }else if(os.equalsIgnoreCase("android")){
     
            dCap.setCapability("deviceName", "emulator-5554");
        	dCap.setCapability("platformName", "Android");
        	dCap.setCapability("appium:chromeOptions", ImmutableMap.of("w3c", false));
        	dCap.setCapability(CapabilityType.BROWSER_NAME, "Chrome"); 
        	dCap.setCapability(CapabilityType.VERSION, "11");
        	dCap.setCapability("chromedriverExecutable", System. getProperty("user.dir")+"//chromedriver.exe");
        	browser = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), dCap);
            browser.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }else if(os.equalsIgnoreCase("windows") || os.equalsIgnoreCase("mac")){
            chromeOptions = new ChromeOptions();
            WebDriverManager.chromedriver().setup();
          //  browser = new ChromeDriver(chromeOptions);
        }
        browser.get(urlToLaunch);
    }

    private static void getSimulatorUDID(){
        try {
            Random rand = new Random();
            int randomIndex = rand.nextInt(iPhoneList.length);
            String phoneName=iPhoneList[randomIndex];
            Process processUDID = Runtime.getRuntime().exec("xcrun simctl list devices");
            BufferedReader in = new BufferedReader(new InputStreamReader( processUDID.getInputStream()));
            Stream<String> stream = in.lines();
            stream.forEach(s -> {
                        if (s.contains(phoneName) && (!s.contains("unavailable")))
                        {
                            String deviceUdid;
                            String ud = deviceUdid = s.substring(s.indexOf("-") - 8) .trim();
                            uuid = deviceUdid = ud.substring(0, ud.indexOf(")")).trim();
                        }
                    }
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String  getTitle() {
        return browser.getTitle();
    }

    public void pause(int i) throws InterruptedException {
        Thread.sleep(i*1000);
    }

    public static void launchApp() throws MalformedURLException {

    }

    public static void switchToNativeContext() {

    }

}
