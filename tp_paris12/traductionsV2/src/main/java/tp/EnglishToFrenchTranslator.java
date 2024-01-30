package tp;

public class EnglishToFrenchTranslator extends AbstractBasicTranslator {
	
	public EnglishToFrenchTranslator() {
		super("english","french");
		this.addTranslationEntry("hello", "bonjour");
	}

	@Override
	public void initFromJavaCode() {
		// ajouter directement quelques entrées en s'appuyant sur .translationMap
		// déclarée "protected" dans la super classe "AbstractBasicTranslator"
		this.translationMap.put("green", "vert");
		this.translationMap.put("red", "rouge");
	}

}
