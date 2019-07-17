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
			double thisAmount = amountFor(thisRental);

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
	
	private double amountFor(Rental thisRental) {
		
		double thisAmount = 0;
		switch (thisRental.getMovie().getPriceCode()) {
		case Movie.REGULAR:
			thisAmount += 2;
			if (thisRental.getDaysRented() > 2)
				thisAmount += (thisRental.getDaysRented() - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			thisAmount += thisRental.getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			thisAmount += 1.5;
			if (thisRental.getDaysRented() > 3)
				thisAmount += (thisRental.getDaysRented() - 3) * 1.5;
			break;
		}
		return thisAmount;
	}
	
}

