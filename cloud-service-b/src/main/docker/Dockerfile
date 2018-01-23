FROM shuaicj/java:8.131.11
VOLUME /tmp
ADD cloud-service-b-1.0.0.jar app.jar
ADD start-after-config.sh .
ADD start.sh .
RUN touch app.jar
