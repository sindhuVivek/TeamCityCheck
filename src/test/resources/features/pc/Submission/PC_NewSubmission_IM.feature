Feature: PC New Submission IM

  Background:
    Given I am a user with the Producer role

  @IM_NewSubmission_ExcelModularization
  Scenario Outline: New Submission Inland marine with New Account with Excel Modularization
    Given scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    When User creates a new account
    Then account should be created successfully
    And User creates a new submission and quotes for Inland Marine new submission with Modularized Excel

    Examples:
      | scenariofortestdata | excelPath                                            |
      | IM_NewSubmission    | ui/modularizedExcelData/pc/PC_New_Submission_IM.xlsx |
