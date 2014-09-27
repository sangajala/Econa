Feature: Select and copy a voucher code from a vendor
  As a Customer
  I should be able to select a voucher from a vendor and copy the voucher code
  In order to use the code while purchasing in vendor's website

  Background:
    Given Consumer is in the HomePage
@sasi@21
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


  @22@23@ram
    Scenario Outline: User selects the voucher and opens the title from image

      Given user selected a random vendor with name 'Amazon' from 'Gutscheine' menu
      When selects the '<User_selected_option>' of voucher with title '20%-Gutschein für Sport- und Outdoor-Bekleidung bei Amazon'
      Then new page is opened
      And voucher popup is shown with the title '20%-Gutschein für Sport- und Outdoor-Bekleidung bei Amazon'
      And the voucher code is shown with text 'winter20'
      When user copies the voucher code by clicking sissior icon
      Then the voucher code should be saved in clipboard

      Examples:

      |User_selected_option|
      |Title               |
      |Image               |
      |voucher button     |

    @26@27
      Scenario Outline: User a valid user perform news letter enrollment

        Given user is in homepage
        When enters for newsletter enrollment with email as '<email>'
        Then message should display with text '<message>'

        Examples:
        |email|message|
        |     |Please fill out this field.|
        |test |Please include and '@' in the email address. 'test' is missing an '@'
        |test@||
        |test@2||
        |test@test.com|Success|

      @25@28

        Scenario Outline: Goggle robot can read files in my domian

        Then google robot can access the file with url '<url>'
        Examples:
        |url|
        |sitemap.xml|
        |robots.txt  |


