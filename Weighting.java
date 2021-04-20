package countdown;

// Import the Scanner class to read text files
import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;
import java.util.Scanner; // Import the Scanner class to read text files


public class Weighting {
	public static LetterBag addLetterWeights(String type) {

		//Initialize the files and make sure they don't throw errors.
		File vowFile = new File("vowelfileweights.txt");
		Scanner vowScanner = null;
		try {
			vowScanner = new Scanner(vowFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File consFile = new File("constfileweights.txt");
		Scanner consScanner = null;
		try {
			consScanner = new Scanner(consFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
        LetterBag letterBag = new LetterBag();
        LetterBag letterBag2 = new LetterBag();

        List<Character> vowelList = new ArrayList<Character>();
        List<Character> consList = new ArrayList<Character>();
		
        if(type == "vowel") {
        	while(vowScanner.hasNextLine()) {
				Character vowel = vowScanner.next().charAt(0);
				int weight = vowScanner.nextInt();
				for(int i = 0; i < weight; i++) {
					vowelList.add(vowel);
				}
			}
        	vowScanner.close();
        	letterBag.fillLetters("vowel", vowelList);
        	return letterBag;
        }
		else if(type == "cons") {
			while(consScanner.hasNextLine()) {
				Character cons = consScanner.next().charAt(0);
				int weight = consScanner.nextInt();
				for(int i = 0; i < weight; i++) {
					consList.add(cons);
				}
			}
			consScanner.close();
			letterBag2.fillLetters("const", consList);
			return letterBag2;
		}
		
    return null;
	}
	public static NumberBag addNumberWeights(String type) {

		//Initialize the files and make sure they don't throw errors.
		File bigFile = new File("bigfileweights.txt");
		Scanner bigScanner = null;
		try {
			bigScanner = new Scanner(bigFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File smallFile = new File("smallfileweights.txt");
		Scanner smallScanner = null;
		try {
			smallScanner = new Scanner(smallFile);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		NumberBag numberBag = new NumberBag();
        NumberBag numberBag2 = new NumberBag();
        
        List<Integer> smallList = new ArrayList<Integer>();
        List<Integer> bigList = new ArrayList<Integer>();
		
		if(type == "big") {
			while(bigScanner.hasNextLine()) {
				int number = bigScanner.nextInt();
				int weight = bigScanner.nextInt();
				for(int i = 0; i < weight; i++) {
					bigList.add(number);
				}
			}
			bigScanner.close();
			numberBag2.fillNumbers("big", bigList);
			return numberBag;
		}
		else if(type == "small") {
			while(bigScanner.hasNextLine()) {
				int number = smallScanner.nextInt();
				int weight = smallScanner.nextInt();
				for(int i = 0; i < weight; i++) {
					smallList.add(number);
				}
			}
			smallScanner.close();
			numberBag.fillNumbers("small", smallList);
			return numberBag2;
		}
    return null;
	}
}
