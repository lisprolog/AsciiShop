import java.util.LinkedHashSet;
import java.util.Collection;
import java.util.Iterator;

/**
  	This generic class implements a LinkedHashSet, 
	look in a set with a metric for certain objects. */

public class MetricSet<E> extends LinkedHashSet<E>{

	LinkedHashSet<E> hs;
	MetricSet<E> resultMetric;
	Iterator<E> it;

	public MetricSet(){
	}

/**	fills the MetricSet with a collection */
	public MetricSet(Collection<? extends E> c){
		
		hs = new LinkedHashSet<E>();
		hs.addAll(c);
	}

/**	returns a new MetricSet including elements with minimum distance to e. 
	possibly only one element the set. m is a metric for defining the distance.*/
	public MetricSet<E> search(E e, Metric<? super E> m){
		E tempObject;
 	 	it = hs.iterator();
		int tempDistance = 0;
		int minDistance = 0;
		while(it.hasNext()){
			tempObject = it.next();
			tempDistance = m.distance(e, tempObject);
			if(tempDistance <= minDistance){
				minDistance = tempDistance;
				resultMetric.add(tempObject);
			}
		}
		return resultMetric;
	}

	//******************java.util.LinkedHashSet*******************************

//	public boolean add(E e){		
//	}

//	public boolean addAll(Collection<? extends E> col){
//	}

//	public boolean contains(Object o){
//	}

//	public Iterator<E> iterator(){
//	}
	
}
