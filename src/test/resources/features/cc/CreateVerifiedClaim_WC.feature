@create_verifiedclaim_wc
Feature: Verified WC claim creation

  @create_verifiedclaim_wc
  Scenario Outline: Verified WC claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a claim for the WC claim type


    Examples:
      | scenariofortestdata       | excelPath                                           |
      |  VerifiedClaimCreation_WC | src/test/resources/dataExcel/cc/CC_FNOL_Verify_WC.xlsx |