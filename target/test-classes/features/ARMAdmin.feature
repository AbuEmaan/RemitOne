@FullRegression @ARMAdmin
Feature: ARM Admin

  Scenario: Admin Valid login
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed

  Scenario: Admin Preferences - Change Password
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed
    When the User clicks the "Preferences" link
    Then the "Preferences" page is displayed
    When user changes password by entering the old password "remitone" and the new password "Remitone1" and confirmed new password "Remitone1" and clicks continue
    Then the "RemitOne Transfer" page is displayed

  Scenario: Add Source Country
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user adds the source country as "Tunisia : TN" and currency as "EUR" and WalletEnabled is set to "No"

  Scenario: Add Destination Country
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user adds the destination country as "Zimbabwe"

  Scenario: Add Source Conversion Rates
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user adds source destination rates for euro "1.19681" and usd "1.66397"

  Scenario: Add Destination Conversion Rates
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user adds  destination rates "129.119" and "1.19681" and "1.66397"

  Scenario Outline: Add Delivery Bank
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds a deliver bank "<name>" and "<code>" and "<address>" and "<city>" and "<state>"

    Examples: 
      | name          | code | address    | city  | state |
      | Janata Bank   |  001 | Bangladesh | Dhaka | Dhaka |
      | National Bank |  002 | Bangladesh | Dhaka | Dhaka |

   Scenario Outline: Add Collection Point
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds a collection point "<name>" and "<bank>" and "<code>" and "<address>" and "<city>" and "<state>"

    Examples: 
      | name         | bank          | code | address    | city       | state |
      | Pubali Bank  | Janata Bank   |  001 | Bangladesh | MYMENSINGH | Dhaka |
      | Eastern Bank | National Bank |  002 | Bangladesh | Dhaka      | Dhaka |

  
  Scenario Outline: Add Processing Bank
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds a processing  bank "<firstName>" and "<LastName>" and "<username>" and "<password>" and "<fullBankName>" and "<bankName>" and "<bankCode>" and "<bankAddress>" and "<town>" and "<bankCountry>" and "<email>" and "<bankSuperID>"

    Examples: 
      | firstName  | LastName | username           | password  | fullBankName    | bankName | bankCode | bankAddress      | town  | bankCountry | email                       | bankSuperID         |
      | City       | bank     | citybankBangladesh | Password1 | City Bank       | CB       |      001 | 45 closed city   | Dhaka | Bangladesh  | abayomi.alonge@remitone.com | Overview Super Bank |
      | Commercial | bank     | commercialbank     | Password1 | Commercial Bank | COMB     |      002 | 45 Charlton Road | Dhaka | Bangladesh  | abayomi.alonge@remitone.com |                     |

  Scenario: Add an  Agent
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds an agent
      | Boss Express | Brown | Bobby | brownagent | Password1 | United Kingdom | 45 Best town | London | Address21111 | 28000 | abayomi.alonge@remitone.com | 35256236262 | 42 | Yomi | Yomi | Yomi |



  Scenario: Logout
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Current rate to Bangladesh" page is displayed
    Then user clicks the logout link
