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
			frequentRenterPoints ++;
			// add bonus for a two day new release rental
			if ((thisRental.getMovie().getPriceCode() == Movie.NEW_RELEASE) &&
					thisRental.getDaysRented() > 1) frequentRenterPoints ++;

			//show figures for this rental
			result += "\t" + thisRental.getMovie().getTitle()+ "\t" +
					String.valueOf(thisAmount) + "\n";
			totalAmount += thisAmount;

		}
		//add footer lines
		result +=  "Amount owed is " + String.valueOf(totalAmount) + "\n";
		result += "You earned " + String.valueOf(frequentRenterPoints) +
				" frequent renter points";
		return result;
	}
	
}

