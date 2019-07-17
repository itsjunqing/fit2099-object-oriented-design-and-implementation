
public class TestVideoStore {

	public static void main(String[] args) {

		// create some movies
		Movie neverEndingStory = new Movie("The NeverEnding Story", Movie.CHILDRENS);
		Movie starWars = new Movie("Star Wars: A New Hope", Movie.REGULAR);
		Movie solo = new Movie("Solo: A Star Wars Story", Movie.NEW_RELEASE);
		
		// create an example customer
		Customer fredNurke = new Customer("Fred Nurke");
		
		// add some rentals for the customer
		fredNurke.addRental(new Rental(neverEndingStory, 2));
		fredNurke.addRental(new Rental(solo, 3));

		// print the customer's statement
		System.out.println(fredNurke.htmlStatement());
	}

}
