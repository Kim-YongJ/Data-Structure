package DS07_Main_201400875_±è¿ëÁØ;

public class UnsortedArrayList<E extends Comparable<E>> {
	private static final int DEFAULT_CAPACITY = 100;
	private int _capacity;
	private int _size;
	private E[] _elements;
	
	public int capacity() {
		return this._capacity;
	}
	private void setCapacity(int newCapacity) {
		this._capacity = newCapacity;
	}
	public int size() {
		return this._size;
	}
	private void setSize(int newSize) {
		this._size = newSize;
	}
	protected E[] elements() {
		return this._elements;
	}
	private void setElemenets(E[] newElements) {
		this._elements = newElements;
	}
	@SuppressWarnings("unchecked")
	public UnsortedArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElemenets((E[]) new Comparable[this.capacity()]);
	}
	public UnsortedArrayList() {
		this(UnsortedArrayList.DEFAULT_CAPACITY);
	}
	
	private void makeRoomAt(int aPosition) {
		for(int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i-1];
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
	public boolean doesContain(E anElement) {
		return(this.orderOf(anElement) >= 0);
	}
	public int orderOf(E anElement) {
		int order = -1;
		for(int index = 0; index < this.size() && order < 0; index++) {
			if(this.elements()[index].equals(anElement)) {
				order = index;
			}
		}
		return order;
	}
	public E elementAt(int anOrder) {
		if(anOrder < 0 || anOrder >= this.size()) {
			return null;
		}
		else { 
			return this.elements()[anOrder];
		}
	}
	protected void setElementAt(int anOrder, E anElement) {
		if(anOrder < 0 || anOrder >= this.size()) {
			return ;
		}
		else {
			this.elements()[anOrder] = anElement;
		}
	}
	public boolean addToFirst(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.makeRoomAt(0);
			this.elements()[0] = anElement;
			this.setSize(this.size()+1);
			return true;
		}
	}
	public boolean addToLast(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.elements()[this.size()] = anElement;
			this.setSize(this.size()+1);
			return true;
		}
	}
	public boolean add(E anElement) {
		return this.addToLast(anElement);
	}
	public E removeFirst() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E removedElement = this.elements()[0];
			this.removeGapAt(0);
			this.setSize(this.size()-1);
			return removedElement;
		}
	}
	public E removeLast() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E removedElement = this.elements()[this.size()];
			this.setSize(this.size()-1);
			return removedElement;
		}
	}
	public E removeAny() {
		return this.removeLast();
	}
	public boolean remove(E anElement) {
		int foundIndex = this.orderOf(anElement);
		
		if(foundIndex < 0) {
			return false;
		}
		else {
			this.removeGapAt(foundIndex);
			this.setSize(this.size()-1);
			this._elements[this.size()] = null;
			return true;
		}
	}
	public Iterator<E> iterator() {
		return (new ListIterator());
	}
	private class ListIterator implements Iterator<E> {
		private int _nextPosition;
		
		private int nextPosition() {
			return this._nextPosition;
		}
		private void setNextPosition(int newNextPosition) {
			this._nextPosition = newNextPosition;
		}
		private ListIterator() {
			this.setNextPosition(0);
		}
		@Override
		public boolean hasNext() {
			return (this.nextPosition() < UnsortedArrayList.this.size());
		}
		@Override
		public E next() {
			E nextElement = null;
			if(this.hasNext()) {
				nextElement = UnsortedArrayList.this.elements()[this.nextPosition()];
				this.setNextPosition(this.nextPosition()+1);
			}
			return nextElement;
		}
	}
	
}
