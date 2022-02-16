package DS06_Main_201400875_±è¿ëÁØ;

public class Coin implements Comparable<Coin> {
	
	int value;
	public Coin(int randomCoinValue) {
		this.value = randomCoinValue;
	}
	private static final int DEFALUT_VALUE = 0;
	
	public Coin() {
		this.value = DEFALUT_VALUE;
	}	
	public void setValut(int newValue) {
		this.value = newValue;
	}

	@Override
	public boolean equals(Object otherCoin) {
		if(otherCoin.getClass() != Coin.class) {
			return false;
		}
		else {
			return (this.value() == ((Coin) otherCoin).value());
		}
	}
	public int value() {
		return this.value;
	}
	
	@Override
	public int compareTo(Coin aCoin) {
		if(this.value() < aCoin.value()) {
			return -1;
		}
		else if(this.value > aCoin.value() ) {
			return +1;
		}
		else {
			return 0;
		}
	}
}