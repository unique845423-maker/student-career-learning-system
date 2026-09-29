FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew

RUN ./gradlew clean bootJar -x test

RUN cp build/libs/careerlearning-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 10000

CMD ["java", "-jar", "/app/app.jar"]