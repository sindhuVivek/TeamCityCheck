Feature: PC New Submission WC

  Background:
    Given I am a user with the Producer role

  @WC_NewSubmission_ExcelModularization
  Scenario Outline: New Submission WC with New Account with Excel Modularization
    Given scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    When User creates a new account
    Then account should be created successfully
    And User creates a new submission and quotes for Workers comp new submission with Modularized Excel

    Examples:
      | scenariofortestdata | excelPath                                            |
      | WC_NewSubmission    | ui/modularizedExcelData/pc/PC_New_Submission_WC.xlsx |
