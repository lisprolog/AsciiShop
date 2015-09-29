import java.util.Scanner;

/**
 * This Class provides a method to create a new ReplaceOperation. It implements the Factory
 * interface.
 */

public class GrowRegionFactory implements Factory {


	public GrowRegionFactory(){
	}

	/**
	 * This method reads the two required parameter for a ReplaceOperation and creates a new
	 * ReplaceOperation.
	 * 
	 * @param scanner
	 *            The Scanner to use for reading parameters
	 * @return A new ReplaceOperation that is initialized with the read parameters
	 * @throws FactoryException
	 *             Thrown if there are too few parameters or parameters with a wrong type
	 */

	public Operation create(Scanner scanner) throws FactoryException {

		char param = ' ';

		if (!scanner.hasNext()) {
			throw new FactoryException("Insufficient parameter");
		}
		param = scanner.next().charAt(0);
		return new GrowRegionOperation(param);
	}
}
