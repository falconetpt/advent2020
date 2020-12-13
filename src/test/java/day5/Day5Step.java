package day5;

import advent.day4.Day4;
import advent.day5.Day5;
import io.cucumber.java8.Da;
import io.cucumber.java8.En;
import utils.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class Day5Step implements En {
    private String value;
    private List<String> values;
    private int result;

    public Day5Step() {
        Given("I have a {string}", (String string) -> {
            value = string;
        });

        Given("I load a {string}", (String string) -> {
            values = ReadFile.readFile(string)
                    .collect(Collectors.toList());
        });

        When("I calculate the seat id", () -> {
            result = new Day5().calculateSeatId(value);
        });

        When("I calculate the max seat id", () -> {
            result = new Day5().calculateMaxSeatId(values);
        });

        When("I calculate the missing seat id", () -> {
            result = new Day5().calculateSeatId(values);
        });

        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
