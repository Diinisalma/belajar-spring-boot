## Web App using Spring Boot and Thymeleaf
This project is a web application using Spring Boot, Thymeleaf and TailwindCSS.

## Tech Stack
 - Spring Boot v3.4.4
 - Thymeleaf
 - TailwindCSS v4.1.4

## Prerequisite
 - Java v21
 - NodeJS >= v23.6.0

## Installation

 1. Install maven dependencies
```bash
mvn clean install
```
2. Go to folder `src/main/frontend` and install TailwindCSS
```bash
npm i
```
3. Build css file
```bash
npm run watch
```
4. Start the web app
```bash
mvn spring-boot:run
```

## Build Project
```bash
mvn clean package
```
