package countdown;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class NumberBag {

	private List<Integer> smallbag = new ArrayList<Integer>();
	private List<Integer> bigbag = new ArrayList<Integer>();
	
	public void fillNumbers(String bag, Integer numbers) { //closed for modification, not hardset weights- assignable at program run.
		if(bag == "small") {
			smallbag.add(numbers/*set of numbers to be assigned.*/);
		}
		else if(bag == "big") {
			bigbag.add(numbers);
		}
	} // has bug, only applies single number.

	public int drawNumber(String bag) {
		int upperSmallRange = smallbag.size();
		int upperBigRange = bigbag.size();
		Integer number = null;
		if(bag == "small") {
			number = smallbag.get(ThreadLocalRandom.current().nextInt(1, upperSmallRange));
			}
		else if(bag == "big") {
			number = bigbag.get(ThreadLocalRandom.current().nextInt(1, upperBigRange));
		}
		return number;
	}
	
	public int NumberBagSize(String bag) {
		int bagsize = 0;
		if(bag == "small") {
			bagsize = smallbag.size();
		}
		else if(bag == "big") {
			bagsize = bigbag.size();
		}
		return bagsize;
	}
}