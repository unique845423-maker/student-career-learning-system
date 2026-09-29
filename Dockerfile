FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY build/libs/careerlearning-0.0.1-SNAPSHOT.jar /app/app.jar

EXPOSE 10000

CMD ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT:-10000}"]