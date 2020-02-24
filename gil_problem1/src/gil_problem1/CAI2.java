package gil_problem1;

import java.security.SecureRandom;
import java.util.*;

public class CAI2 {

	public static void main(String[] args) {
		
		quiz();
		
	}
	
	public static void quiz() {
		SecureRandom randNum = new SecureRandom();
		int numA;
		int numB;
		int userResponse;
		boolean correctOrNot = false;
		
		numA = randNum.nextInt(10);
		numB = randNum.nextInt(10);
		
		while (!correctOrNot) {
			askQuestion(numA,numB);
			userResponse = readResponse();
			correctOrNot = isAnswerCorrect(numA, numB, userResponse);
			if (correctOrNot) {
				displayCorrectResponse();
			}
			else {
				displayIncorrectResponse();
			}
		}
	}
	
	public static void askQuestion(int numA, int numB) {
		System.out.println("How much is " + numA + " times " + numB + "?");
	}
	
	public static void displayIncorrectResponse() {
		SecureRandom randNum = new SecureRandom();
		int reply;
		
		reply = randNum.nextInt(4) + 1;
		
		switch (reply) {
			case 1: System.out.println("No. Please try again.");
					break;
			case 2: System.out.println("Wrong. Try once more.");
					break;
			case 3: System.out.println("Don't give up!");
					break;
			case 4: System.out.println("No. Keep trying.");
					break;
			default:System.out.println("Error in displayIncorrectResponse");
					break;
		}
	}
	
	public static void displayCorrectResponse() {
		SecureRandom randNum = new SecureRandom();
		int reply;
		
		reply = randNum.nextInt(4) + 1;
		
		switch (reply) {
			case 1: System.out.println("Very good!");
					break;
			case 2: System.out.println("Excellent!");
					break;
			case 3: System.out.println("Nice work!");
					break;
			case 4: System.out.println("Keep up the good work!");
					break;
			default:System.out.println("Error in displayCorrectResponse");
					break;
		}
	}
	
	public static boolean isAnswerCorrect(int numA, int numB, int userResponse) {
		if (numA * numB == userResponse) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static int readResponse() {
		Scanner scnr = new Scanner(System.in);
		int input = scnr.nextInt();
		
		return input;
	}
}