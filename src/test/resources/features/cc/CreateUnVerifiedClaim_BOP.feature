@create_unverifiedclaim_bop
Feature: UnVerified BOP claim creation

  @create_unverifiedclaim_bop
  Scenario Outline: UnVerified BOP claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a unverified claim for the BOP claim type

    Examples:
      | scenariofortestdata       | excelPath                                               |
      | UnverifiedClaim_BOP       | src/test/resources/dataExcel/cc/CC_FNOL_Verify_BOP.xlsx |