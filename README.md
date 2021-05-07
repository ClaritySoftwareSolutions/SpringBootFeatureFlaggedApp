# Spring Boot Feature Flagged App
Simple Spring Boot app that demonstrates the use of [FF4j](https://ff4j.org) for feature flagging.

## Web Endpoints
* `/helloWorld`
Uses if/else logic in code with the FF4j API to drive runtime behaviour
* `/helloWorldFromService`
Uses FF4j annotations to inject the correct service bean implementation at runtime

### FF4j Endpoints
* `/ff4j-web-console`
The FF4j web console to explore and manage feature flags and properties
* `/api/ff4j`
The FF4j REST API to explore and manage feature flags and properties
