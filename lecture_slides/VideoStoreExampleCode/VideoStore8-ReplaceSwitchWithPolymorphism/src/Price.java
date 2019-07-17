
public abstract class Price {
	
	abstract int getPriceCode();
	abstract double getCharge(int daysRented);
	
	int getFrequentRenterPoints(int daysRented) {
		
			return 1; // this default behaviour can be overridden in subclasses
	}

}
