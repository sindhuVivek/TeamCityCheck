@PolicyChangeIM
Feature: PC_PolicyChange_IM

  @PolicyChangeIM
  Scenario Outline: Policy Change for IM with existing policy with Excel Modularization
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    When User searches a existing policy
    Then User initiates policy change
    And Updates the IM policy

    Examples:
      | scenariofortestdata | excelPath                                                 |
      | IM_PolicyChange     | src/test/resources/dataExcel/pc/PC_New_Submission_IM.xlsx |
