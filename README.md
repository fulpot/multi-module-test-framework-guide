# Fulpot Multi-Module Test Automation

This repository is a simple example for a multi-module Maven project with UI test suites implemented using Cucumber and JUnit 5. Tests are grouped by application target and share utilities from a common module.

## Modules overview

- `amazon-module/` — tests and JUnit 5/Cucumber runners for Amazon scenarios
- `google-module/` — tests and JUnit 5/Cucumber runners for Google scenarios
- `common-utility-module/` — shared test utilities, drivers and helpers

Reports and artifacts are generated under each module's `target/` directory (for example: `target/cucumber-reports.html`, `target/json-reports/cucumber.json` and `target/test-output/SparkReport/Spark.html`).

## Prerequisites

- Java 11
- Maven 3.6+
- Internet access to download dependencies

## JUnit 5 + Cucumber — key points

This project uses the JUnit Platform (JUnit 5) with the Cucumber JUnit Platform engine. Make sure each module's `pom.xml` contains at least the following test dependencies:

```xml
<dependency>
  <groupId>io.cucumber</groupId>
  <artifactId>cucumber-junit-platform-engine</artifactId>
  <scope>test</scope>
</dependency>
<dependency>
  <groupId>org.junit.jupiter</groupId>
  <artifactId>junit-jupiter</artifactId>
  <scope>test</scope>
</dependency>
```

## Running tests — single module, multiple modules, and runner classes

From the project root you can:

- Run all modules:

```bash
mvn test
```

- Run a single module (builds required modules with `-am`):

```bash
mvn -pl amazon-module -am test
```

- Run multiple modules in one Maven invocation:

```bash
mvn -pl amazon-module,google-module -am test
```

- Run a specific runner class (these runner classes exist in the repo):

```bash
# Amazon runner
mvn -Dtest=AmazonCukesRunner test -pl amazon-module -am

# Google runner
mvn -Dtest=GoogleCukesRunner test -pl google-module -am
```

- Run with Cucumber tag filtering:

Tag filtering first muss not hard-coded in Runner class like:

```java
@ConfigurationParameter(key = FILTER_TAGS_PROPERTY_NAME, value = "@wip")
```

so CLI / system properties such as -Dcucumber.filter.tags="@smoke" can be used at runtime.

```bash
mvn -pl google-module -am test -Dcucumber.filter.tags="@smoke"
```

Notes:

- `-pl` selects modules; `-am` builds dependencies required by those modules.
- Running multiple modules in a single reactor invocation is recommended for CI because shared modules are built once.

## Runner classes (where to find them)

- `amazon-module/src/test/java/runners/AmazonCukesRunner.java`
- `google-module/src/test/java/runners/GoogleCukesRunner.java`

Both are JUnit Platform suite classes that include Cucumber engine and set configuration parameters (glue, plugins, tags) with `@ConfigurationParameter`.

## Reports

Common report files after a run:

- `target/cucumber-reports.html`
- `target/json-reports/cucumber.json`
- `target/xml-reports/cucumber.xml`
- `target/test-output/SparkReport/Spark.html`

## Example GitHub Actions workflow

An example workflow has been added at `.github/workflows/ci.yml` (parallel jobs: one per module). It:

- runs each module's tests in parallel jobs
- sets up JDK 11 and caches Maven dependencies
- uploads module-specific report artifacts for inspection

You can extend it to publish combined reports or push HTML results to GitHub Pages.

## Configuration files

- Module-level `configuration.properties` files are present in `amazon-module/` and `google-module/` for environment-specific values.
- Cucumber properties like `cucumber.publish.enabled` appear under `src/test/resources/`.
