package runners;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectFile;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")
@SelectFile("target/failedRerun.txt")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "step_definitions, hooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty," +
                "html:target/failed-html-report.html," +
                "json:target/failed.json"
)
public class AmazonFailedTestRunner {
}
