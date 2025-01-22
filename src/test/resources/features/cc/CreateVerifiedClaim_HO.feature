@create_verifiedclaim_ho
Feature: Verified HO claim creation

  @create_verifiedclaim_ho
  Scenario Outline: Verified HO claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a claim for the HO claim type


    Examples:
      | scenariofortestdata      | excelPath                                              |
      | VerifiedClaimCreation_HO | src/test/resources/dataExcel/cc/CC_FNOL_Verify_HO.xlsx |