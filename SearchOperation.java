import java.util.LinkedHashSet;
import java.util.Collection;
import java.util.Iterator;

public class SearchOperation implements Operation{
	
	MetricSet<AsciiImage> ms = new MetricSet<AsciiImage>();
	Metric<AsciiImage> met;	
	Iterator it;		
	AsciiImage minDistImg;  // minimum distance image
	int tempDistance;	// temporary distance
	int minDistance;	// minimum distance

/**	SearchOperation needs a metric to operate on a metricSet.
	*/

	public SearchOperation(MetricSet<AsciiImage> saved, Metric<AsciiImage> m){
		ms.addAll(saved);
		met = m;
	}

/**	returns an AsciiImage with minimum distance to the given AsciiImage and returns it as Copy. 
	if there are more than one AsciiImages with minimum distance, anyone will be returned. 
	if saved is empty: OperationException */

	public AsciiImage execute(AsciiImage img)throws OperationException{
		it = ms.iterator();
		AsciiImage img2;
		while(it.hasNext()){
			img2 = (AsciiImage)it.next();
			tempDistance = met.distance(img2, img);
			if(minDistImg == null){
				minDistImg = img2;
			}
			if(tempDistance <= minDistance){
				minDistance = tempDistance;
				minDistImg = img2;
			}
		}
		return minDistImg;
	}
}
