package DS06_Main_201400875_±è¿ëÁØ;

public class SortedArrayList<E extends Comparable<E>> {
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
	public void setSize(int newSize) {
		this._size = newSize;
	}
	public E[] elements() {
		return this._elements;
	}
	public void setElements (E[] newElements) {
		this._elements = newElements;
	}
	public SortedArrayList () {
		this(SortedArrayList.DEFAULT_CAPACITY);
	}
	
	@SuppressWarnings("unchecked")
	public SortedArrayList(int givenCapacity) {
	this.setCapacity(givenCapacity);
	this.setElements((E[]) new Comparable[this.capacity()]);
	}

	private void makeRoomAt(int aPosition) {
		for(int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i-1];
		}
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
	public boolean add(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			if(this.isEmpty()) {
				return this.addToFirst(anElement);
			}
			else {				
				this.makeRoomAt(0);
				this.elements()[0] = anElement;
				this.setSize(this.size()+1);
				while(true) {
					for(int i = 0; i < this.size(); i++) {					
						if(this.elements()[i].compareTo(anElement) > 0) {
							break;
						}
						else {
							E sta = this.elements()[i];
							this.elements()[i] = this.elements()[i+1];
							this.elements()[i+1] = sta;
						}	
					}
				}
			}
		}
	}
	public boolean isEmpty() {
		return (this._size == 0);
	}
	public boolean isFull() {
		return (this._size == this._capacity);
	}
	public E max() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.elements()[this.size()-1];
		}
	}
}

