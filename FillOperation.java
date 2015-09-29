import java.util.ArrayList;

/**
 * This Class provides a method to replace all occurrences of a specified char by another specified
 * char. It implements the Operation interface.
 */
public class FillOperation implements Operation{

	private static int count = 0;
	private int x = 0;
	private int y = 0;
	private char c = ' ';
	private char oldColor = ' ';
	public boolean setOldColor = false;
	private AsciiImage copy;
	private AsciiImage result;

	/**
	 * Creates a new ReplaceOperation that will replace all oldChars by newChar.
	 * 
	 * @param oldChar
	 *            The char that will be replaced
	 * @param newChar
	 *            The char that will be used for replacing
	 */

	public FillOperation(int x, int y, char c) {

		this.x = x;
		this.y = y;
		this.c = c;
	}

	/**
	 * Executes this FillOperation and returns as new AsciiImage where an area of chars
	 * are replaced by the newChar. Other chars/areas remain unchanged.
	 * 
	 * @param img
	 *            The AsciiImage to use as basis for executing the Operation, it will remain
	 *            unchanged
	 * @return A new AsciiImage reflecting the result of the executed Operation
	 * @throws OperationException
	 *             Thrown if the newChar is not part of the AsciiImage's charset
	 */
	
	public AsciiImage execute(AsciiImage img) throws OperationException {

		if (img.getCharset().indexOf(c) < 0) {
			throw new OperationException("OPERATION FAILED");
		}

		copy = new AsciiImage(img);
		result = new AsciiImage(img);

		if(setOldColor == false){
			oldColor = copy.getPixel(x,y);
			setOldColor = true;
		}

		if(copy.getPixel(x,y) == oldColor){

			result.setPixel(x,y,c);

			try{
				fill(x, y + 1, c);	// down
			}catch(IndexOutOfBoundsException e){
			}

			try{
				fill(x - 1, y, c);	// left
			}catch(IndexOutOfBoundsException e){
			}

			try{
				fill(x, y - 1, c);	// up
			}catch(IndexOutOfBoundsException e){
			}

			try{
				fill(x + 1, y, c);	// right
			}catch(IndexOutOfBoundsException e){
			}
		}
		return result;
	}

	public void fill(int x, int y, char c){

		// set first pixel?

		if(x < 0 || y < 0 || result.getWidth() < x || result.getHeight() < y){
			return;
		}

		if(result.getPixel(x, y) == oldColor){

			result.setPixel(x, y, c);

			try{
				fill(x, y + 1, c); // down
			}catch(IndexOutOfBoundsException e){
				return;
			}
			try{
				fill(x - 1, y, c); // left
			}catch(IndexOutOfBoundsException e){
				return;
			}
			try{
				fill(x, y - 1, c); // up 
			}catch(IndexOutOfBoundsException e){
				return;
			}
			try{
				fill(x + 1, y, c); // right
			}catch(IndexOutOfBoundsException e){
				return;
			}			
		}
		return;
	}
}
