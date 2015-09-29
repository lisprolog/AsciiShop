import java.util.ArrayList;

/**
 * This Class provides a method to draw a line into a given image. It implements the Operation interface.
 */

public class LineOperation implements Operation{

	int x0, y0, x1, y1 = 0;
	int xstart, xend, ystart, yend;
	int xi, yi;
	double dx, dy, esc, y, x;
	char c = ' ';

	/**
	 * Creates a new LineOperation that will create line with color c.
	 * 
	 * @param x0,y0
	 *          start of line
	 * @param x1,y1
	 *          end of line
	 * @param c
	 *			color of line
	 */

	public LineOperation(int x0, int y0, int x1, int y1, char c) {

		this.x0 = x0;
		this.y0 = y0;
		this.x1 = x1;
		this.y1 = y1;
		this.c = c;
	}

	/**
	 * Executes this LineOperation and returns as new AsciiImage where a line
	 * is drawn.
	 * 
	 * @param img
	 *            The AsciiImage to use as basis for executing the Operation, it will remain
	 *            unchanged.
	 * @return A new AsciiImage reflecting the result of the executed Operation
	 * @throws OperationException
	 *             Thrown if the newChar is not part of the AsciiImage's charset
	 */
	
	public AsciiImage execute(AsciiImage img) throws OperationException {

		AsciiImage result = new AsciiImage(img);

		dy = y1 - y0;
		dx = x1 - x0;
		esc = Math.abs(dy/dx);

		// slope 1: fast x

		if(Math.abs(dy) <= Math.abs(dx)){
			if(x1 > x0){
				xstart = x0;
				xend = x1;
				ystart = y0;
				yend = y1;
				xi = x0;
				yi = y0;
				y = y0;
				x = x0;
			}else{
				xstart = x1;
				xend = x0;
				ystart = y1;
				yend = y0;
				xi = x1;
				yi = y1;
				y = y1;
				x = x1;
				if(dx != 0){
					esc = Math.abs(dy/dx);
				}else{
					esc = 0;
				}
			}

			while(xi < xend && yi <= yend){
				yi = (int)Math.round(y);
				xi = (int)Math.round(x);
				result.setPixel(xi,yi,c);
				x += 1;
				y += esc;
			}
		}

		// slope 2: fast x

		if(Math.abs(dy)<= Math.abs(dx)){

			if(x0 > x1){
				xstart = x0;
				xend = x1;
				ystart = y0;
				yend = y1;
				xi = x0;
				yi = y0;
				y = y0;
				x = x0;
			}else{
				xstart = x1;
				xend = x0;
				ystart = y1;
				yend = y0;
				xi = x1;
				yi = y1;
				y = y1;
				x = x1;
			}

			if(dx != 0){	
				esc = Math.abs(dy/dx);
			}else{
				esc = 0;
			}
			xi = xstart;
			yi = ystart;
			y = ystart;
			x = xstart;
			while(xi > xend && yi <= yend){
				xi = (int)Math.round(x);
				yi = (int)Math.round(y);
				result.setPixel(xi,yi,c);
				x -= 1;
				y += esc;
			}
		}

		// slope 3: fast y

		if(Math.abs(dy) > Math.abs(dx)){
			if(x1 > x0){
				xstart = x0;
				xend = x1;
				ystart = y0;
				yend = y1;
				xi = x0;
				yi = y0;
				y = y0;
				x = x0;
				esc = Math.abs(dx/dy);
			}else{
				xstart = x1;
				xend = x0;
				ystart = y1;
				yend = y0;
				xi = x1;
				yi = y1;
				y = y1;
				x = x1;
				esc = Math.abs(dx/dy);

				while(xi >= xend && yi < yend){
					yi = (int)Math.round(y);
					xi = (int)Math.round(x);
					result.setPixel(xi,yi,c);
					x += esc;
					y += 1;
				}

			}

			while(xi < xend && yi <= yend){
				yi = (int)Math.round(y);
				xi = (int)Math.round(x);
				result.setPixel(xi,yi,c);
				x += esc;
				y += 1;
			}
		}

		// slope 4: fast y

		if(Math.abs(dy) > Math.abs(dx)){

			if(x1 < x0){
				xstart = x0;
				xend = x1;
				ystart = y0;
				yend = y1;
				xi = x0;
				yi = y0;
				y = y0;
				x = x0;
				esc = Math.abs(dx/dy);

				while(xi > xend && yi < yend){
					xi = (int)Math.round(x);
					yi = (int)Math.round(y);
					result.setPixel(xi,yi,c);
					x -= esc;
					y += 1;
				}

			}else{
				xstart = x0;
				xend = x1;
				ystart = y0;
				yend = y1;
				xi = x0;
				yi = y0;
				y = y0;
				x = x0;

				while(xi <= xend && yi < yend){
					xi = (int)Math.round(x);
					yi = (int)Math.round(y);
					System.out.println("xi:"+xi+"yi:"+yi+"c:"+c);
					result.setPixel(xi,yi,c);
					x -= esc;
					y += 1;
				}
			}
		}

		if(x0 == x1 && y0 == y1){
			result.setPixel(x0,y0,c);					
		}
		return result;
	}
}
