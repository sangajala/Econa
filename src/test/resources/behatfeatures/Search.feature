@sasi
Feature: Search for vendors from Home Page and Vouchers Page

  As a consumer
  I have to able to search for vendors
  so that I can view the deals and vouchers from a particular vendor

@11HomePageSearch
  Scenario Outline: Search for a vendor in HomePage using vendor name
     Given Consumer is in the HomePage
      When Consumer enters <search keyword> as keyword
      Then autocomplete should match with search criteria

  Examples:
     |search keyword  |
     |"Ama"           |
     |"Amazon"        |

@12HomePagesearchresult
  Scenario Outline: Search for a vendor in Homepage through search option
     Given Consumer is in the HomePage
      When Consumer enters <search keyword> as keyword
       And select the search option
      Then the result page matching the search criteria should be shown
  Examples:
     |search keyword  |
     |"Ama"           |
     |"Amazon"        |

@13VouchersPageSearch
  Scenario Outline: Search for a vendor in Vouchers Page using vendor name
     Given Consumer is in the Vouchers Page
      When Consumer enters <search keyword> as keyword
      Then autocomplete should match with search criteria

  Examples:
     |search keyword  |
     |"Ama"           |
     |"Amazon"        |

@14Voucherspagesearchresult
  Scenario Outline: Search for a vendor in Vouchers page through search option
     Given Consumer is in the Vouchers Page
      When Consumer enters <search keyword> as keyword
       And select the search option
      Then the result page matching the search criteria should be shown
  Examples:
     |search keyword|
     |"Ama"           |
     |"Amazon"        |

