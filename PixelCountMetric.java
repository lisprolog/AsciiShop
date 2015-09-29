import java.lang.Math;

public class PixelCountMetric implements Metric<AsciiImage>{

/**	simple metric to compare AsciiPictures. */

	public PixelCountMetric(){
	}

/**	returns the Absolute value difference of image i1 und i2. size = width * height. */
	public int distance(AsciiImage i1, AsciiImage i2){

		int charsi1 = i1.getWidth() * i1.getHeight();
		int charsi2 = i2.getWidth() * i2.getHeight();
		int result = Math.abs(charsi1 - charsi2);

		return result;
	}

}
