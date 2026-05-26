# RetoTecnicoAutoStrange / QA REST Screenplay Challenge

Realizar el reto del equipo Strange. Este reto técnico busca evaluar las habilidades de automatización de pruebas para servicios REST, utilizando el framework Serenity BDD y el patrón de diseño Screenplay.

## Directory Structure

- `src/main/java/com/challenge/interactions/api/`: Base API interactions (Get, Post, Put, Delete).
- `src/main/java/com/challenge/tasks/`: Screenplay Tasks.
- `src/main/java/com/challenge/questions/`: Screenplay Questions.
- `src/main/java/com/challenge/models/request/`: Request POJOs.
- `src/main/java/com/challenge/models/response/`: Response POJOs.
- `src/main/java/com/challenge/utils/`: Constants and Configuration utilities.
- `src/test/resources/`: Serenity configurations.

## Running Tests

Use the Gradle wrapper to run tests:
```bash
./gradlew clean test
```
## Run with Cucumber
```bash
./gradlew test --tests "**/UpdateUserFeature.feature"
``` 

## For run a test in specific use: 
```bash
./gradlew clean test -Dcucumber.filter.tags="@VerifyDataUser" aggregate
./gradlew clean test -Dcucumber.filter.tags="@UpdateUserSuccessfully" aggregate
./gradlew clean test -Dcucumber.filter.tags="@DeleteDataUserSuccessfully" aggregate
./gradlew clean test -Dcucumber.filter.tags="@CreateUserSuccessfully" aggregate


## To run all tests use the command:
```bash
./gradlew clean test aggregate
```
## To run all tests use the command:
```bash
./gradlew clean test aggregate
```

to see the results of the tests use the command:
```bash
open target/site/serenity/index.html
```