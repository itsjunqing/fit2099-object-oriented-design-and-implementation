
/**
 * Interface for classes that implements the notion of a mathematical set.
 * We will allow any kind of Java object to be contained by the set. The set
 * has methods that allow an object to be inserted into the set, deleted from
 * the set, and for the set to be queried as to whether it contains an object.
 * 
 */
public interface Set {
	
	public void insert(Object o);
	public void delete(Object o);
	public boolean contains(Object o);

}
