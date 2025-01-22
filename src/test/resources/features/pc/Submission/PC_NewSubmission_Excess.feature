Feature: PC New Submission Excess

  Background:
    Given I am a user with the Producer role

  @Excess_NewSubmission_ExcelModularization
  Scenario Outline: New Submission Excess with New Account with Excel Modularization
    Given scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    When User creates a new account
    Then account should be created successfully
    And User creates a new submission and quotes for Excess new submission with Modularized Excel

    Examples:
      | scenariofortestdata  | excelPath                                                |
      | Excess_NewSubmission | ui/modularizedExcelData/pc/PC_New_Submission_Excess.xlsx |
