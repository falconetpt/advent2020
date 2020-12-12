package day5;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/day5/day5.feature"},
        glue = "day5",
        plugin = {"pretty", "json:target/reports/json/day5.json"}
)
public class Day5Test {
}