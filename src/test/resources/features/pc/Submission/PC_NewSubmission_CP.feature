Feature: PC New Submission CP


  @CP_NewSubmission_ExcelModularization
  Scenario Outline: New Submission for Commercial Property with New Account using Excel Modularization
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    And account should be created successfully_Person
    Then user quotes and issues a Commercial Property submission with Modularized Excel

    Examples:
      | scenariofortestdata | excelPath                                            |
      | CP_NewSubmission    |src/test/resources/dataExcel/pc/PC_New_Submission_CP.xlsx |
