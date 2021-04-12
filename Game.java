package countdown;



import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList.*;

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

        //Fill smallList
        Integer amount = 10;
        for (Integer i = 1; i < amount; i++) {
            smallList.add(i);
        }
        smallList.add(1);
        smallList.add(1);
        smallList.add(1);

        smallList.add(5);
        smallList.add(5);
        smallList.add(5);

        smallList.add(8);
        smallList.add(8);


        numberBag.fillNumbers("small", smallList);


        //Fill bigList
        Integer amountBig = 30;
        for (Integer i = 10; i < amountBig; i++) {
            bigList.add(i);
        }

        numberBag.fillNumbers("big", bigList);

        //System.out.println("The number drawn is: " + numberBag.drawNumber("small"));

        for(int j = 0; j < 15; j ++){
            System.out.println("The number drawn is: " + numberBag.drawNumber("small"));
        }

        for(int j = 0; j < 15; j ++){
            System.out.println("The number drawn is: " + numberBag.drawNumber("big"));
        }


    }
}
