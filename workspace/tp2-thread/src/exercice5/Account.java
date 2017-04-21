package exercice5;

public class Account {
	
	private int balance;

	public Account() {
		this.balance = 100;
	}
	
	public synchronized void withdraw(int amount) {
		if (balance-amount >= 0) {
			this.balance = this.balance - amount;
		}else {
			System.out.println("Solde insuffisant!!!!! SOLDE : "+balance);
		}
	}
	
	public int getBalance() {
		return balance;
	}

}
