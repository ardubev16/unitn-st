ARG tomcat_ver=9.0.46
FROM tomcat:${tomcat_ver} AS build

WORKDIR /tmp/build

COPY ./src/main ./
RUN find ./java -name '*.java' > sources.txt \
    && javac --release 11 -cp /usr/local/tomcat/lib/servlet-api.jar -d ./webapp/WEB-INF/classes @sources.txt \
    && cd ./webapp \
    && jar -cvf /Tourism.war ./*


FROM tomcat:${tomcat_ver} AS run

COPY --from=build /Tourism.war /usr/local/tomcat/webapps/Tourism.war

CMD  ["catalina.sh", "run"]
