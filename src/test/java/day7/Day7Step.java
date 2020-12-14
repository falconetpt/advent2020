package day7;

import advent.day6.Day6;
import io.cucumber.java8.En;
import utils.ReadFile;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class Day6Step implements En {
    private List<String> values;
    private List<List<String>> valuesList;
    private int result;

    public Day6Step() {
        Given("I have {string}", (String string) -> values = Arrays.asList(string.split(",")));
        Given("I have a {string}", (String file) -> {
            final List<String> readLines = ReadFile.readFile(file).collect(Collectors.toList());
            valuesList = new ArrayList<>();
            List<String> listToAdd = new ArrayList<>();

            for (final String s : readLines) {
                if (s.isEmpty()) {
                    valuesList.add(listToAdd);
                    listToAdd = new ArrayList<>();
                } else {
                    listToAdd.add(s);
                }
            }

            valuesList.add(listToAdd);
        });

        When("I calculate the answers", () -> result = new Day6().calculateAnswers(values));
        When("I calculate the answers with all", () -> result = new Day6().calculateAllAnswers(values));
        When("I calculate the sum of all the answers", () -> result = new Day6().calculateTotalAllAnswers(valuesList));
        When("I calculate the sum of the answers", () -> result = new Day6().calculateTotalAnswers(valuesList));

        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
