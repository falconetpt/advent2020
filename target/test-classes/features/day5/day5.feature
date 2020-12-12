Feature: Day5
    As a elf
    I want to know the id of my seat
    So that I can see the largest seat

    Scenario Outline: Should return the id
        Given I have a <command>
        When I calculate the seat id
        Then the result should be <result>

        Examples:
            | command       | result    |
            | "FBFBBFFRLR"  | 357       |
            | "BFFFBBFRRR"  | 567       |
            | "FFFBBBFRRR"  | 119       |
            | "BBFFBBFRLL"  | 820       |

    Scenario Outline: Should return the max id
        Given I load a <file>
        When I calculate the max seat id
        Then the result should be <result>

        Examples:
        | file                                                      | result    |
        | "src/test/resources/features/day5/data/scenario1.txt"     | 820       |
        | "src/test/resources/features/day5/data/scenario2.txt"     | 858       |


