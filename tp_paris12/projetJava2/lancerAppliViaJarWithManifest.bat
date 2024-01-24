REM set JAVA_HOME=C:\Program Files\java\jdk17
set JAVA_HOME=C:\temp_java\java\eclipse-jee-2023-12-R-win32-x86_64\eclipse\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.9.v20231028-0858\jre
set PATH=%JAVA_HOME%\bin
cd "%~dp0"
cd target
java -jar projetJava2.jar
pause