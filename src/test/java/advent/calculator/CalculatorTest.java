package advent.calculator;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/calculator.feature"},
        glue = "advent",
        plugin = {"pretty", "json:target/reports/json/calculator.json"}
)
public class CalculatorTest {
}