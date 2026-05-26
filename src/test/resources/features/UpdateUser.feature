Feature: Actualizar Usuario

  @UpdateUserSuccessfully
  Scenario: update user data successfully
    When the user updates customer data with the following id: 4
    Then the user response is 200
