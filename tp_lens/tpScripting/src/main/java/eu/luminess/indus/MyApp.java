package eu.luminess.indus;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;

public class MyApp {
    public static void main(String[] args) {
        System.out.println("tpScripting ...");
        testJavascriptEval("print('Hello, World')");
        try {
            String scriptFileName="f1.js";
            //String scriptFileName="f2.js";
            testJavascriptEvalScript(new FileReader(scriptFileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void testJavascriptEval(String script){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        /*
        NB: "nashorn" est le moteur javascript de référence .
        il s'intègre dans pom.xml via la dépendance suivante:
        https://mvnrepository.com/artifact/org.openjdk.nashorn/nashorn-core
        */

        // evaluate JavaScript code
        try {
            engine.eval(script);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }

    public static void testJavascriptEvalScript(FileReader scriptFileReader){
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        try {
            engine.eval(scriptFileReader);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
    }


}
