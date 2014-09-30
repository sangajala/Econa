@home

Feature: Current deals highlights
  As a consumer
  I want to check for current deals hlighlights
  So I can choose the latest deal
  Background:
    Given Consumer is in the HomePage

 @sridevi@done@1
    Scenario:Consumer can view the current deal highlights in slider
      Then image appears in current deal highlights
      And the image changes after every three seconds

 @sridevi@done@3@4
  Scenario: Consumer navigates to the deal page from slider

    When consumer selects random deal in current deals highlights
    Then page navigates to "gutscheine" page
    And the corresponding details of the deal appears
    When consumer selects another random deal in current deals highlights
    Then page navigates to "gutscheine" page
    And the corresponding details of the deal appears


Feature: Check for listings and its elements
   As a consumer
   I want to check for listings and its elements
   So I can get benefit of best suitable deals

  @sridevi@done@5@6
  Scenario: In the home page consumer can view "Beliebteste Schnäppchen" listing and also can view the deatils of the deals present in the listing

    Then "Beliebteste Schnäppchen" listings must appear
    And the Beliebteste Schnäppchen listing should have atleast one element
    When consumer select one element from Beliebteste Schnäppchen
    Then the corresponding details of the element appears

  Scenario:In the home page consumer can view "Beliebteste Gutscheine" listing and also can view the deatils of the deals present in the listing

    Then "Beliebteste Gutscheine" listings must appear
    And the Beliebteste Gutscheine listing should have atleast one element
    When consumer select one element from Beliebteste Gutscheine
    Then the corresponding details of the element appears

  Scenario:In the home page consumer can view "Aktuelle Schnäppchen" listing and also can view the deatils of the deals present in the listing

    Then "Aktuelle Schnäppchen" listings must appear
    And the Aktuelle Schnäppchen listing should have atleast one element
    When consumer select one element from Aktuelle Schnäppchen
    Then the corresponding details of the element appears


 @sridevi@done@5@7
 Scenario:In the home page consumer can view "Top-Ten Gutscheine" listing and also can view details of all the deals present in the listing
   Then "Top-Ten Gutscheine" listings must appear
   And the Top-Ten Gutscheine listing should have atleast one element
   When select all elements one after one from 'Top-Ten Gutscheine' listing
    Then corresponding pages appear

 Feature: Check for static links
   As a consumer
   I want to check static links
   So I can get some additional details

  @sridevi@done@8
  Scenario Outline: Consumer can view static links
    When consumer selects the link <Link>
    Then corresponding <Link> page appears
  Examples:
    | Link         |
    |"Impressum"   |
    |"Datenschutz" |
    |"Hilfe"       |
    |"Presse"      |

