package tp;

public class MyApp {

	public static void main(String[] args) {
		System.out.println("traductions");
		WordTranslatorWithEntry englishToFrenchTranslator = new EnglishToFrenchTranslator();
		//englishToFrenchTranslator.initFromJavaCode();
        englishToFrenchTranslator.loadFromFile();
		
		WordTranslatorWithEntry englishToSpanishTranslator = new EnglishToSpanishTranslator();
		//englishToSpanishTranslator.initFromJavaCode();
	    englishToSpanishTranslator.loadFromFile();
		
		
		WordTranslator translator = null;
        translator = englishToFrenchTranslator;
        
        System.out.println("with " + translator.getClass().getSimpleName()
        		           + " sourceWord=hello translatedWord="+translator.translate("hello"));
        System.out.println("with " + translator.getClass().getSimpleName()
		           + " sourceWord=green translatedWord="+translator.translate("green"));
       
        translator = englishToSpanishTranslator;
        System.out.println("with " + translator.getClass().getSimpleName() 
        		           + " sourceWord=hello translatedWord="+translator.translate("hello"));
        System.out.println("with " + translator.getClass().getSimpleName()
		           + " sourceWord=green translatedWord="+translator.translate("green"));
        
        //essai de traduction inverse:
        
        String vertEnAnglais = englishToFrenchTranslator.translateInverse("vert");
        System.out.println("vertEnAnglais="+vertEnAnglais);
        
        // essai EnglishToFrenchTranslator
        WordTranslator frenchToSpanishTranslator = new FrenchToSpanishTranslator();
        
        String vertEnEspagnol = frenchToSpanishTranslator.translate("vert");
        System.out.println("vertEnEspagnol="+vertEnEspagnol);
        
        String verdeEnFrancais = frenchToSpanishTranslator.translateInverse("verde");
        System.out.println("verdeEnFrancais="+verdeEnFrancais);
        
	}

}
