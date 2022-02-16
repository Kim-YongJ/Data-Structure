package DS11_201400875_±è¿ëÁØ;

public class QuickSort<E extends Comparable<E>> extends Sort<E> {
	// Constructor
	public QuickSort() {}
	// Private methods
	private int pivot(E[] aList, int left, int right) {
		return left;
	}
	
	private int partition(E[] aList, int left, int right) {
		int toRight = left;
		int toLeft = right+1;
		E pivot = aList[left];
		int temp;
		do {
			do{toRight++;} while((int) aList[toRight] < (int) pivot);
			do{toLeft--;} while((int) aList[toLeft] > (int) pivot);
			if(toRight < toLeft) {
				swap(aList, toRight, toLeft);
			}
		} while(toRight < toLeft);
		swap(aList, left, toLeft);
		return toLeft;
	}
	
	private void quickSortRecursively(E[] aList, int left, int right) {
		
	}
	
	@Override
	public boolean sort(E[] aList, int aSize) {
		if((aSize < 1) || (aSize > aList.length)) {
			return false;
		}
		int maxLoc = 0;
		for(int i = 1; i < aSize; i++) {
			if(aList[i].compareTo(aList[maxLoc]) > 0) {
				maxLoc = i;
			}
		}
		this.swap(aList, maxLoc, aSize-1);
		this.quickSortRecursively(aList, 0 , aSize-2);
		return true;
	}

}
