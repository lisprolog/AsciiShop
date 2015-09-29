import java.util.Scanner;

/**
 * This interface is implemented by all Operations. It defines a method to
 * execute an Operation.
 */

public interface Factory{
	
	/**
	 * Executes this factory and returns the result as new Operation. The passed Scanner is
	 * not modified by this interface. If there are arguments required, they need to be passed via the
	 * constructor.
	 * 
	 * @param scanner
	 *            The Scanner to use as basis for executing the Factory, it will remain
	 *            unchanged
	 * @return A new Operation reflecting the result of the executed Operation
	 * @throws FactoryException
	 *             Thrown if a problem occurs, while executing the Factory
	 */
	
	public Operation create(Scanner scanner) throws FactoryException;
}
