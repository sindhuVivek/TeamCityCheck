@create_unverifiedclaim_ca
Feature: Unverified CA claim creation

  @create_unverifiedclaim_ca
  Scenario Outline: Unverified CA claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a unverified claim for the CA claim type


    Examples:
      | scenariofortestdata | excelPath                                       |
      | UnverifiedClaim_CA  | src/test/resources/dataExcel/cc/CC_FNOL_CA.xlsx |