Feature: HO Policy Change

    @HO_PolicyChange_ExcelModularization
    Scenario Outline: HO Policy Change on PC using Excel Modular Data
        Given User logs into "PolicyCenter" application
        When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
        And User Quotes and issues a Homeowners policy with Modularized Excel
        Then User executes a Policy Change and issues it for Homeowners with Modularized Excel


        Examples:
            | scenariofortestdata | excelPath                                                 |
            | HOPolicyChange     | src/test/resources/dataExcel/pc/PC_New_Submission_HO.xlsx |
