package day6;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/day6/day6.feature"},
        glue = "day6",
        plugin = {"pretty", "json:target/reports/json/day6.json"}
)
public class Day6Test {
}