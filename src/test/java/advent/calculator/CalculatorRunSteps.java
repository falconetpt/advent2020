package advent.calculator;

import io.cucumber.java8.En;

import static org.junit.Assert.assertEquals;


public class CalculatorRunSteps implements En {
    private int total;

    private Calculator calculator;

    public CalculatorRunSteps() {
        total = -999;
        Given("I have a calculator", () -> calculator = new Calculator() );
        When("I add {int} and {int}", (a, b) -> total = (int) a + (int) b );
        Then("the result should be {int}", (a) -> assertEquals(total, (int) a) );
    }
}
