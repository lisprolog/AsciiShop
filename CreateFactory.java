import java.util.Scanner;

public class CreateFactory implements Factory{
	
	public CreateFactory(){
	}

	/** reads int width int height and String charset from scanner and returns initialised CreateOperation
		if too few or wrong parameters: FactoryException .*/

	public Operation create(Scanner scanner) throws FactoryException{
		int width = 0;
		int height = 0;
		String charSet = "";
		if(scanner.hasNextInt()){
			width = scanner.nextInt();
		}
		if(scanner.hasNextInt()){
			height = scanner.nextInt();
		}
		if(scanner.hasNext()){
			charSet = scanner.next();
		}
		CreateOperation o1 = new CreateOperation(width, height, charSet);
		return o1;		
	}

}
