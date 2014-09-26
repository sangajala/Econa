Feature: Search for vendors from Home Page and Vouchers Page

  As a consumer
  I have to able to search for vendors
  so that I can view the deals and vouchers from a particular vendor

  Scenario: Search for a vendor in Homepage using complete vendor name
      Given Consumer is in the HomePage
       When Consumer enters a complete vendor name "amazon" in the "HomePage" search box
       Then A drop-down menu with suggestions should be shown
        And Drop-down suggestions should match the searched vendor
#      When Consumer selects a vendor from the drop-down suggestion
       When Consumer clicks the search button
       Then New screen with search results for the vendor should be shown

  Scenario: Search for a vendor in HomePage using partial vendor name
      Given Consumer is in the HomePage
       When Consumer enters a part of vendor name "ama" in the "HomePage" search box
       Then A drop-down menu with suggestions should be shown
        And Drop-down suggestions should match the searched vendor
#       When Consumer selects a vendor from the drop-down suggestion
       When Consumer clicks the search button
       Then New screen with search results for the vendor should be shown


  Scenario: Search for a vendor in Vouchers page using complete vendor name
      Given Consumer is in the Vouchers Page
       When Consumer enters a complete vendor name "amazon" in the "voucherpage" search box
       Then A drop-down menu with suggestions should be shown
        And Drop-down suggestions should match the searched vendor
#       When Consumer selects a vendor from the drop-down suggestion
       When Consumer clicks the search button
       Then New screen with search results for the vendor should be shown

  Scenario: Search for a vendor in Vouchers page using partial vendor name
      Given Consumer is in the Vouchers Page
       When Consumer enters a part of vendor name "ama" in the "voucherpage" search box
       Then A drop-down menu with suggestions should be shown
        And Drop-down suggestions should match the searched vendor
#       When Consumer selects a vendor from the drop-down suggestion
       When Consumer clicks the search button
       Then New screen with search results for the vendor should be shown
