package day3;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/day3/day3.feature"},
        glue = "day3",
        plugin = {"pretty", "json:target/reports/json/day3.json"}
)
public class Day3Test {
}