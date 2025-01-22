@search_policy
Feature: Search Policy

  @search_policy
  Scenario Outline: Search Claim
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should able to search the Policy in Claim Center

    Examples:
      | scenariofortestdata            | excelPath                                                    |
      | SearchPolicyScenario           | src/test/resources/dataExcel/cc/CC_Search_Policy.xlsx        |
