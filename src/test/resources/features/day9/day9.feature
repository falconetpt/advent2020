Feature: Day9
    As a elf
    I want to know the value of the the first non conforming number
    So that I can crack the code

    Scenario Outline: Should return the value of the accumulator
        Given I have a <file>
        When I calculate the value of <preambule> and <index>
        Then the result should be <result>

        Examples:
            | file                                                  | preambule | index |  result   |
            | "src/test/resources/features/day9/data/scenario1.txt" | 5         | 5     |  127      |
            | "src/test/resources/features/day9/data/scenario2.txt" | 25        | 25    |  10884537 |


    Scenario Outline: Should return the value of the accumulator
        Given I have a <file>
        When I calculate the value of <preambule> with sum
        Then the result should be <result>

        Examples:
            | file                                                  | preambule  |  result  |
            | "src/test/resources/features/day9/data/scenario1.txt" | 5          |  62      |
            | "src/test/resources/features/day9/data/scenario2.txt" | 25         |  1261309 |
