Feature: Eliminar Usuario

  @DeleteDataUserSuccessfully
  Scenario: delete data user successfully
    #Given the user accesses the application
    When the user deletes customer data with the following id: 4
    Then the user response is 200
