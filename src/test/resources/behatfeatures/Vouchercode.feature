Feature: Select and copy a voucher code from a vendor
  As a Customer
  I should be able to select a voucher from a vendor and copy the voucher code
  In order to use the code while purchasing in vendor's website

  Background:
    Given Consumer is in the HomePage

  Scenario Outline: Select a voucher and copy a voucher code from a vendor
     When Consumer moves the mouse over "Gutscheine" menu
      And Selects a vendor <vendor> from Gutscheine menu
     Then Screen should show details of selected vendor in the screen
      And Vouchers from the selected vendor should be displayed
      And Voucher overlay should be shown
     When Consumer clicks a voucher
     Then Vendors shop should be shown in a new window
      And Voucher code should be shown inside a text box in a new window
     When Consumer clicks the copy icon in the screen
     Then A message saying "copied" should be shown inside the text box

  Examples:
    | vendor   |
    | "Amazon" |


