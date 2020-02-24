package gil_problem2;

public class SavingsAccountTest {

	public static void main(String[] args) {
		SavingsAccount saver1 = new SavingsAccount(2000);
		SavingsAccount saver2 = new SavingsAccount(3000);
		
		int i;
		
		saver1.modifyInterestRate(.04);
		
		System.out.println("The starting balance for saver1 is: " + saver1.getSavingsBalance());
		System.out.println("The starting balance for saver2 is: " + saver2.getSavingsBalance());
		System.out.println("");
		
		for (i = 1; i <= 12; i++) {
			saver1.calculateMonthlyInterest();
			saver2.calculateMonthlyInterest();
			
			System.out.printf("The monthly balance for saver1 on month %d is %.2f.\n", i, saver1.getSavingsBalance());
			System.out.printf("The monthly balance for saver2 on month %d is %.2f.\n", i, saver2.getSavingsBalance());
			
			System.out.println("");
		}
		
		saver1.modifyInterestRate(.05);
		
		saver1.calculateMonthlyInterest();
		saver2.calculateMonthlyInterest();
		
		System.out.printf("The monthly balance for saver1 on month %d is %.2f.\n", 13, saver1.getSavingsBalance());
		System.out.printf("The monthly balance for saver2 on month %d is %.2f.\n", 13, saver2.getSavingsBalance());
		
	}

}
