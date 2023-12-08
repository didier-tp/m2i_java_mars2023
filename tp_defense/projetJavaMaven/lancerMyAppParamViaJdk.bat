REM set JAVA_HOME=C:\Program Files\Java\jdk-17
set JAVA_HOME=C:\prog\eclipse\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.8.v20230831-1047\jre
set PATH=%JAVA_HOME%\bin
cd "%~dp0"
cd target
java -classpath projetJavaMaven.jar tp.demo.MyParamApp 5 6 >ficRes.txt
java -classpath projetJavaMaven.jar -Ddetails=true tp.demo.MyParamApp 5 6
pause