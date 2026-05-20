Feature: Consultar Usuario

  @VerifyDataUser
  Scenario: Get the users data in the site
    #Given the user accesses the application
    When the user tries to get the customer data with id 4
    Then the user response is 200

  @VerifyAllDataUser
  Scenario: Get the users data in the site
    Given the user accesses the application
    When the user tries to get all the customers data
    Then the user response is 200
