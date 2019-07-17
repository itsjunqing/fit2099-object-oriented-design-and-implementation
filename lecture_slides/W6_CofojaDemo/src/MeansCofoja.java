import com.google.java.contract.Ensures;
import com.google.java.contract.Requires;


public class MeansCofoja {
	
    @Requires({
    	"a >= 0",
    	"b >= 0"
    })
    @Ensures({
    	"Math.abs(result*result - a*b) < 1e-10"
    })
	public double geometricMean(double a, double b) {

		double result = Math.sqrt(a*b);
		//double result = (a + b)/2; // WRONG This is the arithmetic mean
		return result;
	}
	
}
