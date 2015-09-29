import java.util.ArrayList;

/**
 * This Class provides a method to replace all occurrences of a specified char by another specified
 * char. It implements the Operation interface. 
 */

public class GrowRegionOperation implements Operation{

	private char c;

	/**
	 * Creates a new ReplaceOperation that will replace all oldChars by newChar.
	 * 
	 * @param c
	 *            The char that will grow
	 */

	public GrowRegionOperation(char newChar) {
		this.c = newChar;
	}

	/**
	 * Executes this ReplaceOperation and returns as new AsciiImage where all occurrences of the
	 * oldChar are replaced by the newChar. Other chars remain unchanged.
	 * 
	 * @param img
	 *            The AsciiImage to use as basis for executing the Operation, it will remain
	 *            unchanged
	 * @return A new AsciiImage reflecting the result of the GrowRegionOperation
	 * @throws OperationException
	 *             Thrown if the newChar is not part of the AsciiImage's charset
	 */
	
	public AsciiImage execute(AsciiImage img) throws OperationException {

		/* create duplicate array */

		AsciiImage result = new AsciiImage(img);

		/* read picture array, change duplicate array */

		ArrayList<AsciiPoint> region = img.getPointList(c);
		for (AsciiPoint p : region) {

			int i = p.getX();
			int j = p.getY();

			if(img.getPixel(p) == c){
//				x - 1
				if(i == 0){
					continue;
				}else if(img.getPixel(i - 1, j) != '.' && img.getPixel(i - 1,j) != c){
					continue;
				}
				result.setPixel(i-1,j, c);
//				x + 1
				if(i == img.getWidth()){
					continue;
				}else if(img.getPixel(i + 1, j) != '.' && img.getPixel(i + 1,j) != c){
					continue;
				}
				result.setPixel(i+1,j,c);
//				y - 1
				if(j == 0){
					continue;
				}else if(img.getPixel(i, j - 1) != '.' && img.getPixel(i,j - 1) != c){
					continue;
				}
				result.setPixel(i, j-1,c);
//				y + 1
				if(j == img.getHeight()){
					continue;
				}else if(img.getPixel(i, j + 1) != '.' && img.getPixel(i,j +1) != c){
					continue;
				}
				result.setPixel(i, j+1, c);
			}
		} 
		return result;
	}
}
