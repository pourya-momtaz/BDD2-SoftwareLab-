@tag
Feature: Calculator
  Scenario: reverse a number
    Given One input value and operation, 8 and rvs
    When I do the operation on the value
    Then I expect the result 0.125

  Scenario: calculate square root of a number
    Given One input value and operation, 169 and sqr
    When I do the operation on the value
    Then I expect the result 13


  Scenario Outline: test calculator operations
    Given One input value and operation, <Input> and <opt>
    When I do the operation on the value
    Then I expect the result <result>
    Examples:
      | Input | opt | result |
      | 4 | rvs | 0.25 |
      | 4 | sqr | 2 |

  Scenario Outline: test calculator operations
    Given One input value and operation, <Input> and <opt>
    When I do the operation on the value
    Then I expect the exception <result>

    Examples:
      | Input | opt | result |
      | -1 | sqr | can't handle negative values |
      | 0 | rvs | can't handle division by zero |