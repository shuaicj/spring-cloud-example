FROM shuaicj/java:8.131.11
VOLUME /tmp
ADD cloud-config-1.0.0.jar app.jar
ADD start-after-registry.sh .
ADD start.sh .
RUN touch app.jar
