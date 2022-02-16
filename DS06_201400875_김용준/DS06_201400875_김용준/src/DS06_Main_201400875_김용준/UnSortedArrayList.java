package DS06_Main_201400875_±è¿ëÁØ;

public class UnSortedArrayList<E extends Comparable<E>> {
	private static final int DEFAULT_CAPACITY = 100;
	
	private int _capacity;
	private int _size;
	private E[] _elements;
	
	public int capacity() {
		return this._capacity;
	}
	public void setCapacity(int newCapacity) {
		this._capacity = newCapacity;
	}
	public int size() {
		return this._size;
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	private E[] elements() {
		return  this._elements;
	}
	private void setElements(E[] newElements) {
		this._elements = newElements;
	}
	public E elementAt(int order) {
		if(this.anElementDoesExistAt(order)) {
			int position = order;
			return this._elements[position];
		}
		else {
			return null;
		}
	}
	private boolean anElementDoesExistAt(int order) {
		return ((order >= 0) && (order < this.size()));
	}
	public E max() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E maxElement = this.elements()[0];
			for(int i = 1; i < this.size(); i++) {
				if(maxElement.compareTo(this.elements()[i]) < 0) {
					maxElement = this.elements()[i];
				}
			}
			return maxElement;
		}
	}
	@SuppressWarnings("uncheked")
	public UnSortedArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()]);
	}
	public UnSortedArrayList() {
		this (UnSortedArrayList.DEFAULT_CAPACITY);
	}
	public boolean doesContain(E anElement) {
		for(int i = 0; i < this.size(); i++) {
			if(this.elements()[i].equals(anElement)) {
				return true;
			}
		}
		return false;
	}
	public int frequencyOf(E anElement) {
		int frequencyCount = 0 ;
		for(int i = 0; i < this.size(); i++) {
			if(this.elements()[i].equals(anElement)) {
				frequencyCount++;
			}
		}
		return frequencyCount;
	}
	public int orderOf(E anElement) {
		for(int order = 0; order < this.size(); order++) {
			if(this.elements()[order].equals(anElement)) {
				return order;
			}
		}
		return -1;
	}
	public boolean addTo(E anElement, int anOrder) {
		if(this.isFull()) {
			return false;
		}
		else if(anOrder < 0 || anOrder > this.size()) {
			return false;
		}
		else {
			this.makeRoomAt(anOrder);
			this.elements()[anOrder] = anElement;
			this.setSize(this.size()+1);
			return true;
		}
	}
	public boolean addToFirst(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.makeRoomAt(0);
			this._elements[0] = anElement;
			this._size++;
			return true;
		}
	}
	public boolean addToLast(E anElement) {
		return this.addTo(anElement, this.size());
	}
	public boolean add(E anElement) {
		return this.addToLast(anElement);
	}
	private void makeRoomAt(int aPosition) {
		for(int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i-1];
		}
	}
	public E removeFrom(int anOrder) {
		if(anOrder < 0 || anOrder >= this.size()) {
			return null;
		}
		else {
			E removedElement = this.elements()[anOrder];
			this.removeGapAt(anOrder);
			this.setSize(this.size()-1);
			return removedElement;
		}
	}
	private void removeGapAt(int aPosition) {
		for(int i = aPosition + 1; i < this.size(); i++) {
			this.elements()[i-1] = this.elements()[i];
		}
		this.elements()[this.size()-1] = null;
	}
	
	public boolean isEmpty() {
		return (this._size == 0);
	}
	public boolean isFull() {
		return (this._size == this._capacity);
	}
	public E first() {
		return this._elements[0];
	}
	public E last() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this._elements[this.size()-1];
		}
	}

	public E removeFirst() {
		return removeFrom(0);
	}
	public E removeLast() {
		return removeFrom(this._size-1);
	}
	public E removeAny() {
		return removeLast();
	}
	public boolean replaceAt(E anElement, int anOrder) {
		if(this.anElementDoesExistAt(anOrder)) {
			this._elements[anOrder] = anElement;
			return true;
		}
		else {
			return false;
		}
	}
	public void clear() {
		for(int i = 0; i < this.size(); i++) {
			this._elements[i] = null;
		}
		this._size = 0;
	}
	

}
