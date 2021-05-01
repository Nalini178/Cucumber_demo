package com.example.pages;

import com.example.ActionHelpers;
import org.testng.Assert;

import java.net.MalformedURLException;

public class settingsPage {

    public static ActionHelpers actionHelper;

    public settingsPage(){
        actionHelper = new ActionHelpers();
    }

    public static void  launchApp() throws InterruptedException, MalformedURLException {
        actionHelper.launchApp();
        actionHelper.switchToNativeContext();
        actionHelper.pause(2);
    }

    public static void verifyGeneralLabel() {
        //actionHelper.getText(this.getObjectLocator().general).should.equal('General');
    }
}
