package Api;

import java.util.List;

public class DictionaryEntry {
    private String word;
    private List<Meaning> meanings;

    public DictionaryEntry() {}

    public String getWord() {
        return word;
    }

    public List<Meaning> getMeanings() {
        return meanings;
    }
}
