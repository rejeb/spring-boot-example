FROM lwieske/java-8:jdk-8u152


VOLUME /USR/newtprod

VOLUME /USR/newtprod/spring-boot-example/conf

VOLUME /USR/newtprod/spring-boot-example/jars

COPY src/main/resources/application-dev.properties /USR/newtprod/spring-boot-example/conf/application.properties

COPY src/main/resources/logback-dev.xml /USR/newtprod/spring-boot-example/conf/logback.xml

COPY target/spring-boot-example-api-1.0-SNAPSHOT-fat-exec.jar /USR/newtprod/spring-boot-example/jars/spring-boot-example-api-1.0-SNAPSHOT-fat-exec.jar

EXPOSE 10104

ENTRYPOINT ["java","-Xmx256m", "-cp", "/USR/newtprod/spring-boot-example/jars/*:/USR/newtprod/spring-boot-example/conf", "org.springframework.boot.loader.JarLauncher"]


