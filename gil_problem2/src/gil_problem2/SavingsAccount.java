package gil_problem2;

public class SavingsAccount {
	private static double annualInterestRate;
	private double savingsBalance;
	
	public SavingsAccount (double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}
	
	public void calculateMonthlyInterest() {
		this.savingsBalance += (this.savingsBalance * this.annualInterestRate)  / 12.0;
	}
	
	public void modifyInterestRate(double newAnnualInterestRate) {
		this.annualInterestRate = newAnnualInterestRate;
	}
	
	public double getSavingsBalance() {
		return this.savingsBalance;
	}
}
