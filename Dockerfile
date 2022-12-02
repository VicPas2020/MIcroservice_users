#FROM openjdk:11
#RUN mkdir /app
#COPY users.jar /app
#EXPOSE 8080
#WORKDIR /app
#CMD java -jar users.jar

# ИЛИ / ИЛИ - не работают оба.

FROM openjdk:11
ADD 'build/libs/users -0.0.1-SNAPSHOT.jar' backend.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "backend.jar"]