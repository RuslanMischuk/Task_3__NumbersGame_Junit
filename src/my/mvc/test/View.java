package my.mvc.test;

import java.util.Map.Entry;

public class View {

	public static final String OUT_OF_DIAPASON = " \n Number out of diapason. Try again! ";
	public static final String INPUT_LESS = "Random number is LESS than: ";
	public static final String INPUT_MORE = "Random number is MORE than: ";
	public static final String DONE = "DONE! ";

	public static boolean flag = true;

	public void printMessage(String message) {
		System.out.println(message);
	}

	public String inputStringBuilder(int MIN, int MAX) {

		if (flag) {
			flag = false;
			return "Guess the random number from " 
	                + MIN + " to " + MAX
	             	+ "\n Write it here:";
			
		} else {
			return "Your tried previous: \n "
					+ failedAttemptsTOString()
					+" \n Guess the random number from " 
	                + MIN + " to " + MAX
	             	+ "\n Write it here: \n ";
		}
	}
	
	public String failedAttemptsTOString() {
		String str = "";

		for (Entry<Integer, Integer> entry : Model.failedAttempts.entrySet()) {
			str += entry.getKey() + " -- " + entry.getValue() + " times \n";
		}
		return str + "---------------------------";
	}
}
