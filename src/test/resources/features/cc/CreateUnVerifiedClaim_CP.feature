@create_unverifiedclaim_cp
Feature: UnVerified CP claim creation

  @create_unverifiedclaim_im
  Scenario Outline: UnVerified cp claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a unverified claim for the CP claim type

    Examples:
      | scenariofortestdata | excelPath                                              |
      | UnverifiedClaim_CP  | src/test/resources/dataExcel/cc/CC_FNOL_Verify_CP.xlsx |