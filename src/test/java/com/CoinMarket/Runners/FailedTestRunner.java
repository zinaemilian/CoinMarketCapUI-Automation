package com.CoinMarket.Runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        glue = "com/CoinMarket/Step_Definitions",
        features = "@target/rerun.txt"
)
public class FailedTestRunner {
}
