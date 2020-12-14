package day7;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/day7/day7.feature"},
        glue = "day7",
        plugin = {"pretty", "json:target/reports/json/day7.json"}
)
public class Day7Test {
}