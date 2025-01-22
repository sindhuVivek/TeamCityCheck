@edit_negotiation
Feature: Edit Negotiation

@edit_negotiation
  Scenario Outline: Edit negotiation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should able to search the claim
    When user should be able to edit a negotiation


    Examples:
      | scenariofortestdata | excelPath                                        |
      | EditNegotiation     | src/test/resources/dataExcel/cc/Negotiation.xlsx |