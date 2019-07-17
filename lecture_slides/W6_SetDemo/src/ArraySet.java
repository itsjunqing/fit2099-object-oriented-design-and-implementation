public class ArraySet implements Set {

	private int nextInsertPos = 0;
	// We will store the contents of the set in an array
	private Object[] setContents = new Object[2];
	private final int BADINDEX = -1;
	
	public void insert(Object o) {
		
		// Insert object o in the set if it does not already exist
		if (!contains(o)) {
			// first check if there is room to insert the new element of the set
			if (nextInsertPos == setContents.length) {
				/* create a new array double the size of the previous one
				 * and copy the contents of the old one to it. Then change the
				 * setContents attribute to point to the new array
				 */
				Object[] newSetContents = new Object[2*setContents.length];
				for (int i = 0; i < setContents.length; i++) {
					newSetContents[i] = setContents[i];
				}
				setContents = newSetContents;
			}
			// By the time we get to here, we are guaranteed that there will be room
			setContents[nextInsertPos++] = o;
		}
	}
	
	public void delete(Object o) {
		
		int oIndex = indexOf(o);
		if (oIndex != BADINDEX) {
			// Copy the last element of the set over the one to be deleted
			setContents[oIndex] = setContents[nextInsertPos - 1];
			// reduce the effective size by one
			nextInsertPos--;
		}
	}
	
	public boolean contains(Object o) {
		
		return (indexOf(o) != BADINDEX);
	}
	
	@Override
	public String toString() {
		
		String result = "{ ";
		int objPos;
		for (objPos = 0; objPos < nextInsertPos - 1; objPos++) {
			result += setContents[objPos].toString() + ", ";
		}
		result += setContents[objPos].toString() + " }";
		return result;
	}
	
	private int indexOf(Object o) {

		/* Find the position of o in the array. Note we don't look beyond
		 * nextInsertPos, as anything beyond that is either not yet assigned
		 * or rubbish that was previously deleted
		 * Returns index of o in contents array. Returns BADINDEX (-1) if
		 * not found. Dodgy c-like practice, so keep it private.
		 */
		
		boolean found = false;
		int objPos;
		for (objPos = 0; (objPos < nextInsertPos) && !found; objPos++) {
			found = (setContents[objPos] == o);
		}
		if (found) {
			// remember objPos will have been incremented after o was found
			return objPos - 1;
		}
		else {
			return BADINDEX;
		}
	}
	
}
