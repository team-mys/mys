FROM openjdk:17-jdk-slim

WORKDIR /app

# Gradle Wrapper 복사
COPY gradlew .
COPY gradle gradle
COPY build.gradle .
COPY src src
# 빌드 실행
RUN chmod +x gradlew && ./gradlew build

# JAR 파일 복사
COPY build/libs/*.jar app.jar

# 포트 노출
EXPOSE 8080

# 실행
ENTRYPOINT ["java", "-jar", "app.jar"]