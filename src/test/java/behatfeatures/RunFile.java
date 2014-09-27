package behatfeatures;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;
import utils.Hooks;

/**
 * Created by sriramangajala on 27/09/2014.
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        format = {"html:target/HomePageReport"},
        features = "src/test/resources/behatfeatures/Search.feature"
)
public class RunFile extends Hooks {
}
