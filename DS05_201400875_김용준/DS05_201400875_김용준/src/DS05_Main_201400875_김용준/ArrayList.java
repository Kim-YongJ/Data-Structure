package DS05_Main_201400875_김용준;

public class ArrayList<E> {
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
	
	@SuppressWarnings("uncheked")
	public ArrayList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Object[this.capacity()]);
	}
	public ArrayList() {
		this (ArrayList.DEFAULT_CAPACITY);
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
		return this.addToLast(anElement); // 가장 효과적인 곳에 삽입 // 강의에선 addToLast, 실습ppt 출력결과는 addToFirst Why?
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
			return(this.nextPosition() < ArrayList.this.size());
		}
		
		@Override
		public E next() {
			E nextElement = null;
			if(this.hasNext()) {
				nextElement = ArrayList.this.elements()[this.nextPosition()];
				this.setNextPosition(this.nextPosition()+1);
			}
			return nextElement;
		}
	}

	public Iterator<E> iterator() {
		return (new ListIterator());
	}
}
