Feature: Day2
    As a elf
    I want to identify the valid passwords
    So that I can count them

    Scenario Outline: Should exclude invalid passwords
        Given I have a <file>
        When I check the valid password with frequency
        Then the result should be <result>

        Examples:
            | file                                                      | result    |
            | "src/test/resources/features/day2/data/scenario1.txt"     | 2         |
            | "src/test/resources/features/day2/data/scenario2.txt"     | 542       |

    Scenario Outline: Should exclude invalid passwords
        Given I have a <file>
        When I check the valid password with position
        Then the result should be <result>

        Examples:
            | file                                                      | result    |
            | "src/test/resources/features/day2/data/scenario1.txt"     | 1         |
            | "src/test/resources/features/day2/data/scenario2.txt"     | 360       |
