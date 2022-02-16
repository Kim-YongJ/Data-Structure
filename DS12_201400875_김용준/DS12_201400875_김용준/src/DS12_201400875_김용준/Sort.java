package DS12_201400875_±è¿ëÁØ;

public abstract class Sort<E extends Comparable<E>> {
	
	protected void swap(E[] aList, int i, int j) {
		E tempElement = aList[i];
		aList[i] = aList[j];
		aList[j] = tempElement;
	}
	// Constructor
	protected Sort() {}	
	// Public Method
	public abstract boolean sort(E[] aList, int aSize);
}
