Feature: Search & Book a flight

  Scenario: Search a flight in MakemyTrip
    Given User Opens Browser
    When Click on Random place
    And Select From Mumbai
    And Select To Delhi
    And Select the date
    And Click on Search button
    And Click on Non Stop Checkbox
    And Click on Mumbai 6-12 button
    And Verify Search Flights
    And Click On View Price button
    And Click On Book Now button
    And Enter Customer Details
    Then Verify Fare Summery
    And Close the book flight Browser