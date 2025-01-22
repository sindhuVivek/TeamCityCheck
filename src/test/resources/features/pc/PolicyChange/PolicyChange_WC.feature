@PolicyChangeWC
Feature: PC_PolicyChange_WC

  @PolicyChangeWC
  Scenario Outline: Policy Change for WC with existing policy with Excel Modularization
    Given User logs into "PolicyCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    When User searches a existing policy
    Then User initiates policy change
    And Updates the WC policy

    Examples:
      | scenariofortestdata | excelPath                                                 |
      | WC_PolicyChange     | src/test/resources/dataExcel/pc/PC_New_Submission_WC.xlsx |
