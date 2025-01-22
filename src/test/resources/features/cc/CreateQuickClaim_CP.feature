@create_quickclaim_cp
Feature: CP Quick claim creation

  @create_quickclaim_cp
  Scenario Outline: Verified CP claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a claim for the Quick CP claim type

    Examples:
      | scenariofortestdata   | excelPath                                              |
      | QuickClaimCreation_CP | src/test/resources/dataExcel/cc/CC_FNOL_Verify_CP.xlsx |
