
public class ChildrensPrice extends Price {

	@Override
	int getPriceCode() {
		return Movie.CHILDRENS;
	}

	double getCharge(int daysRented){
		double charge = 1.5;
		if (daysRented > 3)
			charge += (daysRented - 3) * 1.5;
		return charge;
	}
	
}
