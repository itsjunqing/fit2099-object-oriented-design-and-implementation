
public abstract class Price {
	
	abstract int getPriceCode();
	
	double getCharge(int daysRented) {
		
		double charge = 0;
		
		switch (getPriceCode()) {
		case Movie.REGULAR:
			charge += 2;
			if (daysRented > 2)
				charge += (daysRented - 2) * 1.5;
			break;
		case Movie.NEW_RELEASE:
			charge += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			charge += 1.5;
			if (daysRented > 3)
				charge += (daysRented - 3) * 1.5;
			break;
		}
		return charge;
	}
}
