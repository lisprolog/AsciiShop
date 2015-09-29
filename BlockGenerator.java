public abstract class BlockGenerator{
	
	int blockSize = 3;
	int stepLimit = 1;

	// create array to sort charset 
	char[] pixels = new char[blockSize*blockSize];
	int[] values = new int[blockSize*blockSize];

	String charsetReverse = "";


	public BlockGenerator(){
	}

	public int[] execute(AsciiImage img, int x, int y){

		for(int i = img.getCharset().length()-1; i >= 0; --i){
			charsetReverse += img.getCharset().charAt(i);
		}

		// create array to sort charset 
		pixels = new char[blockSize*blockSize];
		values = new int[blockSize*blockSize];

		stepLimit = (int)(blockSize/2);

		int count = 0;

		values = getBlock(img,x,y);

		return values;		
	}

	public int[] pixeltoNumber(char[] pixl){

		int[] numbers = new int[pixl.length];
		for(int i = 0; i < pixl.length; i++){
			if(charsetReverse.indexOf(pixl[i])> -1){
				numbers[i] = charsetReverse.indexOf(pixl[i]);
			}else{
				numbers[i] = 0;
			}
		}

		return numbers;

	}

	public abstract int[] getBlock(AsciiImage img, int x, int y);

	public void setBlockSize(int s){
		this.blockSize = s;	
	}

	public int getBlockSize(){
		return blockSize;
	}
}
