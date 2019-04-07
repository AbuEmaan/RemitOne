@FullRegression @ARMAdmin
Feature: ARM Admin

  Scenario: First Admin Valid login and Password Change
    Given user is on the "arm" landing page
    When user enters "admin" and "remitone"
    Then the "Preferences" page is displayed
    When user changes password by entering the old password "remitone" and the new password "Password2" and confirmed new password "Password1" and clicks continue
    Then the user is displayed with the following message "User Profile updated successfully"

  Scenario: Admin Preferences - Change Password
    Given user is on the "arm" landing page
    When user enters "admin" and "Password2"
    Then the "Current rate to Bangladesh" page is displayed
    When the User clicks the "Preferences" link
    Then the "Preferences" page is displayed
    When user changes password by entering the old password "Password2" and the new password "Password1" and confirmed new password "Password1" and clicks continue
    Then the "RemitOne Transfer" page is displayed

  Scenario: Add Source Country
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user adds the source country as "Spain : ES" and currency as "EUR" and WalletEnabled is set to "No"

  Scenario: Add Destination Country
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user adds the destination country as "Zimbabwe"

  Scenario: Add Additional Currency to Destination Country
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user adds additional currency "Italy" for the  country "Zimbabwe"

  Scenario: Add Source Conversion Rates
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user adds source destination rates for euro "1.19681" and usd "1.66397"

  Scenario: Add Destination Conversion Rates
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user adds  destination rates "129.119" and "1.19681" and "1.66397"

  Scenario Outline: Add Delivery Bank
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds a deliver bank "<name>" and "<code>" and "<address>" and "<city>" and "<state>"

    Examples: 
      | name          | code | address    | city  | state |
      | Janata Bank   |  001 | Bangladesh | Dhaka | Dhaka |
      | National Bank |  002 | Bangladesh | Dhaka | Dhaka |

  Scenario Outline: Add Delivery Bank Branch
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds a deliver bank branch  "<name>" and "<code>" and "<deliveryBank>" and "<city>" and "<state>"

    Examples: 
      | name         | code | deliveryBank  | city  | state |
      | One Bank     |  001 | Janata Bank   | Dhaka | Dhaka |
      | Premier Bank |  002 | National Bank | Dhaka | Dhaka |

  Scenario Outline: Add Collection Point
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds a collection point "<name>" and "<bank>" and "<code>" and "<address>" and "<city>" and "<state>"

    Examples: 
      | name         | bank          | code | address    | city       | state |
      | Pubali Bank  | Janata Bank   |  001 | Bangladesh | MYMENSINGH | Dhaka |
      | Eastern Bank | National Bank |  002 | Bangladesh | Dhaka      | Dhaka |

  Scenario Outline: Add Processing Bank
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds a processing  bank "<firstName>" and "<LastName>" and "<username>" and "<password>" and "<fullBankName>" and "<bankName>" and "<bankCode>" and "<bankAddress>" and "<town>" and "<bankCountry>" and "<email>" and "<bankSuperID>"

    Examples: 
      | firstName  | LastName | username           | password  | fullBankName    | bankName | bankCode | bankAddress      | town  | bankCountry | email                       | bankSuperID         |
      | City       | bank     | citybankBangladesh | Password2 | City Bank       | CB       |      001 | 45 closed city   | Dhaka | Bangladesh  | abayomi.alonge@remitone.com | Overview Super Bank |
      | Commercial | bank     | commercialbank     | Password2 | Commercial Bank | COMB     |      002 | 45 Charlton Road | Dhaka | Bangladesh  | abayomi.alonge@remitone.com |                     |

  Scenario: First Processing bank (citybankBangladesh) login and Password Change
    Given user is on the "arm" landing page
    When user enters "citybankBangladesh" and "Password2"
    Then the "Preferences" page is displayed
    When user changes password by entering the old password "Password2" and the new password "Password1" and confirmed new password "Password1" and clicks continue
    Then the user is displayed with the following message "User Profile updated successfully"

  Scenario: First Processing bank (commercialbank) login and Password Change
    Given user is on the "arm" landing page
    When user enters "commercialbank" and "Password2"
    Then the "Preferences" page is displayed
    When user changes password by entering the old password "Password2" and the new password "Password1" and confirmed new password "Password1" and clicks continue
    Then the user is displayed with the following message "User Profile updated successfully"

  Scenario: Add an  Agent
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds an agent
      | Boss Express | Brown | Bobby | brownagent | Password2 | United Kingdom | 45 Best town | London | Address21111 | 28000 | abayomi.alonge@remitone.com | 35256236262 | 42 | Yomi | Yomi | Yomi |

  Scenario: First Agent Valid login and Password Change
    Given user is on the "arm" landing page
    When user enters "brownagent" and "Password2"
    Then the "Preferences" page is displayed
    When user changes password by entering the old password "Password2" and the new password "Password1" and confirmed new password "Password1" and clicks continue
    Then the user is displayed with the following message "User Profile updated successfully"

  Scenario: Add a member beneficiary
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds a member beneficiary
      | SADI | MANNAN | ALLEN STREET | BENGAZI | Dhaka | abayomi.alonge@remitone.com | 10000 | label=PASSPORT | 595493359590 | 263456 | 07628664252 | 12345678911 | TW9 | Dhaka | 04359392828278 | Dhaka | Janata Bank | National Bank | Janata Bank | 43682472471371 | 594848338 | 764796963479634 |

  Scenario: set agent credit
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then add agent credit "500"

  Scenario Outline: Add bank credit
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then add bank credit "<bankName>" and "<deposit>"

    Examples: 
      | bankName | deposit |
      | CB       |  100000 |
      | COMB     |  100000 |

  Scenario: set buy rates
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then link agent to teller first name is  "Banks"  and last name "moses" and username "bankagentteller" and password is "Password1"

  Scenario: Set Compliance limits
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user sets compliance limits

  Scenario: set bank buy rates
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user sets buy rate one "+0.1%" and buy rate two "+0.3%"

  Scenario Outline: set commission slabs
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then the user sets commission slabs "<amount>" and "<commFixed>" and "<commPerc>" and "<slabIndex>"

    Examples: 
      | amount | commFixed | commPerc | slabIndex |
      |   1000 |        10 |        5 |         1 |
      |   1000 |        15 |        5 |         2 |

  Scenario Outline: Sell Rates Admin
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then user adds sell rates "<hqAgentAmount>" and "<nonHQAgentAmount>" for "<index>"

    Examples: 
      | hqAgentAmount | nonHQAgentAmount | index |
      | -0.3%         | -0.4%            |     1 |
      | -0.4%         | -0.5%            |     2 |

  Scenario: Logout
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then user clicks the logout link

  Scenario Outline: Add WS Admin Users
    Given user is on the "arm" landing page
    When user enters "admin" and "Password1"
    Then the "Current rate to Bangladesh" page is displayed
    Then set webservice user "<username>" and "<pwd>" and "<associatedUser>"

    Examples: 
      | associatedUser  | username  | pwd        |
      | Admin           | wsagent12 | Password12 |
      | bobby           | wsagent12 | Password12 |
      | city bank       | wsbank11  | Password12 |
      | commercial bank | wsbank12  | Password12 |
