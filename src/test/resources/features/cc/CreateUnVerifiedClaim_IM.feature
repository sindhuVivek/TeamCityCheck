@create_unverifiedclaim_im
Feature: UnVerified IM claim creation

  @create_unverifiedclaim_im
  Scenario Outline: UnVerified IM claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a unverified claim for the IM claim type

    Examples:
      | scenariofortestdata       | excelPath                                               |
      |  UnverifiedClaim_IM       | src/test/resources/dataExcel/CC_FNOL_Unverified_IM.xlsx |