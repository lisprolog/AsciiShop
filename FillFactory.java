import java.util.Scanner;

/**
 * This Class provides a method to create a new FillOperation. It implements the Factory
 * interface.
 */

public class FillFactory implements Factory {

	public FillFactory() {
	}

	/**
	 * This method reads the three required parameter for a FillOperation(x,y,char) and creates a new
	 * FillOperation.
	 * 
	 * @param scanner
	 *            The Scanner to use for reading parameters
	 * @return A new FillOperation that is initialized with the read parameters
	 * @throws FactoryException
	 *             Thrown if there are too few parameters or parameters with a wrong type
	 */
	
	public Operation create(Scanner scanner) throws FactoryException {

		/* check int parameters */
		int[] paramInt = new int[2];

		for (int i = 0; i < paramInt.length; i++) {
			if (!scanner.hasNextInt()) {
				throw new FactoryException("Insufficient parameter");
			}
			
			paramInt[i] = scanner.nextInt();
			if (paramInt.length > 2) {
				throw new FactoryException("Insufficient parameter");
			}
		}

		/* check char parameter */
		char[] paramC = new char[1];

		for (int i = 0; i < paramC.length; i++) {
			if (!scanner.hasNext()) {
				throw new FactoryException("Insufficient parameter");
			}
			String s = scanner.next();
			if (s.length() > 2) {
				throw new FactoryException("Insufficient parameter");
			}
			paramC[i] = s.charAt(0);
		}
		return new FillOperation(paramInt[0], paramInt[1], paramC[0]);
	}
}
