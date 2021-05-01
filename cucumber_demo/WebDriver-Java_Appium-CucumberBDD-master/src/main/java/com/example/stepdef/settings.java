package com.example.stepdef;

import com.example.pages.googlePage;
import com.example.pages.settingsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class settings {

    public static settingsPage spage;
    public settings(){
        spage = new settingsPage();
    }


    @Given("I launch the settings app of iphone")
    public void i_launch_the_settings_app_of_iphone() {

    }

    @Then("I should see the general label")
    public void i_should_see_the_general_label() {

    }

}
