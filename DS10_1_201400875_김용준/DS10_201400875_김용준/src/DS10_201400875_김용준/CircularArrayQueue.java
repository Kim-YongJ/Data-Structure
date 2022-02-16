package DS10_201400875_±è¿ëÁØ;

public class CircularArrayQueue<E> implements Queue<E> {
	
	private static final int DEFAULT_CAPACITY = 100;
	// Instance Variables
	private int _maxLength; // capacity+1
	private int _frontPosition; 
	private int _rearPosition;
	private E[] _elements;
	// Getters/Setters
	
	private int maxLength() {
		return this._maxLength;
	}
	private void setMaxLength (int newMaxlength) {
		this._maxLength = newMaxlength;
	}
	public int capacity() {
		return (this.maxLength() - 1);
	}
	private int frontPosition() {
		return this._frontPosition;
	}
	private void setFrontPosition(int newFrontPosition) {
		this._frontPosition = newFrontPosition;
	}
	private int rearPosition() {
		return this._rearPosition;
	}
	private void setRearPositin(int newRearPosition) {
		this._rearPosition = newRearPosition;
	}
	@Override
	public int size() {
		if(this.rearPosition() >= this.frontPosition()) {
			return (this.rearPosition() - this.frontPosition());
	}
		else {
			return (this.rearPosition() + this.maxLength() - this.frontPosition()) ;
		}
	}
	
	public boolean isEmpty() {
		if(this.frontPosition() == this.rearPosition()) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean isFull() {
		if(this.frontPosition() == this.rearPosition()+1) {
			return true;
		}
		else {
			return false;
		}
	}	
	public E front() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E frontElement = this._elements[this._frontPosition+1];
			return frontElement;
		}
	}
	public E rear() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			E rearElement = this._elements[this._rearPosition];
			return rearElement;
		}
	}
	
	@SuppressWarnings("unchecked")
	public CircularArrayQueue(int givenCapacity) {
		this.setMaxLength(givenCapacity+1);
		this._elements = ((E[]) new Object[this.maxLength()]);
		this._frontPosition = 0;
		this._rearPosition = 0;
	}
	public CircularArrayQueue() {
		this (CircularArrayQueue.DEFAULT_CAPACITY);
	}
	
	public boolean enQueue(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			this.setRearPositin((this.rearPosition()+1) % this.maxLength());
			this._elements[this._rearPosition] = anElement;
			return true;
		}
	}
	public E deQueue() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			this._frontPosition++;
			E frontElement = this._elements[this._frontPosition];
			this._elements[this._frontPosition] = null;
			return frontElement;
		}
	}
	public void clear() {
		this._frontPosition = 0;
		this._rearPosition = 0;
		this._elements = null;
	}
	
	public E elementAt(int anOrder) {
		if(anOrder < 0 || anOrder > this.size()) {
			return null;
		}
		else { 
			return this._elements[anOrder];
		}
	}
	
	public Iterator<E> iterator() {
		return (new CircularArrayQueueIterator());
	}
	
	private class CircularArrayQueueIterator implements Iterator<E> {
		private int _nextOrder;
		
		private int nextOrder() {
			return this._nextOrder;
		}
		private void setNextOrder(int newNextOrder) {
			this._nextOrder = newNextOrder;
		}
		private CircularArrayQueueIterator() {
			this.setNextOrder(0);
		}
		
		@Override
		public boolean hasNext() {
			return (this.nextOrder() < CircularArrayQueue.this.size());
		}
		@Override
		public E next() {
			E nextElement = null;
			if(this.hasNext()) {
				nextElement = CircularArrayQueue.this.elementAt(this.nextOrder());
				this.setNextOrder(this.nextOrder()+1);
			}
			return nextElement;
		}
	}
}
