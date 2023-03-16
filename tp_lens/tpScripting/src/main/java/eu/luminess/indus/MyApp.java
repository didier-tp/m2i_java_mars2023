package eu.luminess.indus;

import javax.script.Bindings;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class MyApp {
    public static void main(String[] args) {
        System.out.println("tpScripting ...");
        testJavascriptEval("print('Hello, World')");
        try {
            String scriptFileName="f1.js";
            testJavascriptEvalScript(new FileReader(scriptFileName),null);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String scriptFileName="f2.js";
            Map<String,Object> map = new HashMap<>();
            map.put("x",5); map.put("y",7);
            Object result = testJavascriptEvalScript(new FileReader(scriptFileName),map);
            System.out.println("via javascript, z="+map.get("z") + " result="+result);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        try {
            String scriptFileName="f2.groovy";
            Map<String,Object> map = new HashMap<>();
            map.put("x",5); map.put("y",7); map.put("calcul" , new Calcul(81.0));
            Object result = testGroovyEvalScript(new FileReader(scriptFileName),map);
            System.out.println("via groovy, z="+map.get("z") + ", calcul.res=" + ((Calcul)map.get("calcul")).getRes() + " , result="+result);
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

    public static Object testJavascriptEvalScript(FileReader scriptFileReader , Map<String,Object> map){
        Object result = null;
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");

        try {
            if(map!=null){
                Bindings bindings = engine.createBindings();
                bindings.putAll(map);
                result = engine.eval(scriptFileReader,bindings);
                for(String key : bindings.keySet()){
                    map.put(key , bindings.get(key));
                }
            }else{
               result = engine.eval(scriptFileReader);
            }

        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }

    public static Object testGroovyEvalScript(FileReader scriptFileReader , Map<String,Object> map){
        Object result = null;
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("groovy");
        //avec dans pom.xml org.codehaus.groovy / groovy-jsr223 / 3.0.15

        try {
            if(map!=null){
                Bindings bindings = engine.createBindings();
                bindings.putAll(map);
                result = engine.eval(scriptFileReader,bindings);
                for(String key : bindings.keySet()){
                    map.put(key , bindings.get(key));
                }
            }else{
                result = engine.eval(scriptFileReader);
            }

        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }


}
