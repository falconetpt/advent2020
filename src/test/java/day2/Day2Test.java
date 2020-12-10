package day2;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/day2/day2.feature"},
        glue = "day2",
        plugin = {"pretty", "json:target/reports/json/day2.json"}
)
public class Day2Test {
}