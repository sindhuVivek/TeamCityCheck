@create_verifiedclaim_excess
Feature: Verified Excess claim creation

  @create_verifiedclaim_excess
  Scenario Outline: Verified Excess claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a claim for the Excess claim type


    Examples:
      | scenariofortestdata           | excelPath                                               |
      |  VerifiedClaimCreation_Excess | src/test/resources/dataExcel/CC_FNOL_Verify_Excess.xlsx |