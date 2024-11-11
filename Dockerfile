ARG tomcat_ver=9.0.46
FROM tomcat:${tomcat_ver} AS builder

WORKDIR /tmp/build

COPY ./src/main ./
RUN find ./java -name '*.java' > sources.txt \
    && javac --release 11 -cp ./webapp/WEB-INF/lib/javax.servlet-api-4.0.1.jar -d ./webapp/WEB-INF/classes @sources.txt \
    && cd ./webapp \
    && jar -cvf /Tourism.war ./*


FROM tomcat:${tomcat_ver} AS runner

COPY --from=builder /Tourism.war /usr/local/tomcat/webapps/Tourism.war

CMD  ["catalina.sh", "run"]
