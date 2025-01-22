Feature: PC New Submission CA

  @CA_NewSubmission_ExcelModularization
  Scenario Outline: New Submission for Commercial Auto policy with New Account using Excel Modularization
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then account should be created successfully_Person
    And User Quotes and issues a Commercial Auto policy with Modularized Excel

    Examples:
      | scenariofortestdata | excelPath                                                 |
      | CA_NewSubmissionCA   | src/test/resources/dataExcel/pc/PC_New_Submission_CA.xlsx  |