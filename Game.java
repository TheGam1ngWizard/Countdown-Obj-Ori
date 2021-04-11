package countdown;


import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList.*;

public class Game {
    public static void main(String[] args) {
        NumberBag numberBag = new NumberBag();
        List<Integer> smallList = new ArrayList<Integer>();
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

        //System.out.println("The number drawn is: " + numberBag.drawNumber("small"));

        for(int j = 0; j < 15; j ++){
            System.out.println("The number drawn is: " + numberBag.drawNumber("small"));
        }


    }
}
