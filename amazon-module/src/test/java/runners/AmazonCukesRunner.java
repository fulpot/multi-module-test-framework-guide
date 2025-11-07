package runners;


import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

import static io.cucumber.junit.platform.engine.Constants.*;



@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "step_definitions, hooks")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "pretty," +
                "html:target/cucumber-reports.html," +
                "json:target/json-reports/cucumber.json," +
                "junit:target/xml-reports/cucumber.xml," +
                "rerun:target/failedRerun.txt," +
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
)
@ConfigurationParameter(key = EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@wip")
public class AmazonCukesRunner {
}