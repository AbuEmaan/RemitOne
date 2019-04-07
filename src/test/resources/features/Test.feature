@Test
Feature: Test

  Scenario Outline: Add a member beneficiary
    Given user is on the "arm" landing page
    When user enters "brownagent" and "Password2"
    Then the "Current rate to Bangladesh" page is displayed
    When user  the create a money "<tranferType>" by "<Remitter>" for  "<beneficiary>" for the "<amount>"

    Examples: 
      | tranferType      | Remitter | beneficiary | amount |
      | Cash Collection  | Maria    | Sadi        |     90 |
      | Account Transfer | Maria    | Sadi        |     90 |
