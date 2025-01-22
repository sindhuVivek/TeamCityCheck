@create_verifiedclaim_pa
Feature: Verified IM claim creation

  @create_verifiedclaim_pa
  Scenario Outline: Verified PA claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then user searches for the created PA claim


    Examples:
      | scenariofortestdata       | excelPath                                           |
      |  VerifiedClaimCreation_PA | src/test/resources/dataExcel/cc/CC_FNOL_Verify_PA.xlsx |