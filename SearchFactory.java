import java.util.Scanner;
import java.util.HashMap;

public class SearchFactory implements Factory{

	/**saved is a reference on a metricSet */
	MetricSet<AsciiImage> ms;

	public SearchFactory(MetricSet<AsciiImage> saved){
		this.ms = saved;
	}

	/** get the metric from Scanner(uniqueChars or pixelcount) to instantiate a searchOperation 
		 
		if String cannot be read, the String is unknown, throw FactoryException, 
	*/

	public Operation create(Scanner scanner)throws FactoryException{

		Metric m1;
		SearchOperation o1;
		String metric = scanner.next();

		HashMap<String, Metric<AsciiImage>> hm = new HashMap<String, Metric<AsciiImage>>();

		hm.put("pixelcount", new PixelCountMetric());
		hm.put("uniquechars", new UniqueCharsMetric());

		o1 = new SearchOperation(ms, hm.get(metric));
		return o1;
	}	
}
