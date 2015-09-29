/**
 * BinaryOperation replaces all chars in a AsciiImage depending on the char threshold parameter, 
 * either the darkest or brightest occurence of the given charset.
 * implements the Operation interface.
 */

public class BinaryOperation implements Operation{

	private char threshold;

	public BinaryOperation(char threshold){
		this.threshold = threshold;
	}

	/**
	 * returns as new AsciiImage where all pixels
	 * are replaced to either darkest or brightest pixel of the charset.
	 * @param img
	 *            an AsciiImage object, with width, height, charset and an array
	 * @return an AsciiImage with only two chars/colors
	 * @throws OperationException
	 *             Thrown if the threshold parameter is not part of the AsciiImage charset
	 */

	public AsciiImage execute(AsciiImage img) throws OperationException{

		char c = ' ';
		AsciiImage result = new AsciiImage(img);

		if(img.getCharset().indexOf(threshold) < 0){
			throw new OperationException("Invalid char");
		}

		String charset = img.getCharset();
		int thresholdIndex = charset.indexOf(threshold);
		int pixelIndex = 0;
		char brightPixel = charset.charAt(charset.length()-1);
		char darkPixel = charset.charAt(0);

		for(int h = 0; h < result.getHeight(); h++){
			for(int w = 0; w < result.getWidth(); w++){

				c = img.getPixel(w,h);// this getPixel must be taken from a different object than result
				pixelIndex = charset.indexOf(c); 
				if(pixelIndex >= thresholdIndex){
					result.setPixel(w,h,brightPixel);
				}else {
					result.setPixel(w,h,darkPixel);
				}
			}
		}
		return result;
	}
}
