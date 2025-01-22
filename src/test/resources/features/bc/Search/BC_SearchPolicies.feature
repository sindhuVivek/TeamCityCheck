@BC @BCSearch
Feature: BC Search Account and Policy

  Background:
    Given User logs into "BillingCenter" application

  @BCSearchPolicy
  Scenario Outline: BC Search Policy "<scenariofortestdata>"
    Given scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "BC"
    When User searches for a policy
    Then policy should be retrieved successfully

    Examples:
      | scenariofortestdata | excelPath                                                          |
      | BCSearchPolicy      | src\test\resources\dataExcel\bc\BC_SearchAccount_SearchPolicy.xlsx |
