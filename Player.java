package countdown;

import java.util.List;

public class Player {
    private int currentScore;
    private List<String> possibleWords;
    private Integer finalNum;

    private String finalWord;

    public void displayWords() {
        System.out.println("Your list of possible words so far: ");
        for (int i = 0; i < possibleWords.size(); i ++) {
            System.out.println(possibleWords.get(i));
        }
    }

    public boolean isValid(List<Integer> numBoard, Integer num , Integer resultOfOp) {
        boolean validAnswer = false;
        for (int i = 0; i < numBoard.size(); i ++) {
            if (num == numBoard.get(i) || num == resultOfOp) {
                return true;
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

    public void addWord(String wordToAdd) {
        possibleWords.add(wordToAdd);
    }

    public String chooseFinal() {
        return finalWord;
    }
}
