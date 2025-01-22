@create_verifiedclaim_ca
Feature: Verified CA claim creation

  @create_verifiedclaim_ca
  Scenario Outline: Verified CA claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a claim for the CA claim type


    Examples:
      | scenariofortestdata      | excelPath                                       |
      | VerifiedClaimCreation_CA | src/test/resources/dataExcel/cc/CC_FNOL_CA.xlsx |