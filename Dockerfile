FROM openjdk:11
RUN mkdir /app
COPY build/libs/users-1.0.0-SNAPSHOT.jar /app
EXPOSE 8080
WORKDIR /app
CMD java -jar users-1.0.0-SNAPSHOT.jar

# ИЛИ / ИЛИ - работают оба.
# НЕ УДАЛЯТЬ!

#FROM openjdk:11
#ADD "build/libs/users.jar" backend.jar
#EXPOSE 8080
#ENTRYPOINT ["java", "-jar", "backend.jar"]