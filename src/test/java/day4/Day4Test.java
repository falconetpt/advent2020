package day4;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"classpath:features/day4/day4.feature"},
        glue = "day4",
        plugin = {"pretty", "json:target/reports/json/day4.json"}
)
public class Day4Test {
}