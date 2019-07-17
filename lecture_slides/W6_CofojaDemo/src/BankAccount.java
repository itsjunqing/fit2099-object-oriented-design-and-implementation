import com.google.java.contract.Requires;
import com.google.java.contract.Ensures;

public class BankAccount {

	protected int balance = 0;
	
	public int getBalance() {
		
		return balance;
		
	}
	
    @Requires({
    	"amount >= 0", // must be a non-negative amount
    	"amount % 10 == 0" // only accept deposits in multiples of 10
    })
    @Ensures({
    	"balance == old (balance) + amount"
    })
	public void deposit(int amount) {
    	
    	balance += amount;
    	
	}
    
    @Requires({
    	"amount >= 0", // must be a non-negative amount
    	"amount <= balance" // cannot withdraw more than is in the account
    })
    @Ensures({
    	"balance == old (balance) - amount"
    })
	public void withdraw(int amount) {
    	
    	balance -= amount;
    	
	}
}
