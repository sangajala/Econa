
    Feature: User is able to use all the different Vendors

    As a User
    I want to select the vendors
    So that i can see the available vouchers

  @15
  Scenario Outline: User is able to view vendors page

    Given User is on the HomePage
    When  User mouse over the '<Link>' menu dropdown
    When  User selects '<Shop>'
    When  User selects a '<Vendor>'
    Then  User should navigate to Vendors page with its '<HeaderName>'  logo

  Examples:
    |Link       |Shop                     | Vendor   | HeaderName       |
    |"Gutschein"|"Gutschein-Shops von A-Z"| "Title"  | "Name Gutschein" |

  @16
  Scenario Outline: User is able to redeem the voucher from a vendor

    Given User is on the HomePage
    When  User mouse over the '<Link>' menu dropdown
    When  User selects '<Shop>'
    When  User selects a '<Vendor>'
    When  User selects a '<Voucher>'
    Then  User is able to recieve a '<Code>'on the voucher page
    Then  User should be navigated to third-party Vendor page in a new window

  Examples:
    |Link       |Shop                     | Vendor   | Voucher             | Code     |
    |"Gutschein"|"Gutschein-Shops von A-Z"| "Title"  |"Gutschein anzeigen" |"WINTER20"|

  @17
  Scenario Outline: User is able to redeem the voucher from a vendor

    Given User is on the HomePage
    When  User mouse over the '<Link>' menu dropdown
    When  User selects '<Shop>'
    When  User selects a '<Vendor>'
    When  User selects a '<Voucher>'
    When  User selects Zum shop
    Then  User should be navigated to third-party Vendor page in a new window
    Then  User should see Sparwelt sidebar on the right hand side

  Examples:
    |Link       |Shop                     | Vendor   | Voucher             | Code     |
    |"Gutschein"|"Gutschein-Shops von A-Z"| "Title"  |"Gutschein anzeigen" |"WINTER20"|


@19
  Scenario Outline: User is able to search an item in a responsive window

    Given User is on the Responsive HomePage
    When  User selects the search button
    When  User Sendkeys '<Name>'
    Then  User should be Navigated to the appropriate search pages

  Examples:
    | Name |
    |"xbox"|
