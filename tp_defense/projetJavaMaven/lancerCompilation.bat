REM set JAVA_HOME=C:\Program Files\Java\jdk-17
set JAVA_HOME=C:\prog\eclipse\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.8.v20230831-1047\jre
set PATH=%JAVA_HOME%\bin
cd "%~dp0"
REM cd src/main/java
cd src
REM javac -d ../../../bin tp/MyApp.java
javac -d ../bin tp/MyApp.java
pause