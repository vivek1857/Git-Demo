package gov.uk.dvla.features;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * The Class CucumberConfiguration.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {
                "json:target/cucumber/testResutls.json",
                "html:target/cucumber/testResutls.html",
                "pretty"
        },
        tags = {"~@ignored"}
)
public class CucumberConfiguration {
}