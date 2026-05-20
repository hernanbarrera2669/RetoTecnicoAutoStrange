Feature: Actualizar Usuario

  @UpdateUserSuccessfully
  Scenario Outline: update user data successfully
    Given the user accesses the application to update user data
    When the user updates customer data with the following information: <id>, <userId>, <title> and <body>
    Then the user response is 200

    Examples:
      | id | userId | title      | body               |
      |  4 |      4 | Hola Mundo | Contenido del post |
