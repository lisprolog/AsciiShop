import java.util.Arrays;

public class XBlockGenerator extends BlockGenerator{


	public XBlockGenerator(int bs){
		super();
		this.blockSize = bs;
	}

	public int[] getBlock(AsciiImage img, int x, int y){

		int count = 0;
		for(int j = y - stepLimit; j <= y + stepLimit; j++){ 
			for(int k = x - stepLimit; k <= x + stepLimit; k++){
				//fill the pixels array
				try{			
					pixels[count] = img.getPixel(k,j);
				}catch(IndexOutOfBoundsException e){
					pixels[count] = charsetReverse.charAt(0);
				}
				count++;
			}
		}
		// change pixel to number
		values = pixeltoNumber(pixels);
		return values;
	}

	public int getArraySize(){
		return blockSize*blockSize;
	}
}
