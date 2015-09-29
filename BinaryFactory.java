import java.util.Scanner;

/**
  * 	This Class provides a method to create a new BinaryOperation. It implements the Factory interface. 
  */

public class BinaryFactory implements Factory {


	public BinaryFactory(){
	}
	
	/**
	 * BinaryFactory reads the required parameter for a BinaryOperation and creates a new
	 * BinaryOperation.
	 * 
	 * @param scanner
	 *            get threshold parameter to initialize BinaryOperation
	 * @return BinaryOperation
	 * @throws FactoryException
	 *             Thrown if no parameter given or given parameter is not included in charset
	 */

	public Operation create(Scanner scanner) throws FactoryException{

		// need to check if inside charset

		char[] param = new char[1];

		for (int i = 0; i < param.length; i++) {
			if (!scanner.hasNext()) {
				throw new FactoryException("Insufficient parameter");
			}
			String s = scanner.next();
			if (s.length() > 1) {
				throw new FactoryException("Insufficient parameter");
			}
			param[0] = s.charAt(0);
		}
		return new BinaryOperation(param[0]);
	}
}
