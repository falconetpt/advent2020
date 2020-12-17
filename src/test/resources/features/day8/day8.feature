Feature: Day8
    As a elf
    I want to know the value of the accumulator
    So that I can know how much power i have

    Scenario Outline: Should return the value of the accumulator
        Given I have a <file>
        When I calculate the value of accumulator
        Then the result should be <result>

        Examples:
            | file                                                  | result    |
            | "src/test/resources/features/day8/data/scenario1.txt" | 5         |
            | "src/test/resources/features/day8/data/scenario2.txt" | 1723      |

    Scenario Outline: Should return the value of the accumulator
        Given I have a <file>
        When I calculate the value of accumulator with nop and jmp swapped
        Then the result should be <result>

        Examples:
            | file                                                  | result    |
            | "src/test/resources/features/day8/data/scenario1.txt" | 8         |
            | "src/test/resources/features/day8/data/scenario2.txt" | 1723      |
