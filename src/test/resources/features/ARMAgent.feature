@FullRegression @ARMAgent
Feature: ARM Agent

  Scenario: Add Teller Agent
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds a teller agent "Isco" and "Garcia" and "abayomi.alonge@remitone.com" and "iscoteller" and "Password1"

  Scenario: Add a remitter
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds a remitter
      | Maria | Miguel | Female | 18/03/1978 | 45 Best town | 3421 | United Kingdom |  | 7762866412 | abayomi.alonge@remitone.com | Address21111 | Driving License | 1351515 | 10/10/2025 | Brown Bobby | uplaodImage.png | United Kingdom | admin |
