package DS03_Main_201400875_�����;

public class Coin {
	private static final int DEFALUT_VALUE = 0;
	
	private int _value; // ������ �ݾ�
	
	public Coin() {
		this._value = DEFALUT_VALUE;
	}
	public Coin(int givenValue) {
		this._value = givenValue;
	}
	
	public int value() {
		return this._value;
	}
	public void setValut(int newValue) {
		this._value = newValue;
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
}
