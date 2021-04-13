package countdown;

import java.util.List;

public class Player {
    private int currentScore;
    private List<String> possibleWords;
    private String finalWord;

    public void displayWords() {
        System.out.println("Your list of possible words so far: ");
        for (int i = 0; i < possibleWords.size(); i ++) {
            System.out.println(possibleWords.get(i));
        }
    }

    public void addWord(String wordToAdd) {
        possibleWords.add(wordToAdd);
    }

    public String chooseFinal() {
        return finalWord;
    }
}
