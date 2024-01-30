package tp;

public interface WordTranslatorWithEntry extends WordTranslator {
	public void addTranslationEntry(String word, String translation);
	public void loadFromFile();
	public void initFromJavaCode();
}
