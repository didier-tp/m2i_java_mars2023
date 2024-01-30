package tp;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;

public abstract class AbstractBasicTranslator implements WordTranslatorWithEntry  {
	protected String sourceLanguage;//ex: "english"
	protected String targetLanguage;//ex: "french"
	protected Map<String , String> translationMap = new HashMap<>(); //key=mot_a_traduire , value=traduction
	
	public AbstractBasicTranslator(String sourceLanguage, String targetLanguage) {
		this.sourceLanguage = sourceLanguage;
		this.targetLanguage = targetLanguage;
	}
	
	
	@Override
	public String toString() {
		return "Translator [sourceLanguage=" + sourceLanguage + ", targetLanguage=" + targetLanguage + "]";
	}


	@Override
	public void loadFromFile() {
		String resourceFileName=this.sourceLanguage+ "_to_" + this.targetLanguage + ".properties";
		//exemple "english_to_french.properties";
		
		InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(resourceFileName);
		Properties props=new Properties();
		try {
			props.load(is);
			for(Object key : props.keySet()) {
				String word= (String) key;
				translationMap.put(word, props.getProperty(word));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}


	public AbstractBasicTranslator() {
	}
	
	@Override
	public void addTranslationEntry(String word, String translation) {
		this.translationMap.put(word, translation);
	}

	@Override
	public String translate(String word) {
		return this.translationMap.get(word);
	}

	@Override
	public String translateInverse(String translatedWord) {
		String invTranslation = null;
		for( Entry<String,String> entry : this.translationMap.entrySet()) {
			if(entry.getValue().equals(translatedWord)) {
				invTranslation=entry.getKey();
				break;
			}
		}
		return invTranslation;
	}

	public String getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(String sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	public String getTargetLanguage() {
		return targetLanguage;
	}

	public void setTargetLanguage(String targetLanguage) {
		this.targetLanguage = targetLanguage;
	}

	public Map<String, String> getTranslationMap() {
		return translationMap;
	}

	public void setTranslationMap(Map<String, String> translationMap) {
		this.translationMap = translationMap;
	}
	
	
	
}
