package day4;

import advent.day3.Day3;
import advent.day4.Day4;
import io.cucumber.java8.En;
import utils.ReadFile;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;


public class Day4Step implements En {
    private List<String> values;
    private int start;
    private int result;

    public Day4Step() {
        Given("I have a {string}", (String file) -> {
            values = new ArrayList<>();
            StringBuilder value = new StringBuilder();

            for (final String line : ReadFile.readFile(file).collect(Collectors.toList())) {
                if (line.isEmpty()) {
                    values.add(value.toString().trim());
                    value = new StringBuilder();
                } else {
                    value.append(value).append(" ").append(line);
                }
            }

            if (!value.toString().isBlank()) values.add(value.toString().trim());
        });

        When("I have {string} and {string}", (String mandatory, String optional) -> {
            Set<String> mandatoryFields = Arrays.stream(mandatory.split(","))
                    .collect(Collectors.toSet());
            Set<String> optionalFields = Arrays.stream(optional.split(","))
                    .collect(Collectors.toSet());

            result = new Day4().countValidPassports(values, mandatoryFields, optionalFields);
        });

        When("I have {string} and {string} with validation", (String mandatory, String optional) -> {
            Set<String> mandatoryFields = Arrays.stream(mandatory.split(","))
                    .collect(Collectors.toSet());
            Set<String> optionalFields = Arrays.stream(optional.split(","))
                    .collect(Collectors.toSet());

            result = new Day4().countValidPassportsWithValidation(values, mandatoryFields, optionalFields);
        });

        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
