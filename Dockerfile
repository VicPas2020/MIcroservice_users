#FROM openjdk:11
#RUN mkdir /app
#COPY users.jar /app
#EXPOSE 8080
#WORKDIR /app
#CMD java -jar users.jar

# ИЛИ / ИЛИ - не работают оба.

FROM openjdk:11
ADD ./users.jar backend.jar
ENTRYPOINT ["java", "-jar", "backend.jar"]