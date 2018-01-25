FROM ci.docapost.io/java:latest

VOLUME /USR/newtprod

VOLUME /USR/newtprod/spring-boot-example/conf

VOLUME /USR/newtprod/spring-boot-example/jars

COPY ./application-dev.properties /USR/newtprod/spring-boot-example/conf/application.properties

COPY ./logback-dev.xml /USR/newtprod/spring-boot-example/conf/logback.xml

COPY ./spring-boot-example-api-1.0-SNAPSHOT-exec.jar /USR/newtprod/spring-boot-example/jars/spring-boot-example-api-1.0-SNAPSHOT-exec.jar


CMD ["java", "-cp", "/USR/newtprod/spring-boot-example/jars/*:/USR/newtprod/spring-boot-example/conf", "org.springframework.boot.loader.JarLauncher"]

EXPOSE 10104:10104
