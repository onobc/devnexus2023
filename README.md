# Introducing Spring for Apache Pulsar 

## Live Demo - User Registration 

This is a simple Spring for Apache Pulsar application that takes a simple produce/consume use case through the following:
- Imperative produce/consume (user to/from user-topic)
- Improve the above usage w/ topic detection and config props
- Reactive produce/consume (single)
- Reactive produce/consume (stream)
- Add Spring Cloud Stream binder to process messages

There is a commit for each of the above steps. 

### Appears In
This demo was used in the following:
- DevNexus 2023 for [Introducing Spring for Apache Pulsar](https://devnexus.com/presentations/introducing-spring-for-apache-pulsar/)
- Pulsar Summit 2023 [Introducing Spring for Apache Pulsar](https://pulsar-summit.org/event/europe-2023/sessions/europe-2023-introducing-spring-for-apache-pulsar)


### GraalVM Native Image
#### Native Build Tools
To build a native image using the GraalVM native build tools, follow [these pre-requisites](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#native-image.developing-your-first-application.native-build-tools) 
to install GraalVM on your machine, but choose `22.3.1.r17-grl` as the version.

> **_WARNING:_**  If you don't choose `22.3.1.r17-grl` as the version you will run into `Fatal error: java.lang.TypeNotPresentException: Type com.google.protobuf.GeneratedMessageV3 not present` when compiling.

Compile the demo into a GraalVM native image with:
```shell
./gradlew nativeCompile
```
Then you can run the native image with:
```shell
./build/native/nativeCompile/intro-spring-pulsar-demo
```
You will see a huge improvement in startup time.

#### Paketo Buildpacks
If you prefer, you can instead use Paketo buildpacks to build the image by following [these steps](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#native-image.developing-your-first-application.buildpacks).
