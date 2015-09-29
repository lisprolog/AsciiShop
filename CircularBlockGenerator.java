public class CircularBlockGenerator extends BlockGenerator{

	public CircularBlockGenerator(int bs){
		super();
		blockSize = bs;
	}


	public CircularBlockGenerator(){
	}

	public int[] getBlock(AsciiImage img, int x, int y){

		int count = 0;

		int height = img.getHeight()-1;
		int width = img.getWidth()-1;

		int outX = 0;
		int outY = 0;

		for(int yDyn = y - stepLimit; yDyn <= y + stepLimit; yDyn++){ 
			for(int xDyn = x - stepLimit; xDyn <= x + stepLimit; xDyn++){
				//fill the pixels array
				try{
					pixels[count] = img.getPixel(xDyn,yDyn);
				}catch(IndexOutOfBoundsException e){

					if(xDyn < 0 && yDyn < 0){
						pixels[count] = img.getPixel(width+xDyn+1, height+yDyn+1);
					}else if(xDyn > width && yDyn > height){
						pixels[count] = img.getPixel(xDyn-width-1, yDyn-height-1);
					}else if(yDyn < 0 && xDyn > width){
						pixels[count] = img.getPixel(width, height+yDyn+1);
					}else if(yDyn < 0){
						pixels[count] = img.getPixel(xDyn, height+yDyn+1);
					}else if(xDyn < 0 && yDyn > height){
						pixels[count] = img.getPixel(width+xDyn+1, height);
					}else if(xDyn < 0){
						pixels[count] = img.getPixel(width+xDyn+1, yDyn);
					}else if(xDyn > width){
						pixels[count] = img.getPixel(xDyn-width-1, yDyn);
					}else if(yDyn > height){
						pixels[count] = img.getPixel(xDyn,yDyn-height-1);
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
