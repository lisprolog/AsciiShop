/**	
 *	creates CreateOperation. 
 *	all pixels turn into the brightest char/color of charset, highest charset index used here.
 */

public class CreateOperation implements Operation{

	int width;
	int height;
	String charSet;

	public CreateOperation(int width, int height, String charset){
		this.width = width;
		this.height = height;
		this.charSet = charset;
	}

	/* returns a new AsciiImage. parameters will be ignored.*/

	public AsciiImage execute(AsciiImage img)throws OperationException{
		AsciiImage result = new AsciiImage(width, height, charSet);
		char c = charSet.charAt(charSet.length()-1); // last ascii of img charset

		for(int h = 0; h < result.getHeight(); h++){
			for(int w = 0; w < result.getWidth(); w++){
				result.picture += c; 
				//setPixel() doesn't work here, because when initialised the picture is empty.
				//instead we fill up picture with c
			}
		}
		return result;
	}
}
