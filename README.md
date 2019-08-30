# Serenity BDD Sample Project

This project is an example of implemented Behavior Driver Development, using Cucumber and Selenium for 
natural language acceptance testing.

### SerenityBDD 

This project is built using the [SerenityBDD](https://github.com/serenity-bdd/serenity-core) framework.

## Execute the Tests

__WARNING:__ Webdrivers executable only on PC, optimized for Windows 10. To use another operating system, please 
download a compatible webdriver from the [Selenium resource page](https://www.seleniumhq.org/download/).

### Run Serenity Project with Gradlew

	gradlew clean test

To run with a webdriver other than Chrome, pass the desired driver as an environment variable.

    gradlew clean test -Dwebriver.driver=firefox

To run headless, pass `headless.mode=true` as an environment variable.

    gradlew clean test -Dheadless.mode=true

### Viewing the Report

A report with 100% passing tests and screenshots has been commited with source code and can be viewed at :

    bdd-code-sample\target\site\serenity\index.html

After running the project with `gradlew clean test`, to view the results in a new report :

    gradlew aggregate

The report including screenshots can now be viewed at :

    bdd-code-sample\target\site\serenity\index.html