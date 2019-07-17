
public class ContractsDemo {
	
    public static void main(String[] args) throws Exception {
    	
        //MeansExceptionAssertion means = new MeansExceptionAssertion();
        MeansCofoja means = new MeansCofoja();
        System.out.println(means.geometricMean(3, 8)); //try (-3, 8)
        
        BankAccount bankAccount = new BankAccount();
        bankAccount.deposit(100); // try 101
        bankAccount.withdraw(25); // try 125
        System.out.println("BankAccount Balance: " + bankAccount.getBalance());
        
        bankAccount = new OverdraftAccount();
        bankAccount.deposit(101);
        bankAccount.withdraw(125); // try -125
        System.out.println("OverdraftAccount Balance: " + bankAccount.getBalance());
    }
    
}
 