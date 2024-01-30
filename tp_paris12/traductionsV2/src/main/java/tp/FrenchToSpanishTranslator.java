package tp;

public class FrenchToSpanishTranslator  implements WordTranslator {
	
	private EnglishToSpanishTranslator englishToSpanishTranslator = new EnglishToSpanishTranslator();
	private EnglishToFrenchTranslator englishToFrenchTranslator = new EnglishToFrenchTranslator();

	public FrenchToSpanishTranslator() {
		englishToSpanishTranslator.loadFromFile();
		englishToFrenchTranslator.loadFromFile();
	}
	
	
	@Override
	public String translate(String frenchWord) {
		String englishTranslation = englishToFrenchTranslator.translateInverse(frenchWord);
		return englishToSpanishTranslator.translate(englishTranslation);
	}

	@Override
	public String translateInverse(String spanishWord) {
		String englishTranslation = englishToSpanishTranslator.translateInverse(spanishWord);
		return englishToFrenchTranslator.translate(englishTranslation);
	}



}
