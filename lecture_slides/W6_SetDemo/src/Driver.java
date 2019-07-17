
public class Driver {

	public static void main(String[] args) {
		
		Set set = new ArraySet();
		/* Note that the method testSet(...) has no knowledge of the
		 * concrete class of the object passed to it. All it knows is that
		 * it will implement the interface "Set".
		 */
		System.out.println("Test an ArraySet:");
		testSet(set);
		set = new HashSet();
		System.out.println("\nTest a HashSet:");
		testSet(set);

	}
	
	public static void testSet (Set set) { 
		
		testInsert(set, 2);
		testInsert(set, 4);
		testInsert(set, 6);
		testInsert(set, 8);
		testInsert(set, 6);
		System.out.println(set);
		
		 testDelete(set, 2);
		System.out.println(set);
		
		 testDelete(set, 4);
		System.out.println(set);
		
		 testDelete(set, 4);
		System.out.println(set);
		
		 testDelete(set, 8);
		System.out.println(set);
		
		testInsert(set, 8);
		testInsert(set, 6);
		System.out.println(set);
		
		for (int i : new int[]{2, 8, 9, 6}) {
			if (set.contains(i)) {
				System.out.println("Set contains " + i);
			}
			else {
				System.out.println("Set does not contain " + i);
			}
		}
		testInsert(set, 10);
		testInsert(set, 11);
		testInsert(set, "frog");
		testInsert(set, 12);
		testInsert(set, 13);
		testInsert(set, 14);
		testInsert(set, 15);
		testInsert(set, 16);
		testInsert(set, 17);
		testInsert(set, 6);
		System.out.println(set);
		 testDelete(set, "frog");
		System.out.println(set);
	}
	
	private static void testInsert(Set set, Object o) {
		System.out.println("Inserting: " + o);
		set.insert(o);
	}
	
	private static void testDelete(Set set, Object o) {
		System.out.println("Deleting: " + o);
		set.delete(o);
	}

}
