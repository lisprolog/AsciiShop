import java.util.Scanner;
import java.lang.String;
/**
 * This class loads an picture from Mainclass into an AsciiImage and returns the AsciiImage 
 */
public class LoadOperation implements Operation {

	/**
	 * @param img
	 *            The AsciiImage to use as basis for executing the Operation, it will remain
	 *            unchanged
	 * @return A new AsciiImage loaded with the data String.
	 * @throws OperationException
	 *             Thrown if too much/less/wrong data is given, while executing the Operation
	 */

	String data;
	int count = 0;
	boolean inputMismatch = false;
	Scanner sc;

	public LoadOperation(String data){
		this.data = data;
	}

	public AsciiImage execute(AsciiImage img) throws OperationException{

		int height, compareWidth = 0;
		String temp = "";
		String compareString = "";
		boolean setWidth = false;
		AsciiImage result = new AsciiImage(img);
		count = 0;
		for(int h = 0; h < img.getHeight(); h++){
			for(int w = 0; w < img.getWidth(); w++){
				if(data.charAt(count) == '\n'){
					count++;
				}
				result.setPixel(w,h,data.charAt(count));
				count++;
			}
		}
		return result;
	}
}
