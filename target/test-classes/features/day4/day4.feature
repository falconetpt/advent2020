Feature: Day4
    As a elf
    I want to count the valid passports
    So that I can see how many passports are valid

    Scenario Outline: Should count the number of valid passports
        Given I have a <file>
        When I have <mandatoryFields> and <optionalFields>
        Then the result should be <result>

        Examples:
            | file                                                  | mandatoryFields               | optionalFields    | result    |
            | "src/test/resources/features/day4/data/scenario1.txt" | "byr,iyr,eyr,hgt,hcl,ecl,pid" | "cid"             | 2         |
            | "src/test/resources/features/day4/data/scenario2.txt" | "byr,iyr,eyr,hgt,hcl,ecl,pid" | "cid"             | 219       |

    Scenario Outline: Should count the number of valid passports
        Given I have a <file>
        When I have <mandatoryFields> and <optionalFields> with validation
        Then the result should be <result>

        Examples:
            | file                                                                      | mandatoryFields               | optionalFields    | result    |
            | "src/test/resources/features/day4/data/scenario3_invalid_passport.txt"    | "byr,iyr,eyr,hgt,hcl,ecl,pid" | "cid"             | 0         |
            | "src/test/resources/features/day4/data/scenario4_valid_passport.txt"      | "byr,iyr,eyr,hgt,hcl,ecl,pid" | "cid"             | 4         |
            | "src/test/resources/features/day4/data/scenario2.txt"                     | "byr,iyr,eyr,hgt,hcl,ecl,pid" | "cid"             | 127       |
