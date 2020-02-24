package gil_problem1;

import java.security.SecureRandom;
import java.util.*;

public class CAI3 {

	public static void main(String[] args) {
		
		quiz();
		
	}
	
	public static void quiz() {
		SecureRandom randNum = new SecureRandom();
		int numA;
		int numB;
		int userResponse;
		int i;
		int numQuestions = 10;
		int correctCount = 0;
		double correctCutoff = .75;
		boolean correctOrNot = false;
		boolean goAgain = true;
		
		numA = randNum.nextInt(10);
		numB = randNum.nextInt(10);
		
		while (goAgain) {
			for (i = 0; i < numQuestions; i++) {
				askQuestion(numA,numB);
				userResponse = readResponse();
				correctOrNot = isAnswerCorrect(numA, numB, userResponse);
				if (correctOrNot) {
					displayCorrectResponse();
					correctCount++;
				}
				else {
					displayIncorrectResponse();
				}
				
				numA = randNum.nextInt(10);
				numB = randNum.nextInt(10);
			}
			
			displayCompletionMessage(numQuestions, correctCount, correctCutoff);
			correctCount = 0;
			goAgain = answerNewSet();
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
	
	public static void displayCompletionMessage(int numQuestions, int correctCount, double correctCutoff) {
		double studentScore;
		
		studentScore = ((double) correctCount) / ((double) numQuestions);
		
		System.out.println("Your score is: " + (studentScore * 100) + " percent.");
		
		if (studentScore > correctCutoff) {
			System.out.println("Congratulations, you are ready to go to the next level!");
		}
		else {
			System.out.println("Please ask your teacher for extra help.");
		}
	}
	
	public static boolean answerNewSet() {
		Scanner scnr = new Scanner(System.in);
		int yesNo = -1;
		
		do {
			System.out.println("Would you like to answer a new problem set? (0 for yes, 1 for no)");
			yesNo = scnr.nextInt();
			
			if (yesNo == 0) {
				return true;
			}
			else if (yesNo == 1) {
				return false;
			}
			else {
				System.out.println("Valid responses are 0 and 1. Try again.");
			}
		}
		while (true);
	}
	
}