package day8;

import advent.day7.Day7;
import advent.day8.Day8;
import advent.day8.command.Command;
import advent.day8.command.CommandFactory;
import io.cucumber.java8.En;
import utils.ReadFile;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class Day8Step implements En {
    private List<Command> values;
    private int result;

    public Day8Step() {
        Given("I have a {string}", (String string) -> values = ReadFile.readFile(string)
                .map(CommandFactory::createCommand)
                .collect(Collectors.toList())
        );

        When("I calculate the value of accumulator", () -> result = new Day8().calculateAccumulator(values));

        When("I calculate the value of accumulator with nop and jmp swapped", () -> {
            result = new Day8().calculateAccumulatorWithSwaps(values);
        });

        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
