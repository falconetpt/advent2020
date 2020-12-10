Feature: Day3
    As a elf
    I want to count the trees in path
    So that I can count them

    Scenario Outline: Should count the number of trees in path
        Given I have a <file>
        When I start at <startPosition>
            And move <xValue> left and <yValue> down
        Then the result should be <result>

        Examples:
            | file                                                  | startPosition | xValue    | yValue    | result    |
            | "src/test/resources/features/day3/data/scenario1.txt" | 0             | 3         | 1         | 7         |
            | "src/test/resources/features/day3/data/scenario2.txt" | 0             | 3         | 1         | 193       |

        Scenario Outline: Should count the number of trees in path
            Given I have a <file>
            When I start at <startPosition>
            And move <xValues> left and <yValues> down
            Then the result should be <result>

            Examples:
                | file                                                  | startPosition | xValues       | yValues       | result    |
                | "src/test/resources/features/day3/data/scenario1.txt" | 0             | "1,3,5,7,1"   | "1,1,1,1,2"   | 336       |
                | "src/test/resources/features/day3/data/scenario2.txt" | 0             | "1,3,5,7,1"   | "1,1,1,1,2"   | 1355323200|
