Feature: PC New Submission BOP

  @BOP_NewSubmission_ExcelModularization
  Scenario Outline: New Submission for Business Owners policy with New Account using Excel Modularization
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then account should be created successfully_Person
    And User Quotes and issues a Business Owner policy with Modularized Excel
    Examples:
      | scenariofortestdata | excelPath                                             |
      | BOP_NewSubmission   | src/test/resources/dataExcel/pc/PC_New_Submission_BOP.xlsx |
