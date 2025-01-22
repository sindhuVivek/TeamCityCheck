@create_verifiedclaim_cp
Feature: Verified CP claim creation

  @create_verifiedclaim_im
  Scenario Outline: Verified CP claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a claim for the CP claim type


    Examples:
      | scenariofortestdata      | excelPath                                              |
      | VerifiedClaimCreation_CP | src/test/resources/dataExcel/cc/CC_FNOL_Verify_CP.xlsx |