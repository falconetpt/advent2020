package day7;

import advent.day7.Day7;
import io.cucumber.java8.En;
import utils.ReadFile;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class Day7Step implements En {
    private List<String> values;
    private int result;

    public Day7Step() {
        Given("I have a {string}", (String string) -> {
            values = ReadFile.readFile(string).collect(Collectors.toList());
        });

        When("I calculate the number of shiny gold", () -> result = new Day7().countShinyGoldBad(values));

        When("I calculate the number of total bags in shiny gold", () -> {
            result = new Day7().countShinyAllGoldBad(values);
        });

        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
