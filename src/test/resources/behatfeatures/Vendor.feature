@rohit
Feature: User is able to use all the different Vendors

  As a User
  I want to select the vendors
  So that i can see the available vouchers

  @15
  Scenario Outline: User is able to view vendors page

    Given User is on the HomePage
    When  User selects the Gutschein menu dropdown
    When  User clicks Gutschein-Shops von A-Z
    When  User selects a <Vendor>
    Then  User should navigate to Vendors page with its <HeaderName>  logo

  Examples:
    | Vendor | HeaderName     |
    | Title  | Name Gutschein |

@16
  Scenario Outline: User is able to redeem the voucher from a vendor

    Given User is on the HomePage
    When  User selects the Gutschein menu dropdown
    When  User clicks Gutschein-Shops von A-Z
    When  User selects a <Vendor>
    When  User selects a <Voucher>
    Then  User is able to recieve a <Code> or <no coupon code required> on the voucher page
    Then  User should be navigated to third-party Vendor page in a new window

  Examples:
    | Vendor                | Voucher     | Code       |
    |  Amazon                |Gutschein anzeigen    |  WINTER20|
    |DATA FOR VENDON WHO DONT HAVE CODE |DATA FOR VOUCHER WITH NO CODE|kein Gutschein notwendig|

    @rohit@17
  Scenario Outline: User is able to redeem the voucher from a vendor

    Given User is on the HomePage
    When  User selects the Gutschein menu dropdown
    When  User clicks Gutschein-Shops von A-Z
    When  User selects a <Vendor>
    When  User selects a <Voucher>
    When  User selects Zum shop
    Then  User should be navigated to third-party Vendor page in a new window
    Then  User should see Sparwelt sidebar on the right h side

  Examples:
    | Vendor                | Voucher     |
    |  Amazon                |Gutschein anzeigen    |
    |DATA FOR VENDON WHO DONT HAVE CODE |DATA FOR VOUCHER WITH NO CODE|


    @rohit@19
  Scenario: User is able to search an item in a responsive window

    Given User is on the Responsive HomePage
    When  User clicks the search button
    When  User types a product "Name"
    Then  User should be Navigated to the appropriate search pages