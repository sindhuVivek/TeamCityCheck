@create_unverifiedclaim_HO
Feature: UnVerified HO claim creation

  @create_unverifiedclaim_HO
  Scenario Outline: UnVerified HO claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a unverified claim for the HO claim type

    Examples:
      | scenariofortestdata | excelPath                                              |
      | UnverifiedClaim_HO  | src/test/resources/dataExcel/cc/CC_FNOL_Verify_HO.xlsx |