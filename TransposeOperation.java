import java.util.ArrayList;

/**
 * This Class provides a method to transpose an AsciiImage.
 * It implements the Operation interface.
 * 
 */
public class TransposeOperation implements Operation{

	/**
	 * Creates a new TransposeOperation which can transpose an AsciiImage
	 * a mathematical transposition creates a 90 degree turn by changing columns with rows
	 */

	public TransposeOperation() {

	}

	/**
	 * Executes this TransposeOperation
	 * 
	 * @param img
	 *            The AsciiImage to use as basis for executing the Operation, it will remain
	 *            unchanged
	 * @return A transposed AsciiImage
	 */
	
	public AsciiImage execute(AsciiImage img) throws OperationException {

		/*create array and rotated array*/
		char[][] picture = new char[img.getWidth()][img.getHeight()];
		char[][] pictureRotated = new char[img.getHeight()][img.getWidth()];

		/* fill regular array */
		for(int h = 0; h < img.getHeight(); h++){
			for(int w = 0; w < img.getWidth(); w++){
				picture[w][h] = img.getPixel(w,h);
			}
		}

		/*fill transposed array*/
		for(int h = 0; h < img.getWidth(); h++){
			for(int w = 0; w < img.getHeight(); w++){
				pictureRotated[w][h] = picture[h][w]; 
			}
		}

		/* print test for transposition*/
//		for(int h = 0; h < img.getWidth(); h++){
//			for(int w = 0; w < img.getHeight(); w++){
//				System.out.print(pictureRotated[w][h]);
//			}
//			System.out.print("\n");
//		}

		/*change height & width */
		int heightNew = img.getWidth();
		int widthNew = img.getHeight();

		int height = heightNew;
		int width = widthNew;
		char c = ' ';

		AsciiImage result2 = new AsciiImage(width, height, img.getCharset());

		for(int h = 0; h < height; h++ ){
			for(int w = 0; w < width; w++){
				c = pictureRotated[w][h];
				result2.picture += c;
			}
		}
		return result2;
	}
}
