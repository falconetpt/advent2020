package day9;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/day9/day9.feature"},
        glue = "day9",
        plugin = {"pretty", "json:target/reports/json/day9.json"}
)
public class Day9Test {
}