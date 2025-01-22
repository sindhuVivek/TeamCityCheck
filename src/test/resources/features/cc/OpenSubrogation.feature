@open_subrogation
Feature: Verify Group

  @open_subrogation
  Scenario Outline: Verify Group
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user opens the subrogation with subrogationStatus,outcome and Subrogation should be Validated successfully


    Examples:
      | scenariofortestdata           | excelPath                                          |
      |  SubroOpen | src/test/resources/dataExcel/cc/CC_Subrogation.xlsx |