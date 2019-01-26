@FullRegression @Webservices
Feature: RemitOne Webservices

  Scenario: Create Remitter Webservice
    Given user is on the "webservices" landing page
    When user click on webservice "createRemitter"
    Then user validates the create Remitter Agent web service
      | wsagent12 | Password12 | 12345 | Deansdf | Smithsdfsd | United Kingdom | registered | valid | 45234 closed city | Park | LONDON | se444 | joey.smsdfgh9@remitone.com | 26235462626 | 44123456 | 27882 | Passport | 8372345453456611 | 2020-06-01 | 37237345345474 | 3455 | uploadFile.PNG |

  Scenario: Create Beneficiary Webservice
    Given user is on the "webservices" landing page
    When user click on webservice "createBeneficiary"
    Then user validates the create Beneficiary Agent web service
      | wsagent12 | Password12 | 12345 | Tara Josh | Alcalade henares | Address21111 | Dhaka | Dhaka | 28000 | Bangladesh | 1977-03-18 | +578463752613 | Passport | 7968455734 | 5798473723 | 267272373 | Janata Bank | One bank | Dhaka | Dhaka | 1234 | 10000 |

  Scenario: Search Remitter Webservice
    Given user is on the "webservices" landing page
    When user click on webservice "searchRemitter"
    Then user validates the search Remitter Agent web service
      | wsagent12 | Password12 | 12345 | 10000 | Zidazne | zidane | LONDON | abayomi.alonge@remitone.com | Registered |

  Scenario: Get Sell Rates
    Given user is on the "webservices" landing page
    When user click on webservice "getSellRates"
    Then user validates the get sell rates web service
      | wsagent12 | Password12 | 12345 | United Kingdom | Bangladesh |

  Scenario: Insert Transaction
    Given user is on the "webservices" landing page
    When user click on webservice "insertTransaction"
    Then user validates the insert transaction detail web service
      | wsagent12 | Password12 | 12345 | AgentTransRef123xxxa | Account | 1 | 1 | Akin Alex | Passport | United Kingdom | 2000-01-01 | 45 closed city | +442626262626 | 83737dasasd27226611 | SADI MANNANSSS | ALLEN STREET BENGAZI | BENGAZI | ALLEN STREET | Dhaka | DHAKA | TW9 | 77628664252 | 12345678911 | PASSPORT | kjasbdkvjghkjasdhfkjhsdafkjh | 43682472471371 | JANATA BANK | 1234 | One Bank | 1 | 1 | GBP | 100 | BDT | 12911.9 | 129.119 | 5 | 2 |

  Scenario: Confirm Transaction
    Given user is on the "webservices" landing page
    When user click on webservice "confirmTransaction"
    Then user validates the confirm transaction web service
      | wsagent12 | Password12 | 12345 | 123456789 |

  Scenario: Process Payout Transaction
    Given user is on the "webservices" landing page
    When user click on webservice "processPayoutTransaction"
    Then user validates the process payout transaction web service
      | wsbank11 | Password12 | 12345 | transref1234 |

  Scenario: Get Payout Transaction Bank
    Given user is on the "webservices" landing page
    When user click on webservice "getPayoutTransactions"
    Then user validates the get payout transaction bank web service
      | wsbank11 | Password12 | 12345 |

  Scenario: Accept Payout Transaction
    Given user is on the "webservices" landing page
    When user click on webservice "acceptPayoutTransactions"
    Then user validates the accept payout transaction web service
      | wsbank11 | Password12 | 12345 | transref1234 |
