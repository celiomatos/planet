Feature: Propondo lances ao leilao
  Scenario: Propondo um unico lance valido
    Given um lance valido
    When propoe ao leilao
    Then o lance eh aceito