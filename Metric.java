/**
 * A distance function, i.e., a (mathematical) metric or semimetric. 
 */
public interface Metric<T> {
    /**
     * Calculates the distance between two arguments. The result can be used
     * as a measure of similarity. The implementor must ensure that the following
     * properties of a metric are fulfilled:
     * 1.) distance(x,y) >= 0. It is also required that distance(x,y) == 0, 
     * 		if x.equals(y). Note that distance(x,y) == 0 might hold, 
     * 		even if !x.equals(y) (semimetric).
     * 2.) Symmetry: distance(x,y) == distance(y,x)
     * 3.) Triangle inequality: distance(x,y) <= distance(x,z) + distance(z,y)
     * @param o1 the first argument
     * @param o2 the second argument
     * @return the distance
     */
	public int distance(T o1, T o2); 
}
