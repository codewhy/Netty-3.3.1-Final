PROJECT_CP="."
for aJar in  `ls target/dependency`
do	
    PROJECT_CP="target/dependency/$aJar:$PROJECT_CP"
done
LIBS="-classpath target/classes:$PROJECT_CP"
MAIN_CLASS="org.jboss.netty.example.echo.EchoServer"
LOG_CONFIG="-Dlog4j.configuration=file:./log4j.properties"
java $LIBS $MAIN_CLASS $@ 
