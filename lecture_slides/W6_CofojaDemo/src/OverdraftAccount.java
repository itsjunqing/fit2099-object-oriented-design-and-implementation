import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;

public class OverdraftAccount extends BankAccount {
	
	 @Requires({
	    	"amount >= 0", // must be a non-negative amount
	    	// Can accept deposits of any positive amount
	    })
	    @Ensures({
	    	"balance == old (balance) + amount"
	    })
		public void deposit(int amount) {
	    	
	    	balance += amount; // note: can't use super due to stronger preconditions
	    	
		}
	    
	    @Requires({
	    	"amount >= 0", // must be a non-negative amount
	    })
	    @Ensures({
	    	"balance == old (balance) - amount"
	    	// balance is allowed to go negative
	    })
		public void withdraw(int amount) {
	    	
	    	balance -= amount;
	    	
		}
}
