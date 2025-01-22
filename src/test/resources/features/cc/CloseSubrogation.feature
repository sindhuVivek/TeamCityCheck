@close_subrogation
Feature: Verify Group

  @close_subrogation
  Scenario Outline: Verify Group
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    When  user closes the subrogation with subrogationStatus,outcome and Subrogation should be Validated successfully


    Examples:
      | scenariofortestdata           | excelPath                                          |
      |  SubroClose | src/test/resources/dataExcel/cc/CC_Subrogation.xlsx |