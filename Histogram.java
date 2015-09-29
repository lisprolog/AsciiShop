/**
	* This is a histogram class. The basic idea is to have a frequency scale of a given picture/img.
	* It contains result, a copy of the img.
	* @return result2 copy with flipped width, height and extended charset.
	* 
	*/

public class Histogram{

	private static int width;
	private static final int height = 16;
	private String charSet = "";
	private static AsciiImage result;
	private static double max = 0;
	private static int maxV = 0;
	private static String[] yaxis = new String[15];

	public Histogram(){
	}

	public static AsciiImage getHistogram(AsciiImage img){

		width = img.getCharset().length();

		/* first copy of AsciiImage*/ 

		result = new AsciiImage(img);

		/*	check if 0123456789 is already in charset of img */

		String newCharset = img.getCharset();
		String figures = "1234567890#.";
		String missing = "";
		for(int i = 0; i < 12; i++){
			if(!newCharset.contains(figures.charAt(i)+"")){
				missing += figures.charAt(i);
			}
		}
		newCharset += missing;

		/* create AsciiImage with transposed width height and new Charset */
		
		AsciiImage result2 = new AsciiImage(height, width+3, newCharset);

		/* initialise result2 picture, else setPixel() won't work because of an empty string */

		for(int h = 0; h < result2.getHeight(); h++){
			for(int w = 0; w < result2.getWidth(); w++){
				result2.picture += '.';
			}
		}

		String picture = "";
		String[] hist = new String[width];

		/* fill histogram vertically */

		double value = 0;
		String car = "";
		int pixelAmount;
		double pixelPercent;
		int pixelSum;
		double c = 0;

		/* create labels yaxis */

		for(int i = 0; i < width; i++){
			pixelAmount = pixelCounter(result.getCharset().charAt(i));
			pixelSum = result.getHeight()*result.getWidth();
			pixelPercent = (double)pixelAmount/pixelSum;

			// find out maximum Value
			if(pixelPercent > max){
				max = pixelPercent;
			}

			c = pixelPercent;
			value = c;
			car = ""; //reset the variable, make it empty
			car += result.getCharset().charAt(i);
		}

//		max
		for(int i = 0; i < width; i++){
			pixelAmount = pixelCounter(result.getCharset().charAt(i));
			pixelSum = result.getHeight()*result.getWidth();
			pixelPercent = (double)pixelAmount/pixelSum;

			c = pixelPercent;
			value = c;
			car = ""; //reset the variable, make it empty
			car += result.getCharset().charAt(i);
			hist[i] = drawBar(car, max, value);
			picture += hist[i];
		}

		/* fill histogram */
		int errorCount = 0;
		for(int h = 0; h < hist.length; h++){
			for(int w = 0; w < hist[h].length(); w++){
				try{
					result2.setPixel(w, h+3, hist[h].charAt(w));
				}catch(IndexOutOfBoundsException e){
					++errorCount;
				}
			}
		}

//		find out maximumValue and balance=dif
		double dmax = (double)maxV;
		double div = 15; //8
		double diff = Math.ceil(dmax / div);
		double difff = (dmax / div);
		double maxVV = (double)maxV;

//		fill yaxis with percent values
		int[] yAxeInt = new int[(yaxis.length)];

		for(int i = 0; i < yAxeInt.length; i++){
				yAxeInt[i]= (int)Math.round(maxVV - (i*difff));
					if(yAxeInt[i] < 10){
						yaxis[i] = ".." + yAxeInt[i];
					}else if(yAxeInt[i] > 99){
						yaxis[i] = "" + yAxeInt[i];
					}else{
						yaxis[i] = "." + yAxeInt[i];				
					}
		}

//		fill yaxis in histogram

		for(int w = 0; w < 3; w++){
			result2.setPixel(15, w, yaxis[0].charAt(w));				
			result2.setPixel(13, w, yaxis[2].charAt(w));
			result2.setPixel(11, w, yaxis[4].charAt(w));
			result2.setPixel( 9, w, yaxis[6].charAt(w));
			result2.setPixel( 7, w, yaxis[8].charAt(w));
			result2.setPixel( 5, w, yaxis[10].charAt(w));
			result2.setPixel( 3, w, yaxis[12].charAt(w));
			result2.setPixel( 1, w, yaxis[14].charAt(w));
		}
		return result2;
	}

	public static int pixelCounter(char pixel){
		return result.getPointList(pixel).size();
	}

	public static String repeat(char c, int n){

		String word = "";
		for (int i = 0; i < n; i++){
			word += c;
		}
		return word;
	}

	public static void setPixel(int x, int y, char pixel){
		result.setPixel(x,y,pixel);
	}

	public static String drawBar(String label, int value){
		
		String w2 = "";	
		if(value <= 15){			
			w2 = label + repeat('#',value) + repeat('.', 15 - value);
		}else{	
			boolean error = true;
			w2 = "INPUT ERROR";
		}
		return w2;
	}

	public static String drawBar(String label, double mm, double value){

		int count = 0;
		String value2S = "";

		double percent = (value) * 100; 			//create percentage round to even
		double value2 = Math.ceil(0.494 * percent);		//try and error value 0.494
		double value3 = Math.round(value2);			//round up

		String value3S = ""; 

		if(maxV < 10){
			value3S += maxV;
			yaxis[count] = ".." + drawLabel(value3S,1);
		}else{
			value3S += maxV;	
			yaxis[count] = "." + drawLabel(value3S,2);
		}

		count++;	
		int value4 = (int)value3;		
		if(percent >= maxV){
			maxV = (int)percent;
		}

		String w2 = label + repeat('#', value4) + repeat('.', 15 - value4);
		return w2;
	}

	public static String drawLabel(String label, int n){

		String word1 = "";
		if(label.length() <= n){	
			for(int j = 0; j < label.length(); j++){
				word1 += label.charAt(j);
			}
			for(int k = 0; k < (n - label.length()); k++){
				word1 += " ";
			}
		}else{	
			for(int i = 0; i < n; i++){
				word1 += label.charAt(i);
			}
		}
		return word1;
	}
}
