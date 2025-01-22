Feature: PC New Submission PA

  @PA_NewSubmission_ExcelModularization
  Scenario Outline: New Submission for Personal Auto policy with New Account using Excel Modularization
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then user quotes and issues a Personal Auto submission with Modularized Excel

    Examples:
      | scenariofortestdata | excelPath                                                 |
      | PA_NewSubmission    | src/test/resources/dataExcel/pc/PC_New_Submission_PA.xlsx |
