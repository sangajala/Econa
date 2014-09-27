@sasi
Feature: Search for vendors from Home Page and Vouchers Page

  As a consumer
  I have to able to search for vendors
  so that I can view the deals and vouchers from a particular vendor


@11@done@13@14@not_done
  Scenario: Search for a vendor in Vouchers page using partial vendor name
      Given Consumer is in the Vouchers Page
       When Consumer enters '<search keyword>' as keyword
       Then autocomplete should match the with search criteria

    Examples:

    |search keyword|
    |Ama           |
    |Amazon        |

  @12
  Scenario Outline: Search for a vendor in Homepage through search page
    Given Consumer is in the HomePage
    When Consumer enters '<search keyword>' as keyword
    And select the search option
    Then the result page should be shown
    And the result should match the search criteria

  Examples:

    |search keyword|
    |Ama           |
    |Amazon        |



#   SASI TO DO TWO MORE



