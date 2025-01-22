Feature: PA Policy Change

    @PA_PolicyChange_ExcelModularization
    Scenario Outline: PA Policy Change on PC using Excel Modular Data
        Given User logs into "PolicyCenter" application
        When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
        And user searches for a policy using Policy number
        Then User executes a Policy Change and issues it for Personal Auto with Modularized Excel


        Examples:
            | scenariofortestdata | excelPath                                                 |
            | PA_PolicyChange     | src/test/resources/dataExcel/pc/PC_New_Submission_PA.xlsx |
