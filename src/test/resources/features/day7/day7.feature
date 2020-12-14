Feature: Day7
    As a elf
    I want to know the number of shiny gold
    So that I can know how many i can cary

    Scenario Outline: Should return the shiny gold
        Given I have a <file>
        When I calculate the number of shiny gold
        Then the result should be <result>

        Examples:
            | file                                                  | result    |
            | "src/test/resources/features/day7/data/scenario1.txt" | 4         |
            | "src/test/resources/features/day7/data/scenario2.txt" | 257       |


    Scenario Outline: Should return the shiny gold
        Given I have a <file>
        When I calculate the number of total bags in shiny gold
        Then the result should be <result>

        Examples:
            | file                                                  | result    |
            | "src/test/resources/features/day7/data/scenario3.txt" | 126       |
            | "src/test/resources/features/day7/data/scenario2.txt" | 257       |