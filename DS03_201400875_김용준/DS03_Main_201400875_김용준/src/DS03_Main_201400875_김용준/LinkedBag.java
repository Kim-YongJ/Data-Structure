package DS03_Main_201400875_�����;

public class LinkedBag<E> {
	
	private int				_size;
	private LinkedNode<E> 	_head; // LinkedBag�� ���ҵ��� ���� Linked Chain
	
	public LinkedBag() {
		this.setSize(0);
		this.setHead(null);
	}
	
	public int size() { // ���� �Լ�
		return this._size;
	}
	private void setSize(int newSize) { // Class ���ο����� ���
		this._size = newSize;
	}
	private LinkedNode<E> head() {
		return this._head;
	}
	
	private LinkedNode<E> setHead(LinkedNode<E> newHead) {
		return this._head = newHead;
	}
	
	public boolean isEmpty() {
		return (this.head() == null);
	}
	public boolean isFull() {
		return false;
    }
	
	public boolean doesContain(E anElement) { // �־��� ���Ұ� Bag�� �ִ��� �˷��ش�.
		LinkedNode<E> currentNode = this.head();
		while(currentNode != null) {
			if(currentNode.element().equals(anElement)) {
				return true;
			}
			currentNode = currentNode.next();
		}
		return false;
	}
	public E any() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.head().element();
		}
	}
	public int frequencyOf(E anElement) { // �־��� ���Ұ� Bag�� ����� �˷��ش�.
		int frequencyCount = 0;
		LinkedNode<E> currentNode = this._head;
		while(currentNode != null) {
			if(currentNode.element().equals(anElement)) {
				frequencyCount++;
			}
			currentNode = currentNode.next();
		}
		return frequencyCount;
	}
	
	public boolean add(E anElement) { // Bag�� �־��� ���Ҹ� �ִ´�.
		if(this.isFull()) {	
			return false;
		}
		else { // ���濡 �ڸ��� �ִ°�� ���濡 �ڸ��� ä�� �����ǵ�, ���� Ȯ���ϰ� ä�� �� �ִ� ���� ������ ������ ���� ĭ!
			LinkedNode<E> newNode = new LinkedNode<E>();
			newNode.setElement(anElement);
			newNode.setNext(this.head());
			this.setHead(newNode);
			this.setSize(this.size()+1);
			return true;
		}
	}
	
	public E removeAny(E anElement) { // Bag���� ������ ���Ҹ� ã�Ƽ� ������ �����Ѵ�.
		if (this.isEmpty() ){
			return null;
		}
		else {
			E removedElement = this.head().element();
			this.setHead((this.head().next()));
			this.setSize(this.size()-1);
			return removedElement;
		}
	}
	
	public boolean remove(E anElement) { // Bag���� ������ ���Ҹ� ã�Ƽ� ������ �����Ѵ�.
		if(this.isEmpty()) {
			return false;
		}
		else {
			LinkedNode<E> previousNode = null;
			LinkedNode<E> currentNode = this._head;
			boolean found = false; // ù ��° �ܰ� : ������ ��ġ ã��
			while(currentNode != null && !found) {
				if(currentNode.element().equals(anElement)) {
					found = true;
				}
				else {
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			
			// �� ��° �ܰ� �����ϱ�
			if(!found) {
				return false;
			}
			else {
				if(currentNode == this.head()) {
					this.setHead(this.head().next());
				}
				else {
					previousNode.setNext(currentNode.next());
				}	
					this.setSize(this.size()-1);
					return true;
			}
		}
	}
	public void clear() { // Bag�� ����.
		this.setSize(0);
		this.setHead(null);
	}
	
	public E elementAt(int anOrder) {
		if( (0 <= anOrder) || (anOrder < this.size())) {
			LinkedNode<E> currentNode = this.head();
			for(int i = 0; i < anOrder; i++) {
				currentNode = currentNode.next();
			}
			return currentNode.element();
		}
		else {
			return null;
		}
	}

}
