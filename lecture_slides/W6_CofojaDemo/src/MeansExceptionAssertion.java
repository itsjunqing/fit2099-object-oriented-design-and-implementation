
public class MeansExceptionAssertion {

	public double geometricMean(double a, double b) throws Exception {
		/* 
		 * Start Preconditions 
		 */
		// Precondition: firstArgumentNonNegative
		if (a < 0) {
			throw new Exception("Precondition violated: firstArgumentNonNegative");
		}		// Precondition: secondArgumentNonNegative
		if (b < 0) {
			throw new Exception("Precondition violated: secondArgumentNonNegative");
		}
		/*
		 * End Preconditions
		 */

		double result = Math.sqrt(a*b);
		//double result = (a + b)/2; // WRONG This is the arithmetic mean
		
		/* 
		 * Start Postconditions 
		 */
		// Postcondition: invertingGeoMeanAccurate
		// Note that we should always avoid checking for equality between floating point values, due to finite machine precision
		assert(Math.abs(result*result- a*b) < 1e-20) : "Postcondition violated: invertingGeoMeanAccurate"; 
		/*
		 * End Postconditions
		 */
		return result;
	}
	
}
