package day1;

import advent.day1.Day1;
import io.cucumber.java8.En;
import utils.ReadFile;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class Day1Step implements En {
    private List<Integer> values;
    private String result;

    public Day1Step() {
        Given("I have a {string}", (String file) -> values = ReadFile.readFile(file)
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );
        When("I add 2 numbers to obtain the output {int}", (sumUp) ->
                result = String.valueOf(new Day1().multiplyTwoNumbersThatSumUpTo(values, (int) sumUp))
        );
        When("I add 3 numbers to obtain the output {int}", (sumUp) ->
                result = String.valueOf(new Day1().multiplyThreeNumbersThatSumUpTo(values, (int) sumUp))
        );
        Then("the result should be {int}", (a) -> assertEquals(String.valueOf(a), result) );
        Then("the result should be {string}", (a) -> assertEquals((String) a, result) );
    }
}
