package day3;

import advent.day2.Day2;
import advent.day3.Day3;
import io.cucumber.java8.En;
import utils.ReadFile;

import java.awt.*;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class Day3Step implements En {
    private List<String> values;
    private int start;
    private int result;

    public Day3Step() {
        Given("I have a {string}", (String file) -> values = ReadFile.readFile(file)
                .collect(Collectors.toList())
        );

        When("I start at {int}", (Integer startCoordinate) -> start = startCoordinate);

        When("move {int} left and {int} down", (Integer xValue, Integer yValue) -> {
            result = new Day3().countChoppedTrees(values, start, new Point(xValue, yValue));
        });

        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
