package gil_problem1;

import java.security.SecureRandom;
import java.util.*;

public class CAI1 {

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
		System.out.println("No. Please try again.");
	}
	
	public static void displayCorrectResponse() {
		System.out.println("Very good!");
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