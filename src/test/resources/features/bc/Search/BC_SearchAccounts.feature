@BC
Feature: BC Search Account

  @BCSearchAccount
  Scenario Outline: Search Account
    Given User logs into "BillingCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    Then  User searches for a account

    Examples:
      | scenariofortestdata | excelPath                                   |
      | BCSearchAccount| src/test/resources/dataExcel/bc/BC_SearchAccount_SearchPolicy.xlsx |