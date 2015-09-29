/**
 * This class clears the AsciiImage.
 * The last/brightest pixel of charset will be used to fill the image
 */
public class ClearOperation implements Operation{
	
	public ClearOperation(){
	}

	public AsciiImage execute(AsciiImage img){

		AsciiImage result = new AsciiImage(img);
		char c = img.getCharset().charAt(img.getCharset().length()-1);	//last ascii of img charset

		for(int h = 0; h < img.getHeight(); h++){
			for(int w = 0; w < img.getWidth(); w++){
				result.picture += c; 
				//setPixel() doesn't work here, because when initialised the picture is empty.
				//instead we fill up picture with c
			}
		}
		return result;
	}
}
