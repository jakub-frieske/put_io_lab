Feature: Login.
 
Background:
  Given I have cleared the database
  Given I have registered as user "jan" with password "jan", name "jan" and with address "ul. Kolorowa"
  
Scenario: Login
  Given I've moved to the login page
  When I fill the login form with username "jan" and password "jan", and I submit it
  Then I should see the accounts-list page