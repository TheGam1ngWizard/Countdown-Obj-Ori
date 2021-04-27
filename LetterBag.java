package countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class LetterBag extends bag{

	private List<Character> vowelbag = new ArrayList<Character>();
	private List<Character> constbag = new ArrayList<Character>();
	
	@Override
	public void fillLetters(String lettertype, List<Character> letters) { //closed for modification, not hardset weights- assignable at program run.
		if(lettertype == "vowel") {
			vowelbag.removeAll(vowelbag);
			vowelbag.addAll(letters);
		}
		else if(lettertype == "const") {
			constbag.removeAll(constbag);
			constbag.addAll(letters);
		}
	}

	public Character drawLetter(String lettertype) {
		int upperVowelRange = vowelbag.size();
		int upperConstRange = constbag.size();
		Character letter = null;
		if(lettertype == "vowel") {
			letter = vowelbag.get(ThreadLocalRandom.current().nextInt(1, upperVowelRange));
			}
		else if(lettertype == "const") {
			letter = constbag.get(ThreadLocalRandom.current().nextInt(1, upperConstRange));
		}
		return letter;
	}
	
	@Override
	public int BagSize(String lettertype) {
		int bagsize = 0;
		if(lettertype == "vowel") {
			bagsize = vowelbag.size();
		}
		else if(lettertype == "big") {
			bagsize = constbag.size();
		}
		return bagsize;
	}
}
