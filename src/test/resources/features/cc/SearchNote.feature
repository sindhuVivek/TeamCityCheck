Feature: Search New Note

  @search_Notes
  Scenario Outline: Search New Note
    Given User logs into "ClaimsCenter" application
    When  scenario name "<scenariofortestdata>" and excelPath "<excelPath>" to generate dynamic testdata for "CC"
    Then  user open a claim
    Then  user search a Note

    Examples:
      | scenariofortestdata   | excelPath                               |
      | SearchNote            | src/test/resources/dataExcel/cc/CC_Note.xlsx |