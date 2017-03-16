# warGame

## Building

Gradle requires a Java JDK or JRE to be installed, version 7 or higher (to check, use java -version). 

Gradle builds itself with Gradle. Gradle provides an innovative [wrapper](https://gradle.org/docs/current/userguide/gradle_wrapper.html) that allows you to work with a Gradle build without having to manually install Gradle. The wrapper is a batch script on Windows and a shell script on other operating systems.

You should use the wrapper to build the gradle project. Generally, you should use the wrapper for any wrapper-enabled project because it guarantees building with the Gradle version that the build was intended to use.

To build the entire Gradle project, you should run the following in the root of the checkout.

    gradlew build

This will compile all the code and run all the tests.

## Running
In the build directory created by the gradle build, there should be a jarfile.  Run the jarfile and pass the number of players on the command line. 
e.g., 

    java -jar build\libs\wargame-1.0-3.jar 4
