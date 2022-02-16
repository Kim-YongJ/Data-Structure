package DS03_Main_201400875_�����;

public class AppController {
	private static final int MENU_ADD = 1;
	private static final int MENU_REMOVE = 2;
	private static final int MENU_SEARCH = 3;
	private static final int MENU_FREQUENCY = 4;
	private static final int MENU_END_OF_RUN = 9; // �Է»�� 1-�߰� 2-���� 3-�˻� 4-Ƚ���ľ� 9-����
	
	public void run() {
		AppView.outputLine("<<< ���� ���� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		
		this.setCoinBag (new LinkedBag<Coin>());
				
		int menuNumber = AppView.inputMenuNumber();
		while (menuNumber != MENU_END_OF_RUN) { // 9�� �ԷµǸ� ����
		switch (menuNumber) {
		case MENU_ADD:
			this.addCoin(); // 1�� �Է��ϸ� �߰�
			break;
		case MENU_REMOVE: // 2�� �Է��ϸ� ����
			this.removeCoin();
			break;
		case MENU_SEARCH: // 3�� �Է��ϸ� �˻�
			this.searchForCoin();
			break;
		case MENU_FREQUENCY: // 4�� �Է��ϸ� Ƚ���ľ�
			this.frequencyOfCoin();
			break;
		default:
			this.undefinedMenuNumber(menuNumber); // �ٸ� ���ڸ� �Է��ϸ� �����޼��� ���
		}
		menuNumber = AppView.inputMenuNumber();
		}
		this.showStatistics();
		AppView.outputLine ("<<< ���� ���� ���α׷��� �����մϴ� >>>");
		}
	
	private void addCoin () {
			int coinValue = AppView.inputCoinValue();
			if (this.coinBag().add (new Coin(coinValue))) {
				AppView.outputLine("- �־��� ���� ���� ������ ���濡 ���������� �־����ϴ�. \n");
			}
			else {
				AppView.outputLine("- �־��� ���� ���� ������ ���濡 �ִµ� �����Ͽ����ϴ�. \n");
			} 
		}
	
	private void removeCoin() {
		int coinValue = AppView.inputCoinValue();
		if (! this.coinBag().remove (new Coin(coinValue))) {
			AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�. \n");
		}
		else {
			AppView.outputLine("- �־��� ���� ���� ���� �ϳ��� ���濡�� ���������� �����Ǿ����ϴ�. \n");
		}
	}
	
	private void searchForCoin() {
		int coinValue = AppView.inputCoinValue();
		if ( this.coinBag().doesContain (new Coin(coinValue))) {
			AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �����մϴ�. \n");
		}
		else {
			AppView.outputLine("- �־��� ���� ���� ������ ���� �ȿ� �������� �ʽ��ϴ�. \n");
		}
	}
	
	private void frequencyOfCoin() {
		int coinValue = AppView.inputCoinValue();
		int frequency = this.coinBag().frequencyOf(new Coin(coinValue));
		AppView.outputLine("- �־��� ���� ���� ������ ������ " + frequency + " �� �Դϴ�. \n");
	}
	
	private void undefinedMenuNumber(int menuNumber) {
		AppView.outputLine("- ���õ� �޴� ��ȣ " + menuNumber + " �� �߸��� ��ȣ�Դϴ�. \n" );
	}
	
	private int sumOfCoinValues() {
		int sum = 0;
		for (int i = 0; i < this.coinBag().size(); i++) {
			sum += this.coinBag().elementAt(i).value();
		}
		return sum ;
	}
	private int maxCoinValue() {
		int maxValue = 0;
		for (int i = 0; i < this.coinBag().size() ; i++) {
			if (maxValue < this.coinBag().elementAt(i).value()) {
				maxValue = this.coinBag().elementAt(i).value();
			}
		}
		return maxValue;
	}

	private void showStatistics() {
		AppView.outputLine("���濡 ��� �ִ� ������ ����: " + this.coinBag().size());
		AppView.outputLine("���� �� ���� ū ��: " + this.maxCoinValue());
		AppView.outputLine("��� ���� ���� ��: " + this.sumOfCoinValues());
	}
	
	private LinkedBag<Coin> _coinBag;
	
	private LinkedBag<Coin>coinBag() {
		return this._coinBag;
	}
	private void setCoinBag(LinkedBag<Coin> newCoinBag) {
		this._coinBag = newCoinBag;
	}
	
}

