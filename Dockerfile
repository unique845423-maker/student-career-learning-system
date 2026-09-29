FROM eclipse-temurin:21-jdk

WORKDIR /app

COPY . .

RUN chmod +x gradlew
RUN ./gradlew clean bootJar -x test --no-daemon

RUN JAR=$(find build/libs -name "*.jar" ! -name "*plain.jar" | head -n 1) && cp "$JAR" /app/app.jar

EXPOSE 10000

CMD ["sh", "-c", "java -jar /app/app.jar --server.port=${PORT:-10000}"]