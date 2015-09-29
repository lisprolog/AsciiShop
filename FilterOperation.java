import java.util.Arrays;

public abstract class FilterOperation implements Operation{

	AsciiImage copy;
	AsciiImage result;
	BlockGenerator b1;
	int[] values;
	int x, y, r;

	public FilterOperation(){
	}

	public AsciiImage execute(AsciiImage img) throws OperationException{

		// copy for looking up image 
		AsciiImage copy = new AsciiImage(img);

		for(int h = 0; h < img.getHeight(); h++){
			for(int w = 0; w < img.getWidth(); w++){
				copy.picture += img.getPixel(w,h);
			}
		}

		// copy for changing the image
		AsciiImage result = new AsciiImage(img);

		for(int h = 0; h < img.getHeight(); h++){
			for( int w = 0; w < img.getWidth(); w++){
				result.picture += img.getPixel(w,h);
			}
		}

		// copy the charset
		result.setCharset(img.getCharset());

		// indexOf() count from left to right, our specification counts from right to left
		// therefore we reverse charset to use it together with indexOf()
		// lastIndexOf() does not help, because it starts, but does not count this way.

		String charsetReverse = "";

		for(int i = img.getCharset().length()-1; i >= 0; --i){
			charsetReverse += img.getCharset().charAt(i);
		}

		// create array to get indexOf each pixel

		int[] values;
		int testCount = 0;
		b1 = getBlockGenerator();

		for(int y = 0; y < result.getHeight(); y++){
			for(int x = 0; x < result.getWidth(); x++){
				values = b1.execute(img, x, y);
//********************************for testing********************************
//				System.out.print("\n");
//				for(int i = 0; i < values.length; i++){
//					if(i % b1.getBlockSize() == 0){
//						System.out.println("");
//					}
//					System.out.print(values[i]+"|");
//				}
//				System.out.print("\n");
//***************************************************************************
				//sort Array
				Arrays.sort(values);
				try{
					result.setPixel(x,y,charsetReverse.charAt(filter(values)));
				}catch(StringIndexOutOfBoundsException e){
					//End of loop, do nothing
				}
			}
		}
		
		return result;
	}

	public void setBlockGenerator(BlockGenerator bg){
		b1 = bg;
	}

	public abstract int filter(int[] values);
	
	public abstract BlockGenerator getBlockGenerator();
	
}
