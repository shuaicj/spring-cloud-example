FROM shuaicj/java:8.131.11
VOLUME /tmp
ADD cloud-service-b-1.0.0.jar app.jar
RUN sh -c 'touch /app.jar'
ENTRYPOINT [ "java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app.jar" ]