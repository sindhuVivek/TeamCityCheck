@search_claim
Feature: Search Claim

  @search_claim
  Scenario Outline: Search Claim
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should able to search the claim

    Examples:
      | scenariofortestdata           | excelPath                                                  |
      | SearchClaimScenario           | src/test/resources/dataExcel/cc/CC_Search_Claim.xlsx       |
