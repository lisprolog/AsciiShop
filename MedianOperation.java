import java.util.Arrays;
/**
 * This interface is implemented by all Operations. It defines a method to execute an Operation.
 */

public class MedianOperation extends FilterOperation {

	public MedianOperation(BlockGenerator bg){
		b1 = bg;
	}

	/**
	 * goes throw every pixel and use median filter (!= arithmetic mean) to clean the image.
	 * @param img
	 *            The AsciiImage to use as basis for executing the Operation, it will remain
	 *            unchanged
	 * @return A new AsciiImage reflecting the result of the Median Operation
	 * @throws OperationException
	 *             Thrown if a problem occurs, while executing the Operation
	 */

	public int filter(int[] values){

		// sort array
		Arrays.sort(values);
		int result = Math.round(values.length/2);
		return values[result];
	}

	public BlockGenerator getBlockGenerator(){
		return b1;
	}
}
