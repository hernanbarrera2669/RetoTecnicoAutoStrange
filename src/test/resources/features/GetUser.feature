Feature: Get User

  @VerifyDataUser
  Scenario: Get the users data in the site
    When the user tries to get the customer data with id 4
    Then the user response is 200
    And the user data is correct
