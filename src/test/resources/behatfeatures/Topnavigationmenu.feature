
Feature: Top Navigation menus

  As a consumer
  I want to view the top navigation menu and the sub menu across all screens
  so that I can quickly navigate to the corresponding menu

@9NavigateTopmenus
  Scenario Outline:All top navigation menus are reachable
     Given Consumer is in the HomePage
      Then <NavigationMenu> Navigation menus should be shown on the top of the screen
      When Consumer clicks a Navigation  menu <NavigationMenu>
      Then The <ResultScreen> corresponding menu screen should be shown

  Examples:
     |NavigationMenu  | ResultScreen                                     |
     |"Startseite"    | "Aktuelle Schnäppchen Highlights"                |
     |"Schnäppchen"   | "Aktuelle Schnäppchen Highlights"                |
     |"Gutscheine"    | "Gutscheine und Gutscheincodes bei SPARWELT"     |
     |"Finanzen"      | "Ratgeber rund um das Thema Finanzen"            |
     |"Specials"      | "Vergleichbare Angebote"                         |

@09Flyoutsmouseover
  Scenario Outline: Flyout menus are shown for relevant top navigation menus on mouseover
     Given Consumer is in the HomePage
      When Consumer moves the mouse over a menu with flyout <MenuwithFlyout>
      Then <Flyoutmenu> Flyoutmenu should be shown on the screen
  Examples:
     |MenuwithFlyout      | Flyoutmenu                     |
     |"Gutscheine"        | "Gutschein-Shops von A-Z"      |
     |"Finanzen"          | "Girokonto"                    |

@10Flyoutsubmenus@home
  Scenario Outline: User can randomly navigate to elements from flyouts and check the landing page
     Given Consumer is in the HomePage
      When Consumer moves the mouse over a menu with flyout <MenuwithFlyout>
       And randomly selects a menu
      Then Screen should show details of selected submenu
      When Consumer moves the mouse over a menu with flyout <MenuwithFlyout>
       And randomly selects a different menu
      Then Screen should show details of selected submenu

  Examples:
    | MenuwithFlyout         |
    | "Gutscheine"           |
    | "Finanzen"             |
