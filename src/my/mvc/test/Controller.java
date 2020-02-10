package my.mvc.test;

import java.util.Scanner;

public class Controller {

	public static int inputInt;

	// Constructor
	private Model model;
	private View view;

	public Controller(Model model, View view) {
		this.model = model;
		this.view = view;
	}

	// The Work method
	public void processUser() {
		Scanner sc = new Scanner(System.in);
		System.out.println(" RANDOM NUMBER is: " + Model.valueRand + "\n");

		boolean verified = false;
		while (!verified) {
			view.printMessage(view.inputStringBuilder(model.getNewMIN(), model.getNewMAX()));

			if (sc.hasNextInt()) {
				inputInt = sc.nextInt();

				if (checkBorders(inputInt)) {
					if (verifyRange(inputInt)) {
						verified = true;
					}
				}

			}
		}

		view.printMessage(View.DONE);
		sc.close();
		
	}

	
	private boolean checkBorders(int inputInt) {
		if (!(inputInt > model.getNewMIN()) | !(inputInt < model.getNewMAX())) {
			view.printMessage(View.OUT_OF_DIAPASON);
			model.countFailedAttempts(inputInt);
			return false;
		}
		return true;
	}

	
	public boolean verifyRange(int inputInt) {
		boolean verified = true;

		if (inputInt == Model.valueRand) {
			verified = true;
		}

		if (inputInt > Model.valueRand) {
			view.printMessage(View.INPUT_LESS + inputInt);
			model.setNewMAX(inputInt);
			model.countFailedAttempts(inputInt);
			verified = false;
		}

		if (inputInt < Model.valueRand) {
			view.printMessage(View.INPUT_MORE + inputInt);
			model.setNewMIN(inputInt);
			model.countFailedAttempts(inputInt);
			verified = false;
		}

		return verified;
	}

}
