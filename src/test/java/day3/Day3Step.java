package day3;

import advent.day2.Day2;
import advent.day3.Day3;
import io.cucumber.java8.En;
import utils.ReadFile;

import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        When("move {string} left and {string} down", (String xValues, String yValues) -> {
            Integer[] xArray = Arrays.stream(xValues.split(","))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);
            Integer[] yArray = Arrays.stream(yValues.split(","))
                    .map(Integer::parseInt)
                    .toArray(Integer[]::new);

            List<Point> points = IntStream.range(0, xArray.length).boxed()
                    .map(i -> new Point(xArray[i], yArray[i]))
                    .collect(Collectors.toList());

            result = new Day3().countChoppedTrees(values, start, points);
        });

        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
