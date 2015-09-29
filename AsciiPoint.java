/**
  * 	AsciiPoint is an Object with x and y coordinate
  *	represents a point in AsciiImage 
  *	created by getPointList() which returns an ArrayList<AsciiPoint>
  */
	
public final class AsciiPoint{

	int x;
	int y;

	public AsciiPoint(int x, int y){
		this.x = x;
		this.y = y;
	}

	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}

	public String toString(){
		String point = "\n(" + x + "," + y + ")";
		return point;
	}

}
