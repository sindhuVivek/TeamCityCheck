@create_quickclaim_im
Feature: IM Quick claim creation

  @create_quickclaim_im
  Scenario Outline: Verified IM claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a claim for the Quick IM claim type

    Examples:
      | scenariofortestdata   | excelPath                                            |
      | QuickClaimCreation_IM | src/test/resources/dataExcel/CC_FNOL_Verify_IM1.xlsx |
