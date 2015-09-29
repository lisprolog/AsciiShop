/**
	* ReplicateBlockGenerator takes a block out of image at chosen coordinates
	* and returns it with a certain edge handling.
	* if the chosen block gets out of the image
	* the pixel gets duplicated
*/

public class ReplicateBlockGenerator extends BlockGenerator{

	public ReplicateBlockGenerator(int bS){
		super();
		this.blockSize = bS;
	}

	public int[] getBlock(AsciiImage img, int x, int y){

		// create array in BlockGenerator to sort charset 

		int count = 0;

//		Fill array with pixels

		int height = img.getHeight()-1;
		int width = img.getWidth()-1;

		for(int yDyn = y - stepLimit; yDyn <= y + stepLimit; yDyn++){ 
			for(int xDyn = x - stepLimit; xDyn <= x + stepLimit; xDyn++){
				//fill the pixels array
				try{
					pixels[count] = img.getPixel(xDyn,yDyn);
				}catch(IndexOutOfBoundsException e){
					if(xDyn < 0 && yDyn < 0){
						pixels[count] = img.getPixel(0, 0);
					}else if(xDyn > width && yDyn > height){
						pixels[count] = img.getPixel(width, height);
					}else if(yDyn < 0 && xDyn > width){
						pixels[count] = img.getPixel(width, 0);
					}else if(yDyn < 0){
						pixels[count] = img.getPixel(xDyn, 0);
					}else if(xDyn < 0 && yDyn > height){
						pixels[count] = img.getPixel(0, height);
					}else if(xDyn < 0){
						pixels[count] = img.getPixel(0, yDyn);
					}else if(xDyn > width){
						pixels[count] = img.getPixel(width, yDyn);
					}else if(yDyn > height){
						pixels[count] = img.getPixel(xDyn,height);
					}
				}
				count++;
			}
		}
// 		change pixel to number
		values = pixeltoNumber(pixels);

		return values;
	}
	
	public int getArraySize(){
		return blockSize*blockSize;
	}
}
