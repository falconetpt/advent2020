package day9;

import advent.day9.Day9;
import io.cucumber.java8.En;
import utils.ReadFile;

import java.math.BigInteger;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;


public class Day9Step implements En {
    private List<BigInteger> values;
    private int result;

    public Day9Step() {
        Given("I have a {string}", (String string) -> values = ReadFile.readFile(string)
                .map(BigInteger::new)
                .collect(Collectors.toList())
        );


        When("I calculate the value of {int} and {int}", (Integer preambule, Integer index) -> {
            result = new Day9().getFirstError(values, preambule, index);
        });

        When("I calculate the value of {int} with sum", (Integer preambule) -> {
            result = new Day9().getFirstErrorWithRangeSum(values, preambule, preambule);
        });

        Then("the result should be {int}", (a) -> assertEquals(a, result) );
    }
}
