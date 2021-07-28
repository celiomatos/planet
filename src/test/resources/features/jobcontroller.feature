Feature: Job Controller
  Scenario: Find All Jobs
    When Get no endpoint job
    Then Obtem todos os registros de jobs

  Scenario: Criar um Job
    Given Post no endpoint job
      | title                               | minSalary  | maxSalary |
      | Desenvolvedor Front-end Junior      | -1         | 10000     |
    Then Obtenho o id do job