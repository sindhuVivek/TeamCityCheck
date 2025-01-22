@add_Negotiation
Feature: Add Negotiation

@add_Negotiation
  Scenario Outline: Add Negotiation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should able to search the claim
    When user should be able to add a new Negotiation


    Examples:
      | scenariofortestdata   | excelPath                                         |
      | AddNegotiation        | src/test/resources/dataExcel/cc/Negotiation.xlsx  |