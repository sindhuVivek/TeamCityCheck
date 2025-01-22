@delete_negotiation
Feature: Delete Negotiation

@delete_negotiation
  Scenario Outline: Delete Negotiation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should able to search the claim
    When user should be able to delete a negotiation


    Examples:
      | scenariofortestdata   | excelPath                                         |
      | DeleteNegotiation     | src/test/resources/dataExcel/cc/Negotiation.xlsx  |