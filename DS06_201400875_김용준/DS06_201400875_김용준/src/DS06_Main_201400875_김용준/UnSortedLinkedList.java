package DS06_Main_201400875_김용준;


public class UnSortedLinkedList<E extends Comparable<E>> {
	private static final int DEFAULT_CAPACITY = 100;
	
	private int _capacity;
	private int _size;
	private E[] _elements;
	private LinkedNode<E> _head;
	
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
	
	private LinkedNode<E> head() {
		return this._head;
	}
	
	private void setHead(LinkedNode<E> newHead) {
		this._head = newHead;
	}
	public E max() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.elements()[this.size()-1];
		}
	}
	public E elementAt(int order) {
		if(this.anElementDoesExistAt(order)) {
			LinkedNode<E> currentNode = this._head;
			int nodeCount = 0;
			while(nodeCount < order) {
				currentNode = currentNode.next();
				nodeCount++;
			}
			return currentNode.element();
		}
		else {
			return null;
		}
	}
	
	private boolean anElementDoesExistAt(int order) {
		return ((order >= 0) && (order < this.size()));
	}
	
	@SuppressWarnings("uncheked")
	public UnSortedLinkedList(int givenCapacity) {
		this.setCapacity(givenCapacity);
		this.setElements((E[]) new Comparable[this.capacity()]);
	}
	
	public UnSortedLinkedList() {
		this (UnSortedLinkedList.DEFAULT_CAPACITY);
	}
	
	public boolean doesContain(E anElement) {
		LinkedNode<E> currentNode = this._head;
		while(currentNode != null) {
			if(currentNode.element().equals(anElement)) {
				return true;
			}
			currentNode = currentNode.next();
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
		int order = 0;
		LinkedNode<E> currentNode = this._head;
		while(currentNode != null && (! currentNode.element().equals(anElement))) {
			order++;
			currentNode = currentNode.next();
		}
		if(currentNode == null) {
			return -1;
		}
		else {
			return order;
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
			LinkedNode<E> nodeForAdd = new LinkedNode<E> (anElement, null);
			if(anOrder == 0) {
				nodeForAdd.setNext(this._head);
				this._head = nodeForAdd;
			}
			else {
				LinkedNode<E> previousNode = this._head;
				for(int i = 1; i < anOrder; i++) {
					previousNode = previousNode.next();
					
				}
				nodeForAdd.setNext(previousNode.next());
				previousNode.setNext(nodeForAdd);
			}
			this._size++;
			return true;
		}
	}
	
	public boolean addToFirst(E anElement) {
		if(this.isFull()) {
			return false;
		}
		else {
			LinkedNode<E> nodeForAdd = new LinkedNode<E> (anElement, this._head);
			this._head = nodeForAdd;
			this._size++;
			return true;
		}
	}
	
	public boolean addToLast(E anElement) {
		return this.addTo(anElement, this.size());
	}
	
	public boolean add(E anElement) {
		return this.addToFirst(anElement); // 가장 효과적인 곳에 삽입 // LinkedList에서는 앞에추가 맨뒤에넣으면 빈자리를 찾아야되기때문에 귀찮다.
	}
	
	private void makeRoomAt(int aPosition) {
		for(int i = this.size(); i > aPosition; i--) {
			this.elements()[i] = this.elements()[i-1];
		}
	}
	
	public E removeFrom(int anOrder) {
		if(!this.anElementDoesExistAt(anOrder)) {
			return null;
		}
		else {
			LinkedNode<E> removedNode = null;
			if(anOrder == 0) {
				removedNode = this._head;
				this._head = this._head.next();
			}
			else {
				LinkedNode<E> previousNode = this._head;
				for(int i = 1; i < anOrder; i++) {
					previousNode = previousNode.next();
				}
				removedNode = previousNode.next();
				previousNode.setNext(removedNode.next());
			}
			this._size--;
			return removedNode.element();
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
		return removeFirst();
	}
	
	public boolean replaceAt(E anElement, int anOrder) {
		if(! this.anElementDoesExistAt(anOrder)) {
			return false;
		}
		else {
			LinkedNode<E> currentNode = this._head;
			for(int i = 0; i < anOrder; i++) {
				currentNode = currentNode.next();
			}
			currentNode.setElement(anElement);
			return true;
		}
	}
	
	public void clear() {
		for(int i = 0; i < this.size(); i++) {
			this._elements[i] = null;
		}
		this._size = 0;
	}
	
	public boolean remove(E anElement) {
		int orderOfRemove = this.orderOf(anElement);
		if(orderOfRemove < 0) {
			return false;
		}
		else {
			this.removeFrom(orderOfRemove);
			return true;
		}
	}
}