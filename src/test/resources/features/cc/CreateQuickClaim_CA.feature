@create_quickclaim_ca
Feature: CA Quick claim creation

  @create_quickclaim_ca
  Scenario Outline: CA quick claim creation
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user creates a quick claim for the CA claim type

    Examples:
      | scenariofortestdata   | excelPath                                       |
      | QuickClaimCreation_CA | src/test/resources/dataExcel/cc/CC_FNOL_CA.xlsx |
