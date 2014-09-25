@home
Feature: Home page functionality

  As a consumer
  I want to check for current deals highlights
  So I can get benefit of the latest deals
  Background: Given user is in 'Home' page

  Scenario: consumer can view the current deals highlights
    Given consumer is in 'Home' page
    //When consumer checks for 'current deals highlights'
    // the deals appears in slider
    Then the slider automatically switches every three seconds


  // Scenario: consumer can view particular deal in current deals highlights
  //  Given consumer is in 'Home' page
  //  When consumer moves cursor over the slider element
  //  Then the slider stops
  //  And the deal present in that slider element is highlighted
    //

  Scenario Outline: consumer navigates to the deal page
    Given consumer is in 'Home' page
    When consumer select <Deal> in current deals highlights
    Then page navigates to Bargain page
    And the corresponding deal <Deal> page appears


  Examples:
    |Deal  |
    |Deal1 |
    |Deal2 |
    |Deal3 |
