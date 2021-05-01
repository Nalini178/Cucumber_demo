Feature: Sample feature file to illustrate app and browser tests

  @androidBrowser @iosBrowser @smoke
  Scenario: Launch the google url in browser
    Given I launch the google
    Then I verify the title to be Google

    #  @iosApp @smoke
#  Scenario: Launch Settings app of an iphone
#    Given I launch the settings app of iphone
#    Then I should see the general label