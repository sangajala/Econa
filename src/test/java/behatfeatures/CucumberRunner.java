
package behatfeatures;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"html:target/HomePageReport"},
        features = "src/test/resources/behatfeatures/HomePage.feature"
                )
public class CucumberRunner {
}