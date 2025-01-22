Feature: GL Quick Quote

  @GL_QuickQuote_ExcelModularization
  Scenario Outline: GL NewSubmission on PC using Excel Modular Data
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    And account should be created successfully
    Then User gets a Quick Quote for General Liability with Modularized Excel

    Examples:
      | scenariofortestdata | excelPath                                                  |
      | GLQuickQuote| src/test/resources/dataExcel/pc/PC_New_Submission_GL.xlsx |
