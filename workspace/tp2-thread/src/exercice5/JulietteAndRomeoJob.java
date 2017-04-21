package exercice5;

public class JulietteAndRomeoJob implements Runnable {
	
	private Account account;
	private String name;

	public JulietteAndRomeoJob(String name, Account account) {
		this.name = name;
		this.account = account;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			this.doWithdraw(10);
		}
	}
	
	public synchronized void doWithdraw(int amount) {
		System.out.println(name+"   SOLDE AV : "+this.account.getBalance());
		
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		this.account.withdraw(amount);
		System.out.println(name+"   SOLDE AP : "+this.account.getBalance());
	}
	
	public static void main(String[] args) {
		Account account = new Account();
		JulietteAndRomeoJob juliette = new JulietteAndRomeoJob("Juliette", account);
		JulietteAndRomeoJob romeo = new JulietteAndRomeoJob("Romeo", account);
		Thread t1 = new Thread(juliette);
		Thread t2 = new Thread(romeo);
		t1.start();
		t2.start();
	}

}
