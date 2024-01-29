package tp;

public class EnglishToSpanishTranslator extends AbstractBasicTranslator {
	
	public EnglishToSpanishTranslator() {
		super("english","spanish");
		this.addTranslationEntry("hello", "buenos dias");
	}
	
	@Override
	public void initFromJavaCode() {
		// ajouter directement quelques entrées en s'appuyant sur .translationMap
		// déclarée "protected" dans la super classe "AbstractBasicTranslator"
		
	}

}
