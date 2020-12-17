Feature: Day6
    As a elf
    I want to know the number of answers by group
    So that I can sum everything

    Scenario Outline: Should return the id
        Given I have <elements>
        When I calculate the answers
        Then the result should be <result>

        Examples:
            | elements           | result    |
            | "abcx,abcy,abcz"   | 6         |
            | "a,a,a"            | 1         |
            | ",,"               | 0         |
            | "a,b,c"            | 3         |

    Scenario Outline: Should return the id
        Given I have <elements>
        When I calculate the answers with all
        Then the result should be <result>

        Examples:
            | elements           | result    |
            | "abcx,abcy,abcz"   | 3         |
            | "a,a,a"            | 1         |
            | ",,"               | 0         |
            | "a,b,c"            | 0         |


    Scenario Outline: Should return the sum of answers
        Given I have a <file>
        When I calculate the sum of the answers
        Then the result should be <result>

        Examples:
            | file                                                  | result    |
            | "src/test/resources/features/day6/data/scenario1.txt" | 11        |
            | "src/test/resources/features/day6/data/scenario2.txt" | 6291      |

    Scenario Outline: Should return the sum of answers
        Given I have a <file>
        When I calculate the sum of all the answers
        Then the result should be <result>

        Examples:
            | file                                                  | result    |
            | "src/test/resources/features/day6/data/scenario1.txt" | 6         |
            | "src/test/resources/features/day6/data/scenario2.txt" | 3052      |
