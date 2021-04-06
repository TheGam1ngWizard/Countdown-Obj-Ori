package countdown;
import java.util.ArrayList;
@SuppressWarnings("null")

public abstract class bag {
	public void fillLetters(String lettertype, ArrayList<Character> letters) {}
	public void fillNumbers(String bag, ArrayList<Integer> numbers) {}
	
	public int drawNumber(String bag) {
		Integer number = null;
		return number;
		}
	public Character drawLetter(String lettertype) {
		Character letter = null;
		return letter;
	}
	public abstract int BagSize(String bag);
}