javac -d . Framework/src/*.java

jar -cf TestFramework/WEB-INF/lib//etu1835fw.jar etu1835


copy Testframework/lib/etu1835fw.jar Testframework/WEB-INF/classes/lib

javac -cp  Testframework/WEB-INF/lib/etu1835fw.jar -d TestFramework/WEB-INF/classes TestFramework/WEB-INF/src/*.java

jar cvf etu1835fw.war -C  TestFramework .

copy etu1835fw.war  C:\Program Files\Apache Software Foundation\Tomcat 10.1\webapps
                                                                                                                  a                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           

