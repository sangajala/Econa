Feature: Top Navigation menu

  As a consumer
  I want to view the top navigation menu and the sub menu across all screens
  so that I can quickly go to the corresponding menu

@Topnavigationmenu
  Scenario Outline:All top navigation menu are shown
     Given Consumer is in the HomePage
      Then <NavigationMenu> Navigation menu should be shown in the top of the screen

  Examples:
    |NavigationMenu  |
    |"Startseite"    |
    |"Schnäppchen"   |
    |"Gutscheine"    |
    |"Finanzen"      |
    |"Specials"      |

  Scenario Outline:All top navigation menu are reachable
     Given Consumer is in the HomePage
      When consumers presses a Navigation  menu <NavigationMenu>
      Then The <ResultScreen> corresponding menu should be shown
  Examples:
      |NavigationMenu  | ResultScreen                                     |
      |"Startseite"    | "Aktuelle Schnäppchen Highlights"                |
      |"Schnäppchen"   | "Aktuelle Schnäppchen Highlights"                |
      |"Gutscheine"    | "Gutscheine und Gutscheincodes bei SPARWELT"     |
      |"Finanzen"      | "Ratgeber rund um das Thema Finanzen"            |
      |"Specials"      | "Vergleichbare Angebote"                         |

