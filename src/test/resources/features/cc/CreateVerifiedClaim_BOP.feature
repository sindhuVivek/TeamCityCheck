@create_verifiedclaim_bop
Feature: Verified BOP claim creation

  @create_verifiedclaim_bop
  Scenario Outline: Verified BOP claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a claim for the BOP claim type


    Examples:
      | scenariofortestdata       | excelPath                                               |
      | VerifiedClaimCreation_BOP | src/test/resources/dataExcel/cc/CC_FNOL_Verify_BOP.xlsx |