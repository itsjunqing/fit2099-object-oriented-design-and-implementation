public class Movie {

	public static final int  CHILDRENS = 2;
	public static final int  REGULAR = 0;
	public static final int  NEW_RELEASE = 1;

	private String _title;
	private Price _price;
	private int _priceCode;

	public Movie(String title, int priceCode) {
		_title = title;
		setPriceCode(priceCode);
	}

	public int getPriceCode() {
		return _price.getPriceCode();
	}
	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			_price = new RegularPrice();
			break;
		case CHILDRENS:
			_price = new ChildrensPrice();
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public String getTitle (){
		return _title;
	};
	
	int getFrequentRenterPoints(int daysRented) {

		return _price.getFrequentRenterPoints(daysRented);

	}
	
	double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}
	
}
