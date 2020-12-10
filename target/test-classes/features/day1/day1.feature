Feature: Day1
    As a elf
    I want to identify the N numbers tha sum up to 2020
    So that I can multiply them

    Scenario Outline: Multiply the 2 number that sum up to 2020
        Given I have a <file>
        When I add 2 numbers to obtain the output <number>
        Then the result should be <result>

        Examples:
            | file                                                      | result    | number    |
            | "src/test/resources/features/day1/data/scenario1.txt"     | 514579    | 2020      |
            | "src/test/resources/features/day1/data/scenario2.txt"     | 482811    | 2020      |

    Scenario Outline: Multiply the 3 number that sum up to 2020
        Given I have a <file>
        When I add 3 numbers to obtain the output <number>
        Then the result should be <result>

        Examples:
            | file                                                      | result        | number    |
            | "src/test/resources/features/day1/data/scenario1.txt"     | 241861950     | 2020      |
            | "src/test/resources/features/day1/data/scenario2.txt"     | 193171814     | 2020      |
