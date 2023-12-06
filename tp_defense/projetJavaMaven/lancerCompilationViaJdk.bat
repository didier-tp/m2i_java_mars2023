REM set JAVA_HOME=C:\Program Files\Java\jdk-17
set JAVA_HOME=C:\prog\eclipse\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.8.v20230831-1047\jre
set PATH=%JAVA_HOME%\bin
cd "%~dp0"
cd src/main/java
javac -d ../../../target/classes tp/MyAppBis.java
pause