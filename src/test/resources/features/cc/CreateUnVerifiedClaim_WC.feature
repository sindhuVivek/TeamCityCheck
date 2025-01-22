@create_unverifiedclaim_wc
Feature: UnVerified WC claim creation

  @create_unverifiedclaim_wc
  Scenario Outline: UnVerified WC claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a unverified claim for the WC claim type

    Examples:
      | scenariofortestdata       | excelPath                                               |
      |  UnverifiedClaim_WC      | src/test/resources/dataExcel/cc/CC_FNOL_Verify_WC.xlsx |