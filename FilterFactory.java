import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

/**
 * This Class provides a method to create a new FilterOperation. It implements the Factory
 * interface.
 * 
 */

public class FilterFactory implements Factory{

	BlockGenerator b1;
	Operation o1;

	/**
	 * Default constructor creates a new FilterFactory.
	 */

	public FilterFactory(){
	}

	/**
	 * This method reads the required parameter(ex: median) for a FilterOperation and creates a new
	 * FilterOperation.
	 * 
	 * @param scanner
	 *            The Scanner to use for reading parameters
	 * @return A new FilterOperation that is initialized with the read parameters
	 * @throws FactoryException
	 *             Thrown if there are too few parameters or parameters with a wrong type
	 */

	public Operation create(Scanner scanner) throws FactoryException{

		String check;
		String[] line = new String[3];
		String filter; 
		String edgecase = "x"; 
		int range;

		check = scanner.nextLine();
		line = check.split(" ");
		// line[0] = Factory command: "filter"
		filter = line[1];

		try{
			range = Integer.parseInt(line[2]);
		}catch(Exception e){
			range = 3;
		}

		try{
			if(line[2].equals("x")||line[2].equals("replicate")||line[2].equals("circular")||line[2].equals("symmetric")){
			edgecase = line[2];
			}else if(line[3].equals("x")||line[3].equals("replicate")||line[3].equals("circular")||line[3].equals("symmetric")){
			edgecase = line[3];
			}
		}catch(Exception e){
			edgecase = "x";
		}			
	
/*1.7*/		HashMap<String, BlockGenerator> blockMap = new HashMap<String, BlockGenerator>();

/*1.6*/	//	HashMap blockMap = new HashMap();

		blockMap.put("x", new XBlockGenerator(range));
		blockMap.put("replicate", new ReplicateBlockGenerator(range));
		blockMap.put("circular", new CircularBlockGenerator(range));
		blockMap.put("symmetric", new SymmetricBlockGenerator(range));

		BlockGenerator b1 = blockMap.get(edgecase);

		if(filter.equals("median")){
			o1 = new MedianOperation(b1);
		}else if(filter.equals("average")){
			o1 = new AverageOperation(b1);
		}
		return o1;
	}
}
