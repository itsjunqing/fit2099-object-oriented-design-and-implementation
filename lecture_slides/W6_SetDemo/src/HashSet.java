import java.util.HashMap;

public class HashSet implements Set {

	// We will store the contents of the set in a HashMap
	private HashMap<Object, Boolean> setContents = new HashMap<Object, Boolean>();
	
	public void insert(Object o) {
		if (!contains(o)) {
			setContents.put(o, true);
		}
	}
	
	public void delete(Object o) {
		setContents.remove(o);
	}
	
	public boolean contains(Object o) {
		return setContents.containsKey(o);
	}
	
	public String toString() {
		
		String result = "{ ";
		String prefix = "";
		for (Object o : setContents.keySet()) {
			result += prefix + o.toString();
			prefix = ", ";
		}
		result += " }";
		return result;
	}
}
