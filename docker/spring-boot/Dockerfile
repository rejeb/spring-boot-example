FROM ci.docapost.io/java:latest

RUN chown -R newtprod.prod /USR/newtprod/

RUN chown -R newtprod.prod /VAR/newtprod/

VOLUME /USR/newtprod


USER newtprod

CMD ["/USR/newtprod/spring_boot.py"]
