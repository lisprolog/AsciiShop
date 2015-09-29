import java.util.Scanner;

/**
 * This Class provides a method to create a new ClearOperation. 
 * It implements the Factory interface.
 */

public class ClearFactory implements Factory{

	public ClearFactory(){
	}

	/**
	 * @return A new ClearOperation
	 * @throws FactoryException
	 *             Thrown if there are any parameters
	 */

	public ClearOperation create(Scanner scanner)throws FactoryException{

			return new ClearOperation();
	}
}
