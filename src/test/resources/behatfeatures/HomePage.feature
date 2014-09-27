@home

Feature: Home page functionality
  As a consumer
  I want to check for current deals ,vouchers and coupons
  So I can get benefit of best suitable deal
  Background:
    Given consumer is in Home page

  Scenario:Consumer can view the current deal highlights in slider
    Then the slider automatically switches every three seconds

  Scenario : consumer navigates to the deal page from slider
    When consumer selects deal1 in current deals highlights
    Then page navigates to Schnäppchen page
    And the corresponding deal1 page appears
    When consumer selects Home page
    And consumer selects deal2 in current deals highlights
    Then page navigates to Schnäppchen page
    And the corresponding deal2 page appears
    When consumer selects Home page
    And consumer selects deal3 in current deals highlights
    Then page navigates to Schnäppchen page
    And the corresponding deal3 page appears


  Scenario Outline: Consumer can view listings in the home page
    Then listings must appear with headings <List>
  Examples:
    |List                     |
    |"Beliebteste Schnäppchen"|
    |"Beliebteste Gutscheine" |
    |"Aktuelle Schnäppchen"   |
    |"Top-Ten Gutscheine"     |

  Scenario: Listings must have elements
    Then Beliebteste Schnäppchen listing should have elements
    Then Beliebteste Gutscheine listing should have elements
    Then Aktuelle Schnäppchen listing should have elements
    Then Top-Ten Gutscheine listing should have elements

  Scenario : Consumer can view the deals present in listings
    When selects element form Beliebteste Schnäppchen listing
    Then corresponding Beliebteste Schnäppchen page appears
    When selects element form Beliebteste Gutscheine listing
    Then corresponding Beliebteste Gutscheine page appears
    When selects element form Aktuelle Schnäppchen listing
    Then corresponding Aktuelle Schnäppchen page appears
    When select all elements one after one form Top-Ten Gutscheine listing
    Then corresponding pages appear

  Scenario Outline: Consumer can view static links
    When consumer selects the link <Link>
    Then corresponding <Link> page appears
  Examples:
    | Link         |
    |"Impressum"   |
    |"Datenschutz" |
    |"Hilfe"       |
    |"Presse"      |

