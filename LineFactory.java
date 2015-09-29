import java.util.Scanner;

/**
 * This Class provides a method to create a new LineOperation. It implements the Factory
 * interface.
 */

public class LineFactory implements Factory {

	public LineFactory() {
	}

	/**
	 * This method reads the two required parameter for a LineOperation and creates a new
	 * ReplaceOperation.
	 * 
	 * @param scanner
	 *            The Scanner to use for reading parameters
	 * @return A new LineOperation that is initialized with the read parameters
	 * @throws FactoryException
	 *             Thrown if there are too few parameters or parameters with a wrong type
	 */

	public Operation create(Scanner scanner) throws FactoryException {

		int[] params = new int[4];
		char pixel = ' ';

		for (int i = 0; i < params.length; i++) {
			// if no next parameter
			if (!scanner.hasNext()) {
				throw new FactoryException("Insufficient parameter");
			}
			params[i] = scanner.nextInt();
		}
		// if no char/pixel parameter
		if (!scanner.hasNext()) {
			throw new FactoryException("Insufficient parameter");
		}

		pixel = scanner.next().charAt(0);
//						x1, 	y1,	x2,		y2, char 
		return new LineOperation(params[0], params[1], params[2], params[3], pixel);
	}
}
