package countdown;



import java.util.*;
import java.util.ArrayList.*;
import java.util.concurrent.ThreadLocalRandom;

public class Game {
    public static void main(String[] args) {
        NumberBag numberBag = new NumberBag();
        NumberBag numberBag2 = new NumberBag();
        LetterBag letterBag = new LetterBag();
        LetterBag letterBag2 = new LetterBag();

        List<Integer> smallList = new ArrayList<Integer>();
        List<Integer> bigList = new ArrayList<Integer>();
        List<Character> vowelList = new ArrayList<Character>();
        List<Character> consonantList = new ArrayList<Character>();

        List<Integer> numberBoard = new ArrayList<Integer>();
        List<Character> letterBoard = new ArrayList<Character>();

        Player you = new Player();

        int interval = 30;
        int delay = 1000;
        int period = 30000;

        //Fill smallList
        Integer amount = 10;
        for (Integer i = 1; i < amount; i++) {
            smallList.add(i);
        }

        numberWithWeight(2, 5, smallList);
       numberWithWeight(5, 4, smallList);


        numberBag.fillNumbers("small", smallList);




        //Fill bigList
        Integer amountBig = 100;
        for (Integer i = 10; i < amountBig; i++) {
            bigList.add(i);
        }

       numberWithWeight(15, 2, bigList);
       numberWithWeight(10, 3, bigList);
       numberWithWeight(20, 4, bigList);
       numberWithWeight(50, 4, bigList);

        numberBag2.fillNumbers("big", bigList);

        runNumberRound(you, numberBoard, numberBag, numberBag2, delay, period, interval);

    }

    public static void numberWithWeight(int num, int weight, List<Integer> whichBag) {
        for (int i = 0; i < weight; i ++) {
            whichBag.add(num);
        }
    }

    public static void letterWithWeight(Character letter, int weight, List<Character> whichBag) {
        for (int i = 0; i < weight; i ++) {
            whichBag.add(letter);
        }
    }

    public static void runNumberRound(Player you, List<Integer> numBoard, NumberBag small, NumberBag big, int delay, int period, int interval) {
        Scanner in = new Scanner(System.in);
        for (int j = 0; j < 6; j ++) {
            System.out.println("Would you like a SMALL number or a BIG number? (Press 's' for SMALL and 'b' for BIG)");
            char userChoice = in.next().charAt(0);
            if (userChoice == 's') {
                numBoard.add(small.drawNumber("small"));
            } else if (userChoice == 'b') {
                numBoard.add(big.drawNumber("big"));
            } else {
                System.out.println("That is not a choice. Please choose 's' or 'b' for SMALL or BIG.");
                j--;
            }
        }


        System.out.println("Your numbers are: " + numBoard.toString());
        int goalNum = ThreadLocalRandom.current().nextInt(101, 999);
        System.out.println("Your goal number is : " + goalNum);
        System.out.println("You have 30 seconds to use your chosen numbers to reach the goal number. The time starts...NOW!");
        Time timer = new Time();
        timer.runTimer(30);
            Integer resultOfOp = null;
            while (resultOfOp != goalNum) {
                Integer num1 = in.nextInt();
                String operation = in.next();
                Integer num2 = in.nextInt();
                if (you.isValid(numBoard, num1, resultOfOp) == false || you.isValid(numBoard, num2, resultOfOp) == false) {
                    System.out.println("That is not a valid number, please try again.");
                } else {
                    switch (operation) {
                        case "+":
                            resultOfOp = num1 + num2;
                            break;

                        case "-":
                            resultOfOp = num1 - num2;
                            break;
                        case "/":
                            resultOfOp = num1 / num2;
                            break;
                        case "*":
                            resultOfOp = num1 * num2;
                            break;
                    }

                }
            }


    }
    public static void runLetterRound(List<Integer> letterBoard, LetterBag cons, LetterBag vowel, int delay, int period, int interval) {
        Scanner in = new Scanner(System.in);
        for (int j = 0; j < 6; j ++) {
            System.out.println("Would you like a Constant or a Vowel? (Press 'c' for CONSTANANT and 'v' for VOWEL)");
            char userChoice = in.next().charAt(0);
            if (userChoice == 'c') {
                letterBoard.add(cons.drawNumber("cons"));
            } else if (userChoice == 'v') {
                letterBoard.add(vowel.drawNumber("vowel"));
            } else {
                System.out.println("That is not a choice. Please choose 'c' or 'v' for CONSTANANT or VOWEL.");
                j--;
            }
        }


        System.out.println("Your letters are: " + letterBoard.toString());
        System.out.println("You have 30 seconds to use your chosen letters to make the longest word. The time starts...NOW!");
        Time timer = new Time();
        timer.runTimer(30);

    }




}
