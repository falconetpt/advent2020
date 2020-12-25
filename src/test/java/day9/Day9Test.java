package day8;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/day8/day8.feature"},
        glue = "day8",
        plugin = {"pretty", "json:target/reports/json/day8.json"}
)
public class Day8Test {
}