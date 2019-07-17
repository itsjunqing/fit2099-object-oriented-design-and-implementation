import java.util.ArrayList;

class Customer {

	private String _name;
	private ArrayList<Rental> _rentals = new ArrayList<Rental>();

	public Customer (String name){
		_name = name;
	};

	public void addRental(Rental arg) {
		_rentals.add(arg);
	}

	public String getName() {
		return _name;
	}

	public String statement() {
		double totalAmount = 0;
		int frequentRenterPoints = 0;
		String result = "Rental Record for " + getName() + "\n";
		for (Rental thisRental : _rentals) {
			
			//determine amounts for each line
			double thisAmount = thisRental.getCharge();

			// add frequent renter points
			frequentRenterPoints += thisRental.getFrequentRenterPoints();

			//show figures for this rental
			result += "\t" + thisRental.getMovie().getTitle()+ "\t" +
					String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;

		}
		//add footer lines
		result +=  "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
		result += "You earned " + String.valueOf(getTotalFrequentRenterPoints()) +
				" frequent renter points";
		return result;
	}
	
	public String htmlStatement() {
		String result = "<H1>Rentals for <EM>" + getName() + "</EM></H1><P>\n";
		for (Rental thisRental : _rentals) {
			//show figures for each rental
			result += thisRental.getMovie().getTitle()+ ": " +
					String.valueOf(thisRental.getCharge()) + "<BR>\n";
		}
		//add footer lines
		result +=  "<P>You owe <EM>" + String.valueOf(getTotalCharge()) + "</EM><P>\n";
		result += "On this rental you earned <EM>" +
				String.valueOf(getTotalFrequentRenterPoints()) +
				"</EM> frequent renter points<P>";
		return result;
	}
	
	private double getTotalCharge() {
		double totalCharge = 0;
		for (Rental thisRental : _rentals) {
			totalCharge += thisRental.getCharge();
		}
		return totalCharge;
	}
	
    private int getTotalFrequentRenterPoints() {
        int totalFrequentRenterPoints = 0;
		for (Rental thisRental : _rentals) {
            totalFrequentRenterPoints += thisRental.getFrequentRenterPoints();
        }
        return totalFrequentRenterPoints;
    }
	
}


