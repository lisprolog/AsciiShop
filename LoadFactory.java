import java.util.Scanner;

/**
 * This Class provides a method to create a new LoadOperation. It implements the Factory
 * interface.
 */

public class LoadFactory implements Factory {

	public LoadFactory() {
	}

	/**
	 * This method reads the two required parameter for a LoadOperation and creates a new
	 * LoadOperation.
	 * 
	 * @param scanner
	 *            The Scanner to use for reading parameters
	 * @return A new LoadOperation that is initialized with the read parameters
	 * @throws FactoryException
	 *             Thrown if there are too few parameters or parameters with a wrong type
	 */

	public Operation create(Scanner scanner) throws FactoryException {

		if (!scanner.hasNext()) {
			throw new FactoryException("Insufficient parameter");
		}

		String data = "";
		String eof = "";
		int count = 0;
		boolean stop = false;

		int height, compareWidth = 0;
		String temp = "";
		String compareString = "";
		boolean setWidth = false;

		eof = scanner.next();
		do{
			temp = scanner.next();
//				set CompareWidth for the first time
			if(setWidth == false){ 
				compareWidth = temp.length();
				setWidth = true;
			}
			if(temp.length() == compareWidth){
				data += temp;
			}
			data += '\n';
		}while(scanner.hasNext() && !temp.equals(eof));
		return new LoadOperation(data);
	}
}
