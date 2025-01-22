Feature: GL New Submission

 @GL_NewSubmission_ExcelModularization
    Scenario Outline: GL NewSubmission on PC using Excel Modular Data
        Given User logs into "PolicyCenter" application
        When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
        And account should be created successfully
        Then User Quotes and issues a General Liability policy with Modularized Excel


        Examples:
            | scenariofortestdata | excelPath                                            |
            | GLNewSubmission     | src/test/resources/dataExcel/pc/PC_New_Submission_GL.xlsx |

