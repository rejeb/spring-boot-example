FROM ci.docapost.io/java:latest

RUN chown -R newtprod.prod /USR/newtprod/

RUN chown -R newtprod.prod /VAR/newtprod/

USER newtprod

VOLUME /USR/newtprod

VOLUME /USR/newtprod/spring-boot-example/conf

VOLUME /USR/newtprod/spring-boot-example/jars

COPY src/main/resources/application-dev.properties /USR/newtprod/spring-boot-example/conf/application.properties

COPY src/main/resources/logback-dev.xml /USR/newtprod/spring-boot-example/conf/logback.xml

COPY target/spring-boot-example-api-1.0-SNAPSHOT-exec.jar /USR/newtprod/spring-boot-example/jars/spring-boot-example-api-1.0-SNAPSHOT-exec.jar

EXPOSE 10104

ENTRYPOINT ["java", "-cp", "/USR/newtprod/spring-boot-example/jars/*:/USR/newtprod/spring-boot-example/conf", "org.springframework.boot.loader.JarLauncher"]


