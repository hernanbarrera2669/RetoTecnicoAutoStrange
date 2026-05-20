Feature: Create User

  @CreateUserSuccessfully
  Scenario: Create user successfully
    #Given the user accesses the application
    When the user tries to create a user
    Then the user response is 201
