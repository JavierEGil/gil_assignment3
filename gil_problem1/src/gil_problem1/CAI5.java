package gil_problem1;

import java.security.SecureRandom;
import java.util.*;

public class CAI5 {

	public static void main(String[] args) {
		
		quiz();
		
	}
	
	public static void quiz() {
		SecureRandom randNum = new SecureRandom();
		int numA;
		int numB;
		double userResponse;
		int i;
		int numQuestions = 10;
		int correctCount = 0;
		int difficultyLevel;
		int problemType;
		double correctCutoff = .75;
		boolean correctOrNot = false;
		boolean goAgain = true;
		int type = 0;
		
		
		while (goAgain) {
			
			difficultyLevel = readDifficulty();
			
			problemType = readProblemType();
			
			numA = randNum.nextInt(difficultyLevel);
			numB = randNum.nextInt(difficultyLevel);
			
			for (i = 0; i < numQuestions; i++) {
				
				if (problemType == 5) {
					type = randNum.nextInt(4) + 1;
				}
				else {
					type = problemType;
				}
				
				askQuestion(numA, numB, type);
				userResponse = readResponse();
				correctOrNot = isAnswerCorrect(numA, numB, userResponse, type);
				if (correctOrNot) {
					displayCorrectResponse();
					correctCount++;
				}
				else {
					displayIncorrectResponse();
				}
				
				numA = randNum.nextInt(difficultyLevel);
				numB = randNum.nextInt(difficultyLevel);
			}
			
			displayCompletionMessage(numQuestions, correctCount, correctCutoff);
			correctCount = 0;
			goAgain = answerNewSet();
		}
		
	}
	
	public static void askQuestion(int numA, int numB, int problemType) {
		if (problemType == 1)
		{
			askQuestionA(numA, numB);
		}
		else if (problemType == 2)
		{
			askQuestionM(numA, numB);
		}
		else if (problemType == 3)
		{
			askQuestionS(numA, numB);
		}
		else if (problemType == 4)
		{
			askQuestionD(numA, numB);
		}
		else {
			System.out.println("Error in askQuestion.");
		}
	}
	
	public static void askQuestionA(int numA, int numB) {
		System.out.println("How much is " + numA + " plus " + numB + "?");
	}
	
	public static void askQuestionM(int numA, int numB) {
		System.out.println("How much is " + numA + " times " + numB + "?");
	}
	
	public static void askQuestionS(int numA, int numB) {
		System.out.println("How much is " + numA + " minus " + numB + "?");
	}
	
	public static void askQuestionD(int numA, int numB) {
		System.out.println("How much is " + numA + " divided by " + numB + "? (Answer within 0.01 tolerance)");
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
	
	public static boolean isAnswerCorrect(int numA, int numB, double userResponse, int problemType) {
		if (problemType == 1)
		{
			return isAnswerCorrectA(numA, numB, (int) userResponse);
		}
		else if (problemType == 2)
		{
			return isAnswerCorrectM(numA, numB, (int) userResponse);
		}
		else if (problemType == 3)
		{
			return isAnswerCorrectS(numA, numB, (int) userResponse);
		}
		else if (problemType == 4)
		{
			return isAnswerCorrectD(numA, numB, userResponse);
		}
		else {
			System.out.println("Error in isAnswerCorrect.");
			return false;
		}
	}
	
	public static boolean isAnswerCorrectM(int numA, int numB, int userResponse) {
		if (numA * numB == userResponse) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isAnswerCorrectD(int numA, int numB, double userResponse) {
		if (Math.abs((double) numA / (double) numB - userResponse) <= .01) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isAnswerCorrectA(int numA, int numB, int userResponse) {
		if (numA + numB == userResponse) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean isAnswerCorrectS(int numA, int numB, int userResponse) {
		if (numA - numB == userResponse) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static double readResponse() {
		Scanner scnr = new Scanner(System.in);
		double input = scnr.nextDouble();
		
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
	
	public static int readDifficulty() {
		Scanner scnr = new Scanner(System.in);
		int diffLevel = -452;
		int digitRange = 1;
		int i;
		
		do {
			if (diffLevel != -452) {
				System.out.println("Not a valid response, try again.");
			}
			
			System.out.println("Difficulty levels for the problems range from 1 to 4.");
			System.out.println("A difficulty level of 1 gives problems with digits from 0 to 9   , inclusive.");
			System.out.println("A difficulty level of 2 gives problems with digits from 0 to 99  , inclusive.");
			System.out.println("A difficulty level of 3 gives problems with digits from 0 to 999 , inclusive.");
			System.out.println("A difficulty level of 4 gives problems with digits from 0 to 9999, inclusive.");
			System.out.println("Enter a difficulty level:");
			
			diffLevel = scnr.nextInt();
		}
		while (diffLevel != 1 && diffLevel != 2 && diffLevel != 3 && diffLevel != 4);	
		
		for (i = 0; i < diffLevel; i++) {
			digitRange *= 10;
		}
		
		return digitRange;
	}
	
	public static int readProblemType() {
		Scanner scnr = new Scanner(System.in);
		int problemType = -452;
		
		do {
			if (problemType != -452) {
				System.out.println("Not a valid response, try again.");
			}
			
			System.out.println("Problem types for the problems range from 1 to 5.");
			System.out.println("A problem type of 1 gives problems of type addition.");
			System.out.println("A problem type of 2 gives problems of type multiplication.");
			System.out.println("A problem type of 3 gives problems of type subtraction.");
			System.out.println("A problem type of 4 gives problems of type division.");
			System.out.println("A problem type of 5 gives problems of type addition, multiplication, subtraction, and division randomly.");
			System.out.println("Enter a problem type:");
			
			problemType = scnr.nextInt();
		}
		while (problemType != 1 && problemType != 2 && problemType != 3 && problemType != 4 && problemType != 5);
		
		return problemType;
	}
	
	
}