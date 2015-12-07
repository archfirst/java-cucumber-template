Feature: Accounts
In order to organize my transactions,
as a user,
I want the ability to create, update and delete accounts.

Scenario: Account Creation
    When I create an account called Cash
    And I ask for the account
    Then I should get the account called Cash

Scenario: Account Update
    Given an account called BofA Checking
    When I change the account name to Bank of America Checking
    And I ask for the account
    Then I should get the account called Bank of America Checking


Scenario: Account Deletion
    Given an account called BofA Checking
    When I delete the account
    And I ask for the account
    Then a "404 Not Found" error should be returned
