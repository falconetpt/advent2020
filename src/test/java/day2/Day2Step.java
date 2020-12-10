package day2;

import advent.day2.Day2;
import io.cucumber.java8.Da;
import io.cucumber.java8.En;
import utils.ReadFile;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class Day2Step implements En {
    private List<String> values;
    private int result;

    public Day2Step() {
        Given("I have a {string}", (String file) -> values = ReadFile.readFile(file)
                .collect(Collectors.toList())
        );

        When("I check the valid password with frequency", () ->
            result = new Day2().countValidPasswords(values)
        );

        When("I check the valid password with position", () ->
                result = new Day2().countValidPassWordsInPosition(values)
        );

        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
