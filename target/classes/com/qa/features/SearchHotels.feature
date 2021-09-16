Feature: Search Hotels in MakeMyTrip

  @Searchhotel
  Scenario: Verify Hotels Page in MakemyTrip
    Given User Open Browser
    When Click on Randoms place
    And Click on Hotels Tab
    And Select Mumbai from drop down
    Then Verify the Hotels Page
    And Close the search hotels Browser