import java.util.Scanner;

/**
 * This Class provides a method to create a new TransposeOperation. It implements the Factory
 * interface.
 */

public class TransposeFactory implements Factory {

	public TransposeFactory() {
	}

	/**
		TransposeOperations doesn't need parameters from scanner and throws the exception
		if TransposeOperation cannot be created.
	*/

	public Operation create(Scanner scanner) throws FactoryException {

		return new TransposeOperation();
	}
}
