package com.example.stepdef;

import com.example.pages.googlePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import java.net.MalformedURLException;

public class google {

    public static googlePage gpage;
    public google(){
        gpage = new googlePage();
    }

    @Given("I launch the google")
    public static void i_launch_the_google() throws InterruptedException, MalformedURLException {
        gpage.launchGoogle();
    }

    @Then("I verify the title to be Google")
    public static void i_verify_the_title_to_be_Google() {
        gpage.verifyTitle(gpage.expectedTitle);
    }



}
