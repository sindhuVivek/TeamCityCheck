@create_quickclaim_bop
Feature: BOP Quick claim creation

  @create_quickclaim_bop
  Scenario Outline: Quick claim BOP claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a claim for the Quick BOP claim type

    Examples:
      | scenariofortestdata    | excelPath                                               |
      | QuickClaimCreation_BOP | src/test/resources/dataExcel/cc/CC_FNOL_Verify_BOP.xlsx |
