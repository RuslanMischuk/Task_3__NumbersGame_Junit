package my.mvc.test;

import java.util.HashMap;
import java.util.Random;

public class Model {

	
	public static final int valueRand = getRandNumber();
	public static int MAX = 100;
	public static int MIN = 0;
	
	
	public static HashMap<Integer, Integer> failedAttempts = new HashMap<>();
	
	private int newMAX;
	private  int newMIN;
	

	
	public Model() {
		super();
		this.newMAX =  MAX;
		this.newMIN = MIN ;
	}
	
	

	public static int getRandNumber() {
		Random random = new Random();
		int num = 1 + random.nextInt(100 - 1);
		return num;
	}
	
	
	public void countFailedAttempts(int inputInt) {
		if (failedAttempts.containsKey(inputInt)) {
			int count = failedAttempts.get(inputInt);
			failedAttempts.put(inputInt, ++count);	
		} else {
			failedAttempts.put(inputInt, 1);	
		}
	}
	

	public int getNewMAX() { return newMAX; }
	public void setNewMAX(int newMAX) { this.newMAX = newMAX;}
	public int getNewMIN() { return newMIN;}
	public void setNewMIN(int newMIN) {	this.newMIN = newMIN;}





}