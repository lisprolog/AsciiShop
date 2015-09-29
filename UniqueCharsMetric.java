import java.lang.Math.*;

public class UniqueCharsMetric implements Metric<AsciiImage>{

	/** an easy metric for AsciiImages that compares the amount of unique chars.
		@return an absolute value of the difference amount of unique chars in an AsciiImage. 
	 */

	public UniqueCharsMetric(){
	}

	public int distance(AsciiImage i1, AsciiImage i2){

		int uniques1 = i1.getUniqueChars();
		int uniques2 = i2.getUniqueChars();
		int result = Math.abs(uniques1 - uniques2);
		return result; 
	}

}
