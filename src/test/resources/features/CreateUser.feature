Feature: Post User

  @CreateUserSuccessfully
  Scenario: Create user successfully
    When the user tries to create an user
    Then the user response is 201
    And the user data is correct
