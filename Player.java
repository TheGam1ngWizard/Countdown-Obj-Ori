package countdown;

import java.util.ArrayList;
import java.util.List;

public class Player {
    private int currentScore;
    private List<String> possibleWords = new ArrayList<>();

    private String finalWord;

    public void displayWords() {
        System.out.println("Your list of possible words so far: ");
        for (int i = 0; i < possibleWords.size(); i ++) {
            System.out.println(possibleWords.get(i));
        }
    }

    public boolean isValid(List<Integer> numBoard, Integer num , List<Integer> pastResults) {
        boolean validAnswer = false;
        for (int i = 0; i < numBoard.size(); i ++) {
            if (num == numBoard.get(i) || pastResults.contains(num)) {
                validAnswer = true;
                return validAnswer;
            }
        }
        return validAnswer;
    }

    public Integer addNumbers(Integer num , Integer num2) {
        return num + num2;
    }
    public Integer subtractNumbers(Integer num, Integer num2) {
        return num - num2;
    }
    public Integer multiplyNumbers(Integer num, Integer num2) {
        return num * num2;
    }
    public Integer divideNumbers(Integer num, Integer num2) {
        return num/num2;
    }

    public boolean finalAnswer(Integer num, Integer finalAnswer) {
        if (num == finalAnswer) {
            return true;
        }
        else {
            return false;
        }
    }

    public int scoreWordRound(boolean timeBonus) {
        int wordScore = 0;
        int place = 0;
        for (int i = 0; i < possibleWords.size(); i++) {
            if (possibleWords.get(i).length() > wordScore) {
                wordScore = possibleWords.get(i).length();
                place = i;
            }
        }
        if (timeBonus == true) {
            wordScore = wordScore + 5;
        }
        finalWord  = possibleWords.get(place);
        currentScore = currentScore + wordScore;
        return wordScore;
    }

    public int scoreNumRound(Integer finalNumAnswer, Integer expectedNum) {
        int roundScore = 0;
        int diff = Math.abs(expectedNum - finalNumAnswer);
        if(finalAnswer(expectedNum, finalNumAnswer)) {
            roundScore = 10;

        }
        else if ((diff <= 5)) {
            roundScore = 8;
        }
        else if (diff <= 10) {
            roundScore = 5;
        }
        else if(diff <= 50) {
            roundScore = 2;
        }
        else {
            roundScore = 0;
        }

        currentScore = currentScore + roundScore;
        return roundScore;

    }

    public int getCurrentScore() {
        return currentScore;
    }

    public void addWord(String wordToAdd) {
        possibleWords.add(wordToAdd);
    }

    public String chooseFinal() {
        return finalWord;
    }
}
