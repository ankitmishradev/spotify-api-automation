# Spotify API Automation Testing Project

## Overview

This project is a comprehensive framework for API automation testing, primarily targeting Spotify's API. The project uses
Java, TestNG, RestAssured, and Allure Reports to facilitate  testing and detailed reporting. The key features of
this project include parameterized tests, data-driven testing, serialization and deserialization of test data using
Jackson, and comprehensive test reporting with Allure.

## Table of Contents

1. [Prerequisites](#prerequisites)
2. [Dependencies](#dependencies)
3. [key Directories](#key-directories)
2. [Setup](#setup)
3. [Configuration](#configuration)
4. [Test Execution](#test-execution)
5. [Models](#models)
6. [Test Data Management](#test-data-management)
7. [Contribution](#contribution)
8. [License](#license)

## Prerequisites

- Java 11
- Maven
- Git

## Dependencies
The project leverages several dependencies defined in the pom.xml file:

- TestNG: Test framework for running tests.
- RestAssured: Library for testing REST APIs.
- Allure: Plugin for generating Allure reports.
- Jackson: Library for JSON processing.

## Key Directories
- `src/main/java/apis`: Contains the spotify APIs files.
- `src/main/java/models`: Contains the models for spotify object (i.e. Album, Playlist).
- `src/test/java/tests`: Contains the test cases.
- `src/test/resources/testdata`: Contains the test data files in JSON format.

## Setup

1. Clone the repository:
    ```sh
    git clone https://github.com/ankitmishradev/spotify-api-automation.git
    cd spotify-api-automation
    ```

2. Install dependencies:
    ```sh
    mvn install
    ```

## Configuration

- **Spotify API Setup**: Configure your Spotify account and API authorization. Visit their [API Documentation](https://developer.spotify.com/documentation/web-api).
- **Update Project Configuration**: Replace the placeholder in `src/test/resources/config.properties` with your Spotify API credentials.

## Test Execution

To run the tests, execute the following command:

```sh
mvn test
```

## Models
I use Jackson to serialize and deserialize the test data. The models/POJOs are defined in the `src/main/java/models` directory. [jsonschema2pojo](https://www.jsonschema2pojo.org/) can be leveraged to create the Models/POJOs. A typically Model should look like following:
```java

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"property"})

public class XYZ {

   @JsonProperty("property")
   private String property;
    
   //Other properties
   
   @JsonProperty("property")
   public String getProperty() {
      return albumType;
   }

   @JsonProperty("property")
   public void setProperty(String property) {
      this.property = albumType;
   }
   
   //Getter and setter of other properties
   
   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || getClass() != o.getClass()) return false;
      XYZ object = (XYZ) o;
      return Objects.equals(property, object.property);
   }

   @Override
   public int hashCode() {
      return Objects.hash(property);
   }
}
```
It is important to generate the `equals` and `hashCode` methods in these classes for assertion to work.

## Test Data Management
The test data is managed using JSON files which are placed in the `src/test/resources/testdata` directory. The test data file name must be same as the test case class name. For example, test data for tests in `UserTests` class should be stored in `UserTests.json` file. The JSON files follow this template format:

```json
{
  "data": {
    "testDataName": {
      "request": {
        ...
      },
      "response": {
        ...
      }
    }
  }
}
```

## Contribution
Contributions to this project are most welcomed.

If you find bugs or want more features, but don't know how to fix/implement them, please fill an issue.

If you fixed bugs or implemented new features, please send a pull request.

## License
This project is licensed under the MIT License. See the LICENSE file for more details.