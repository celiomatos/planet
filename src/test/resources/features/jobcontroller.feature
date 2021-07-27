Feature: Job Controller
  Scenario: Find All Jobs
    When Get no endpoint job
    Then Obtem todos os registros de jobs

  Scenario: Criar um Job
    Given Post no endpoint job
      | id  | name  |
      | 1   | celio |
    Then Obtenho o id do job