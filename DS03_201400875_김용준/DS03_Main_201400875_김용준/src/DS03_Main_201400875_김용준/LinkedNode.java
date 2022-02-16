package DS03_Main_201400875_김용준;

public class LinkedNode<E> {
	
	private E				_element; // 현재 노드에 있는 코인
	private LinkedNode<E>	_next; // 다음 노드
	
	public LinkedNode() {
		this.setElement(null);
		this.setNext(null);
	}
	public LinkedNode(E givenElement) {
		this.setElement(givenElement);
		this.setNext(null);
	}
	public LinkedNode(E givenElement, LinkedNode<E> givenNext) {
		this.setElement(givenElement);
		this.setNext(givenNext);
	}
	
	public E element() {
		return this._element;
	}
	public LinkedNode<E> next() {
		return this._next;
	}
	public void setElement(E newElement) {
		this._element = newElement;
	}
	public void setNext(LinkedNode<E> newNext) {
		this._next = newNext;
	}

}
