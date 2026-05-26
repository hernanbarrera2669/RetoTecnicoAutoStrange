Feature: Delete User

  @DeleteDataUserSuccessfully
  Scenario: delete data user successfully
    When the user deletes customer data with the following id: 4
    Then the user response is 200
