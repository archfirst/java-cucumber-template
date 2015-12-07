# Java Cucumber Template
This template provides a starter project for acceptance testing of RESTful applications. The example provided tests the companion project [Java REST Template](https://github.com/archfirst/java-rest-template).

This template uses BDD and [Specification-by-Example](http://specificationbyexample.com/) techniques for documenting application features. [Cucumber-JVM](https://github.com/cucumber/cucumber-jvm) is used for automated testing.

## Quick Start
To run the tests, first start the Java REST Template application mentioned above in a separate shell. Then run the tests by executing `mvn test` in this folder.

## Package Structure

The example feature (`accounts.feature`) is located at src/test/resources/org/archfirst/template. The Java package structure is as follows

```
org.archfirst.template
    steps
    services
    domain
```

- The `template` package contains the Cucumber test runner called `RunCukesTest`.

- The `steps` package contains the Cucumber step definitions associated with the scenarios in the feature files.

- The `services` folder encapsulates the low-level details of accessing the server API. Step definitions use these services to make request to the server. This keeps the step definitions at a high level and very readable.

- The `domain` package contains domain entities that are exchanged with the server.