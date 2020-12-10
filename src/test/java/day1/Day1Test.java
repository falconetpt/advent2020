package day1;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/day1/day1.feature"},
        glue = "day1",
        plugin = {"pretty", "json:target/reports/json/day1.json"}
)
public class Day1Test {
}