Feature:Gadget snow
  As a user I want to compare two computer.

  Scenario Outline:compare two computer
    Given user is on the page Gadget snow
    When User selects two pc to compare "<product1>" and "<product2>"
    Then User is redirected to the result page
    And User extracts all the information to the Excel file



  Examples:

    | product1     | product2        |
    | Lenovo B40-80 | Lenovo E41-80    |





