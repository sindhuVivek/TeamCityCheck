 @PCNewAccount
Feature: PC New Account

  @PCNewAccountCompany
  Scenario Outline: PC New Account Company
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then account should be created successfully

    Examples: 
      | scenariofortestdata | excelPath                                            |
      | NewCompanyAccount   | src/test/resources/dataExcel/pc/PC_New_Account.xlsx |

  @PCNewAccountPerson
  Scenario Outline: PC New Account Person
    Given User logs into "PolicyCenter" application
    When scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "PC"
    Then account should be created successfully_Person

    Examples: 
      | scenariofortestdata | excelPath                                            |
      | NewPersonAccount    | src/test/resources/dataExcel/pc/PC_New_Account.xlsx |
