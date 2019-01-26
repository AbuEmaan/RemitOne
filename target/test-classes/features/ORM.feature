@FullRegression @ORM
Feature:ORM

Scenario: Quick Registration
    Given user is on the "orm" landing page
    When user clicks the "Register" link
    Then the "Registration" page is displayed
    Then user completes the registration form and submits
      | dummy@remitone.com | Password1 | Password1 | Dean | Smith | 19/05/1972 | 77 244 133 |
	


  Scenario: Qucik ORM Login 
   Given user is on the "orm" landing page
   When user logs in with his credentials "dummy@remitone.com" and "Password1"
   Then the user is displayed with the following message "Welcome Dean Smith"
   
   
     Scenario:  ORM Login via link
   Given user is on the "orm" landing page
    When user clicks the "Login" link
   When user logs in with his credentials "dummy@remitone.com" and "Password1"
   Then the user is displayed with the following message "Welcome Dean Smith"

   Scenario: ORM Logout
   Given user is on the "orm" landing page
   When user logs in with his credentials "dummy@remitone.com" and "Password1"
   When the user clicks the logout link
   Then the user is displayed with the following message "Successfully logged out."
   
     Scenario: Edit Profile 
   Given user is on the "orm" landing page
   When user logs in with his credentials "dummy@remitone.com" and "Password1"
   Then the "Home" page is displayed
   When user clicks on the my profile link
   Then the "My Profile" page is displayed
   When users edits the profile
   |United Kingdom|Male|99 Al Alaa|	Al Firdows|Jennatul Naeem|Fissamaa|99 Names|7867867861|Passport|1234567890|12/12/2020|
   Then the user is displayed with the following message "Profile updated"
   
   
 Scenario: Add Beneficiary  
   Given user is on the "orm" landing page
   When user logs in with his credentials "dummy@remitone.com" and "Password1"
   Then the "Home" page is displayed
   When user clicks the "Beneficiaries" link
   Then the "Beneficiaries" page is displayed
   When user adds beneficiary
   |Husain|Cassamoali|Address 1A|	Address 2A|City A|State A|88 Post|Bangladesh|00880999888777|+880999888777|dummy2@remitone.com|PASSPORT|333222111|444555666|	My really special notes for delivery|5558882220|00880444777999|
   Then the user is displayed with the following message "Beneficiary created successfully."
   
   

  #  Scenario: ORM Change Language
  # Given user is on the "orm" landing page
  # When user enters "admin" and "remitone"
  # Then the "Current rate to Bangladesh" page is displayed
  #When the user clicks the logout link
  #  When user changes language to "Thai"
  #  Then language changed message is displayed
  
  
  
  

  