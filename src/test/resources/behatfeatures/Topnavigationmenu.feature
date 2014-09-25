Feature: Top Navigation menus

  As a consumer
  I want to view the top navigation menu and the sub menu across all screens
  so that I can quickly navigate to the corresponding menu

@Topnavimenus

  Scenario Outline:All top navigation menus are shown
     Given Consumer is in the HomePage
      Then <NavigationMenus> Navigation menus should be shown on the top of the screen

  Examples:
    |NavigationMenus |
    |"Startseite"    |
    |"Schnäppchen"   |
    |"Gutscheine"    |
    |"Finanzen"      |
    |"Specials"      |

@NavigateTopmenus

  Scenario Outline:All top navigation menus are reachable
     Given Consumer is in the HomePage
      When Consumers presses a Navigation  menu <NavigationMenu>
      Then The <ResultScreen> corresponding menu screen should be shown

  Examples:
      |NavigationMenu  | ResultScreen                                     |
      |"Startseite"    | "Aktuelle Schnäppchen Highlights"                |
      |"Schnäppchen"   | "Aktuelle Schnäppchen Highlights"                |
      |"Gutscheine"    | "Gutscheine und Gutscheincodes bei SPARWELT"     |
      |"Finanzen"      | "Ratgeber rund um das Thema Finanzen"            |
      |"Specials"      | "Vergleichbare Angebote"                         |

@Flyoutmenu

  Scenario Outline: Flyout menus are shown for relevant top navigation menus on mouseover
    Given  Consumer is in the HomePage
     When  Consumer moves the mouse over a menu with flyout <MenuwithFlyout>
     Then  <Flyoutmenu> Flyoutmenu should be shown on the screen

  Examples:
    |MenuwithFlyout      | Flyoutmenu                     |
    |"Gutscheine"        | "Top Shops mit Gutschein"      |
    |"Finanzen"          | "Finanzrechner"                |

@Gutscheineflyoutmenu

  Scenario Outline: Gutscheine flyout menus are navigable
     Given Consumer is in the HomePage
      When Consumer moves the mouse over "Gutscheine" menu
       And Clicks a Gutscheine flyout menu <Submenu>
      Then Submenu screen should be shown

  Examples:
    | Submenu                             |
    | "Gutscheinemenu-1"                  |
    | "Gutscheinemenu-2"                  |

@Finanzenflyoutmenu

  Scenario Outline: Finanzen flyout menus are navigable
     Given Consumer is in the HomePage
      When Consumer moves the mouse over "Finanzen" menu
       And Clicks a Finanzen flyout menu <Submenu>
      Then Submenu screen should be shown

  Examples:
    | Submenu                           |
    | "Finanzenmenu-1"                  |
    | "Finanzenmenu-2"                  |
