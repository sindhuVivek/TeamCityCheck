@create_verifiedclaim_im
Feature: Verified IM claim creation

  @create_verifiedclaim_im
  Scenario Outline: Verified IM claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a claim for the IM claim type


    Examples:
      | scenariofortestdata       | excelPath                                           |
      |  VerifiedClaimCreation_IM | src/test/resources/dataExcel/CC_FNOL_Verify_IM.xlsx |