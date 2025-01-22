@search_contacts
Feature: Search Contacts

  @search_company
  Scenario Outline: Search Company
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should able to search the Company Contacts with Company Name details in Claim Center

    Examples:
      | scenariofortestdata              | excelPath                                                      |
      | SearchCompanyScenario            | src/test/resources/dataExcel/cc/CC_Search_Contacts.xlsx        |

  @search_person
  Scenario Outline: Search Person
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  User should able to search the Person Contact with Person details in Claim Center

    Examples:
      | scenariofortestdata           | excelPath                                                        |
      | SearchPersonScenario          | src/test/resources/dataExcel/cc/CC_Search_Contacts.xlsx          |
