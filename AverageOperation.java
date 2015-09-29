import java.util.Arrays;

public class AverageOperation extends FilterOperation{	

/**
  * 	Uses average filter to clean the image.
  * 	@param bg 
  * 	@return Average filtered AsciiImage
  * 	@throws OperationException
  */

	public AverageOperation(BlockGenerator bg){
		b1 = bg;
	}


	public int filter(int[] values){

		// sort array
		Arrays.sort(values);

		double result = 0;

		for(int i = 0; i < values.length; i++){
			result += values[i];
		}

		result = Math.round(result/values.length);

		return (int)result;
	}

	public BlockGenerator getBlockGenerator(){
		return b1;
	}
}
