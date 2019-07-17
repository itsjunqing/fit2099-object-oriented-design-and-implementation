
public class RegularPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.REGULAR;
	}
	
	double getCharge(int daysRented) {
		double charge = 2;
		if (daysRented > 2)
			charge += (daysRented - 2) * 1.5;
		return charge;
	}

}
