package DS10_201400875_�����;

public class AppController {
	
	private static final int QUEUE_CAPACITY = 10;
	// ����� ������
	private Queue<Character> _queue;
	
	private int _inputChars; // �Էµ� ������ ����
	private int _addedChars; // ���Ե� ������ ����
	private int _ignoredChars; // ���õ� ������ ����
	
	// Getters/Setters
	private Queue<Character> queue() {
		return this._queue;
	}
	private void setQueue(Queue<Character> newQueue) {
		this._queue = newQueue;
	}
	private int inputChars() {
		return this._inputChars;
	}
	private void setInputChars(int newInputChars) {
		this._inputChars = newInputChars;
	}
	private int addedChars() {
		return this._addedChars;
	}
	private void setAddedChars(int newAddedChars) {
		this._addedChars = newAddedChars;
	}
	private int ignoredChars() {
		return this._ignoredChars;
	}
	private void setIgnoredChars(int newIgnoredChars) {
		this._ignoredChars = newIgnoredChars;
	}

	public AppController() {
		this.setQueue(new CircularArrayQueue<Character>(AppController.QUEUE_CAPACITY));
		this.setInputChars(0);
		this.setAddedChars(0);
		this.setIgnoredChars(0);
	}
	
	// Ƚ�� ���
	private void countInputChar() {
		this.setInputChars(this.inputChars()+1);
	}
	private void countIgnoredChar() {
		this.setIgnoredChars(this.ignoredChars()+1);
	}
	private void countAddedChar() {
		this.setAddedChars(this.addedChars()+1);
	}
	
	// ť ���� ����
	private void addToQueue(char aCharForAdd) {
		if (this.queue().isFull()) {
			AppView.outputLine("(����) ������ �� ����, �� �̻� ���� �� �����ϴ�.");
		}
		else {
			Character charObjectForAdd = Character.valueOf(aCharForAdd);
			if(this.queue().enQueue(charObjectForAdd)) {
				AppView.outputLine("[EnQ] ���Ե� ���Ҵ� '" + aCharForAdd + "' �Դϴ�.");
			}
			else {
				AppView.outputLine("(����) ť�� �ִ� ���ȿ� ������ �߻��Ͽ����ϴ�.");
			}
		}
	}
	private void removeOne() {
		if(this.queue().isEmpty()) {
			AppView.outputLine("[DeQ.Empty] ť�� ������ ���Ұ� �����ϴ�.");
		}
		else {
			Character removedChar = this.queue().deQueue();
			if(removedChar == null) {
				AppView.outputLine("(����) ť���� �����ϴ� ���ȿ� ������ �߻��Ͽ����ϴ�.");
			}
			else {
				AppView.outputLine("[DeQ] ������ ���Ҵ� '" + removedChar + "'�Դϴ�.");
			}
		}
	}
	private void removeN(int numberOfCharsToBeRemoved) {
		if(numberOfCharsToBeRemoved == 0) {
			AppView.outputLine("[DeQ] ������ ������ ������ 0�� �Դϴ�.");
		}
		else {
			int count = 0;
			while(count < numberOfCharsToBeRemoved && (!this.queue().isEmpty())) {
				Character RemovedChar = this.queue().deQueue();
				if(RemovedChar == null) {
					AppView.outputLine("(����) ť���� �����ϴ� ���ȿ� ������ �߻��Ͽ����ϴ�.");
				}
				else {
					AppView.outputLine("[DeQ] ������ ���Ҵ� '" + RemovedChar + "' �Դϴ�.");
				}
				count++;
			}
			if(count < numberOfCharsToBeRemoved) {
				AppView.outputLine("[DeQs.Empty] ť�� ���̻� ������ ���Ұ� �����ϴ�.");
			}
		}
	}
	private void quitQueueProcessing() {
		AppView.outputLine("");
		AppView.outputLine("<ť�� ���� ����� �����մϴ�>");
		this.showAllFromFront();
		this.removeN(this.queue().size());
	}
	// ��� ����
	private void showAllFromFront() {
		AppView.output("[Queue] <Front> ");
		Iterator<Character> queueIterator = (Iterator<Character>) this.queue().iterator();
		while (queueIterator.hasNext()) {
			Character element = queueIterator.next();
			AppView.output(element.toString() + " " );
		}
		AppView.outputLine("<Rear>");

	}
	private void showAllFromRear() {
		AppView.output("[Queue] <Rear>");
		for (int order = this.queue().size() - 1; order >= 0; order++) {
			AppView.output(((CircularArrayQueue<Character>) this.queue()).elementAt(order).toString() + " " );
		}
		AppView.outputLine ("<Front>");
	}
	private void showFrontElement() {
		if(this.queue().isEmpty()) {
			AppView.outputLine("[Front.Empty] ť�� �� Front ���Ұ� �������� �ʽ��ϴ�");
		}
		else {
			AppView.outputLine("[Front] ť�� Front ���Ҵ� '" + this.queue().elementAt(1) + "' �Դϴ�.");
		}
	}
	private void showRearElement() {
		if(this.queue().isEmpty()) {
			AppView.outputLine("[Rear.Empty] ť�� �� Rear ���Ұ� �������� �ʽ��ϴ�");
		}
		else {
			AppView.outputLine("[Rear] ť�� Rear ���Ҵ� '" + this.queue().elementAt(this.queue().size())+ "' �Դϴ�.");
		}
	}
	private void showQueueSize() {
		AppView.outputLine("[Size] ť���� ���� " + this.queue().size() + " ���� ���Ұ� �ֽ��ϴ�.");
	}
	private void showStatistics() {
		AppView.outputLine("");
		AppView.outputLine("<ť ��� ���>");
		AppView.outputLine("- �Էµ� ���ڴ� " + this.inputChars() + "�� �Դϴ�.");
		AppView.outputLine("- ���� ó���� ���ڴ� " + (this.inputChars()-this.ignoredChars()) + "�� �Դϴ�.");
		AppView.outputLine("- ���õ� ���ڴ� " + this.ignoredChars() + "�� �Դϴ�.");
		AppView.outputLine("- ���Ե� ���ڴ� " + this.addedChars() + "�� �Դϴ�.");
		
	}
	private char inputChar() {
		AppView.output("? ���ڸ� �Է��Ͻÿ� : ");
		return AppView.inputChar();
	}
	
	public void run() {
		AppView.outputLine("<<<ť ��� Ȯ�� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		char input = this.inputChar();
		while(input != '!') {
			this.countInputChar();
			if((Character.isAlphabetic(input))) {
				this.addToQueue ( Character.valueOf (input) ) ;
				this.countAddedChar();
			}
			else if(Character.isDigit(input)) {
				this.removeN(Character.getNumericValue(input)) ;
			}
			else if(input == '-') {
				this.removeOne();
			}
			else if(input == '#') {
				this.showQueueSize();
			}
			else if( input == '/' ) {
				this.showAllFromFront();
			}
			else if(input == '\\') {
				this.showAllFromRear();
			}
			else if( input == '<' ) {
				this.showFrontElement();
			}
			else if( input == '>' ) {
				this.showRearElement();
			}
			else {
				AppView.outputLine("[Ignore] �ǹ� ���� ���ڰ� �ԷµǾ����ϴ�.") ;
				this.countIgnoredChar();
			}
				input = this.inputChar();
		}
		this.quitQueueProcessing();
		this.showStatistics ();
		AppView.outputLine("");
		AppView.outputLine ("<<<ť ��� Ȯ�� ���α׷��� �����մϴ� >>>") ;
	}
}

