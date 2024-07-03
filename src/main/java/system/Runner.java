package system;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

// features = {"features"} - Dessa forma ele encontra a pasta features
// glue = {"eteps"} - Dessa forma ele encontra a pasta steps
@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"pretty", "html:Reporter/reporter.html"},
        features = {"features"},
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        glue = {"steps"}
)
public class Runner {
}