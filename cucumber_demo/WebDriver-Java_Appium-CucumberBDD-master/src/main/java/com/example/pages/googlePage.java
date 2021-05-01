package com.example.pages;

import com.example.ActionHelpers;
import org.testng.Assert;

import java.net.MalformedURLException;

public class googlePage {

    public static ActionHelpers actionHelper;
    public static String googleUrl = "https://www.google.com";
    public static String expectedTitle = "Google";

    public googlePage(){
        actionHelper = new ActionHelpers();
    }

    public static void launchGoogle() throws InterruptedException, MalformedURLException {
        String os = "android";
        actionHelper.launchBrowserUrl(os, googleUrl);
        actionHelper.pause(2);
    }

    public static void verifyTitle(String expectedTitle) {
        Assert.assertEquals( actionHelper.getTitle(), expectedTitle, "Actual Url and Expected Url both are not equal");
        actionHelper.browser.quit();
    }
}
