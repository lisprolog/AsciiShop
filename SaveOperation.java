import java.util.Iterator;

public class SaveOperation implements Operation{

	MetricSet<AsciiImage> ms;

	/** saved is a reference on a metricSet, filled with AsciiImages.*/	
	public SaveOperation(MetricSet<AsciiImage> saved){
		this.ms = saved;
	}

	/** saves the AsciiImage, adds the image to the metricSet of this constructor. 
		(if (img2.equals(img) || img == null object) will not add). 
	*/

	public AsciiImage execute(AsciiImage img)throws OperationException{
		boolean noClone = true;
		Iterator it = ms.iterator();
		if(img == null){
			noClone = false;	// set boolean false, if img is null, no need to go throw MetricSet anymore
		}
		while(it.hasNext() && noClone){
			if(it.next().equals(img)){
				noClone = false;
			}
		}
		if(noClone){
			ms.add(img);
		}
		return img;
	}

	public MetricSet<AsciiImage> getSaved(){
		return ms;
	}
}
