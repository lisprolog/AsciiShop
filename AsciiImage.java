import java.util.*;

/**
  *	AsciiImage contains the methods getHeight, getWidth, getPixel, setPixel, 
  *	clear, drawline, toString, transpose, flipV, getuniquechars
  */

public class AsciiImage{

	private int width;
	private int height;
	private String charset;
	String picture;
	
	char oldColor = ' ';
	boolean setOldColor;

/**
  *	initialises the AsciiImage object with width, height and a charset 
  */

	public AsciiImage(int width, int height, String charset){
		
		if(width <= 0){ 
			throw new RuntimeException("width <= 0");
		}

		if(height <= 0){ 
			throw new RuntimeException("height <= 0");
		}

		// char appears more than once
		if(charset.indexOf(charset.charAt(0), charset.indexOf(charset.charAt(0)) +1) > -1){
			throw new IllegalArgumentException("charset error");			
		}

		if(charset.length() <= 0){
			throw new RuntimeException("no charset");
		}

		this.width = width;
		this.height = height;
		this.picture = "";
		this.charset = charset;
	}

/**
  *	Constructor to copy an AsciiImage
  */

	public AsciiImage(AsciiImage img){

		this.width = img.getWidth();
		this.height = img.getHeight();
		this.picture = " ";
		this.charset = img.getCharset();
		int count = 0;

		for(int h = 0; h < height; h++){
			for(int w = 0; w < width; w++){
				this.picture = img.picture;
			}
		}
	}

/** 
  *	getter height: int number of lines of the AsciiImage
  */

	public int getHeight(){	
		return height;
	}

/** 
  *	getter width: number of chars in one AsciiImage line
  */

	public int getWidth(){
		return width;	
	}

/**
  * 	getter charset: returns a String with the chars that the AsciiImage is made of,
  * 	each char represents a degree of "brightness" in the AsciiPicture
  */

	public String getCharset(){
		return charset;
	}

/**
  *	setter charset: sets a String with the chars that the AsciiImage is made of,
  * 	each char represents a degree of "brightness" in the AsciiPicture
  */

	public void setCharset(String set){
		this.charset = set;
	}

/**
  *	returns the current pixel at chosen coordinates
  *	@param x coordinate starting at 0, ending at getWidth()
  *	@param y coordinate starting at 0, ending at getHeight()
  */

	public char getPixel(int x, int y){ 

		char pixel = ' ';
		if (x >= width || y >= height || x < 0 || y < 0) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		}
		pixel = picture.charAt(width*(y)+x);
		return pixel;
	}

/**
  *	returns the currents pixel by AsciiPoint
  * 	gets the current pixel at chosen AsciiPoint
  */

	public char getPixel(AsciiPoint p){

		if (p.getX() >= width || p.getY() >= height || p.getX() < 0 || p.getY() < 0) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		}

		char pixel = ' ';
		int x = p.getX();
		int y = p.getY();
		pixel = picture.charAt(width*(y)+x);
		return pixel;
	}

/**
  *	sets a character at a chosen coordinate
  *	@param x coordinate starting at 0
  *	@param y coordinate starting at 0
  *	@param c color/char
  */

	public void setPixel(int x, int y, char c){
		if (x >= width || y >= height || x < 0 || y < 0) {
			throw new IndexOutOfBoundsException("IndexOutOfBoundsException");
		}

		String s = "" + c; 
		String s1 = "";
		String s2 = "";
		int z = 0;
		if (charset.contains(s) == false) {
			throw new IndexOutOfBoundsException("not contained in charset");
		}

		if(picture.length() <= 0 || picture == null){
			picture += c;
		}else{
			s1 = picture.substring(0,y*width+x);
			s2 = picture.substring(y*width+(x+1));
			picture = s1 + s + s2;
		}
	}

/**
  *	choose a character from charset 
  * 	at a chosen AsciiPoint p
  */

	public void setPixel(AsciiPoint p, char c){

		String s = "" + c;
		if (charset.contains(s) == false) {
			throw new IndexOutOfBoundsException("not contained in charset");
		}
		int x = p.getX();
		int y = p.getY();
		picture = picture.substring(0,y*width+x) + c + picture.substring(y*width+x+1);
	}

/**
  *	returns ArrayList of AsciiPoints
  */

	public ArrayList<AsciiPoint> getPointList(char c){

		ArrayList<AsciiPoint> list = new ArrayList<AsciiPoint>();

		for(int h = 0; h < height; h++){
			for(int w = 0; w < width; w++){
				if(getPixel(w,h) == c){
					AsciiPoint a = new AsciiPoint(w,h);
					list.add(a);
				}
			}
		}
		return list; 
	}

/**
  *	returns the AsciiImage in a String variable
  */

	public String toString(){

		String pic = "";
		int count = 0;
		for(int h = 0; h < getHeight(); h++){
			for(int w = 0; w < getWidth(); w++){	
				pic += picture.charAt(count++);
			}
			pic +="\n";
		}
		return pic;
	}

/**	
  *	compares two AsciiImages and returns true if width and height are identical and all chars in both images are identical. 
  *	@return false. 
  */
	public boolean equals(Object o){

		AsciiImage copy = (AsciiImage)o;

		boolean same = true;
		int difference = 0;
		int numberofChars = width * height;
		String copyPic = o.toString();
		
		if(width != copy.getWidth() || height != copy.getHeight()){
			same = false;
		}

		for(int i = 0; i < numberofChars; i++){
			try{
				if(picture.charAt(i) != copyPic.charAt(i)){
					same = false;
				}
			}catch(StringIndexOutOfBoundsException e){
				same = false;
			}
		}
		return same;
	}

	/** returns the Hashcode of the AsciiImage, sum of all ASCII chars in this AsciiImage. */
	public int hashCode(){
		int sum = 0;
		for(int i = 0; i< picture.length(); i++){
			sum += (int)picture.charAt(i);
		}
		return sum;
	}

	/** returns the amount of unique characters of this AsciiImage.*/
	public int getUniqueChars(){

		int uniques = 0;
		int rest = 0;
		for (int i = 0; i < picture.length(); i++) {
			if (picture.substring(0, i).contains(picture.charAt(i)+ "")){
				rest++;
			}else{
				uniques++;
			}
		}
		return uniques;
	}
}
