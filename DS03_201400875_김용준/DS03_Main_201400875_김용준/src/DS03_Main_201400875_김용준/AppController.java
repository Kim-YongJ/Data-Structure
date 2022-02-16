package DS03_Main_201400875_김용준;

public class AppController {
	private static final int MENU_ADD = 1;
	private static final int MENU_REMOVE = 2;
	private static final int MENU_SEARCH = 3;
	private static final int MENU_FREQUENCY = 4;
	private static final int MENU_END_OF_RUN = 9; // 입력상수 1-추가 2-삭제 3-검색 4-횟수파악 9-종료
	
	public void run() {
		AppView.outputLine("<<< 동전 가방 프로그램을 시작합니다 >>>");
		AppView.outputLine("");
		
		this.setCoinBag (new LinkedBag<Coin>());
				
		int menuNumber = AppView.inputMenuNumber();
		while (menuNumber != MENU_END_OF_RUN) { // 9가 입력되면 종료
		switch (menuNumber) {
		case MENU_ADD:
			this.addCoin(); // 1을 입력하면 추가
			break;
		case MENU_REMOVE: // 2를 입력하면 삭제
			this.removeCoin();
			break;
		case MENU_SEARCH: // 3을 입력하면 검색
			this.searchForCoin();
			break;
		case MENU_FREQUENCY: // 4를 입력하면 횟수파악
			this.frequencyOfCoin();
			break;
		default:
			this.undefinedMenuNumber(menuNumber); // 다른 숫자를 입력하면 오류메세지 출력
		}
		menuNumber = AppView.inputMenuNumber();
		}
		this.showStatistics();
		AppView.outputLine ("<<< 동전 가방 프로그램을 종료합니다 >>>");
		}
	
	private void addCoin () {
			int coinValue = AppView.inputCoinValue();
			if (this.coinBag().add (new Coin(coinValue))) {
				AppView.outputLine("- 주어진 값을 갖는 동전을 가방에 성공적으로 넣었습니다. \n");
			}
			else {
				AppView.outputLine("- 주어진 값을 갖는 동전을 가방에 넣는데 실패하였습니다. \n");
			} 
		}
	
	private void removeCoin() {
		int coinValue = AppView.inputCoinValue();
		if (! this.coinBag().remove (new Coin(coinValue))) {
			AppView.outputLine("- 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다. \n");
		}
		else {
			AppView.outputLine("- 주어진 값을 갖는 동전 하나가 가방에서 정상적으로 삭제되었습니다. \n");
		}
	}
	
	private void searchForCoin() {
		int coinValue = AppView.inputCoinValue();
		if ( this.coinBag().doesContain (new Coin(coinValue))) {
			AppView.outputLine("- 주어진 값을 갖는 동전이 가방 안에 존재합니다. \n");
		}
		else {
			AppView.outputLine("- 주어진 값을 갖는 동전은 가방 안에 존재하지 않습니다. \n");
		}
	}
	
	private void frequencyOfCoin() {
		int coinValue = AppView.inputCoinValue();
		int frequency = this.coinBag().frequencyOf(new Coin(coinValue));
		AppView.outputLine("- 주어진 값을 갖는 동전의 개수는 " + frequency + " 개 입니다. \n");
	}
	
	private void undefinedMenuNumber(int menuNumber) {
		AppView.outputLine("- 선택된 메뉴 번호 " + menuNumber + " 는 잘못된 번호입니다. \n" );
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
		AppView.outputLine("가방에 들어 있는 동전의 개수: " + this.coinBag().size());
		AppView.outputLine("동전 중 가장 큰 값: " + this.maxCoinValue());
		AppView.outputLine("모든 동전 값의 합: " + this.sumOfCoinValues());
	}
	
	private LinkedBag<Coin> _coinBag;
	
	private LinkedBag<Coin>coinBag() {
		return this._coinBag;
	}
	private void setCoinBag(LinkedBag<Coin> newCoinBag) {
		this._coinBag = newCoinBag;
	}
	
}

