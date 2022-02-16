package DS03_Main_201400875_김용준;

public class LinkedBag<E> {
	
	private int				_size;
	private LinkedNode<E> 	_head; // LinkedBag의 원소들을 담을 Linked Chain
	
	public LinkedBag() {
		this.setSize(0);
		this.setHead(null);
	}
	
	public int size() { // 공개 함수
		return this._size;
	}
	private void setSize(int newSize) { // Class 내부에서만 사용
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
	
	public boolean doesContain(E anElement) { // 주어진 원소가 Bag에 있는지 알려준다.
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
	public int frequencyOf(E anElement) { // 주어진 원소가 Bag에 몇개인지 알려준다.
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
	
	public boolean add(E anElement) { // Bag에 주어진 원소를 넣는다.
		if(this.isFull()) {	
			return false;
		}
		else { // 가방에 자리가 있는경우 가방에 자리를 채워 넣을건데, 가장 확실하게 채울 수 있는 곳은 마지막 원소의 다음 칸!
			LinkedNode<E> newNode = new LinkedNode<E>();
			newNode.setElement(anElement);
			newNode.setNext(this.head());
			this.setHead(newNode);
			this.setSize(this.size()+1);
			return true;
		}
	}
	
	public E removeAny(E anElement) { // Bag에서 지정된 원소를 찾아서 있으면 제거한다.
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
	
	public boolean remove(E anElement) { // Bag에서 지정된 원소를 찾아서 있으면 제거한다.
		if(this.isEmpty()) {
			return false;
		}
		else {
			LinkedNode<E> previousNode = null;
			LinkedNode<E> currentNode = this._head;
			boolean found = false; // 첫 번째 단계 : 삭제할 위치 찾기
			while(currentNode != null && !found) {
				if(currentNode.element().equals(anElement)) {
					found = true;
				}
				else {
					previousNode = currentNode;
					currentNode = currentNode.next();
				}
			}
			
			// 두 번째 단계 삭제하기
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
	public void clear() { // Bag을 비운다.
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
