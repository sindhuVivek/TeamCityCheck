Feature: HO New Submission

    @HO_NewSubmission_ExcelModularization
    Scenario Outline: HO NewSubmission on PC using Excel Modular Data
        Given User logs into "PolicyCenter" application
        When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
        Then User Quotes and issues a Homeowners policy with Modularized Excel



        Examples:
            | scenariofortestdata | excelPath                                                 |
            | HONewSubmission     | src/test/resources/dataExcel/pc/PC_New_Submission_HO.xlsx |
