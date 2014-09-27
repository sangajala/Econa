@home

Feature: Home page functionality
  As a consumer
  I want to check for current deals ,vouchers and coupons
  So I can get benefit of best suitable deal
  Background:
    Given consumer is in Home page

    @sridevi@notdone@1
  Scenario:Consumer can view the current deal highlights in slider
    Then the slider automatically switches every three seconds

  @sridevi@done@3@4
  Scenario: Consumer navigates to the deal page from slider
    When consumer selects '<Deal_number>' in current deals highlights
    Then page navigates to '<Page header>' page
    And the corresponding details of the deal appears
    When consumer navigates Home page

    Example:
    |Deal_number|Page header|
    |1|Schnäppchen|
    |2|Schnäppchen|
    |3|Schnäppchen|

  @sridevi@notdone@5
  Scenario Outline: Consumer can view listings in the home page

    Then listings must appear with headings <List>
  Examples:
    |List                     |
    |"Beliebteste Schnäppchen"|
    |"Beliebteste Gutscheine" |
    |"Aktuelle Schnäppchen"   |
    |"Top-Ten Gutscheine"     |

  @sridevi@notdone@6
  Scenario: Listings must have elements
    Then Beliebteste Schnäppchen listing should have elements
    Then Beliebteste Gutscheine listing should have elements
    Then Aktuelle Schnäppchen listing should have elements
    Then Top-Ten Gutscheine listing should have elements

  @sridevi@notdone@7
  Scenario : Consumer can view the deals present in listings
    When selects element form Beliebteste Schnäppchen listing
    Then corresponding Beliebteste Schnäppchen page appears
    When selects element form Beliebteste Gutscheine listing
    Then corresponding Beliebteste Gutscheine page appears
    When selects element form Aktuelle Schnäppchen listing
    Then corresponding Aktuelle Schnäppchen page appears
    When select all elements one after one form Top-Ten Gutscheine listing
    Then corresponding pages appear

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

