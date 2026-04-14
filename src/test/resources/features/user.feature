Feature: User API

  Scenario: Get users
    When I request users
    Then response contains "Alice"