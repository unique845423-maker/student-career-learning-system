FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew clean bootJar -x test

EXPOSE 10000

CMD ["java", "-jar", "build/libs/careerlearning-0.0.1-SNAPSHOT.jar"]