Feature: Validacao API JSON

  Scenario: validacao do sistema API

    Given que seja acessado a api "https://reqres.in/api/users/1"
    When for validado o valor do campo name que seja igua a "George"
    Then efetuado o teste de contrato ou schema