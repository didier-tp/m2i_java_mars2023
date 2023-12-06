REM set JAVA_HOME=C:\Program Files\Java\jdk-17
set JAVA_HOME=C:\prog\eclipse\plugins\org.eclipse.justj.openjdk.hotspot.jre.full.win32.x86_64_17.0.8.v20230831-1047\jre
set PATH=%JAVA_HOME%\bin
cd "%~dp0"
cd target
REM avec .jar comportant META-INF/Manifest.mf et main-class to launch
java -jar projetJavaMaven.jar
pause