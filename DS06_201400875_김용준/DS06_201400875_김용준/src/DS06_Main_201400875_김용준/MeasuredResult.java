package DS06_Main_201400875_±è¿ëÁØ;

public class MeasuredResult {
	private int		_size;
	private long 	_durationForAdd;
	private long	_durationForMax;
	
	public int size() {
		return this._size;
	}
	public void setSize(int newSize) {
		this._size = newSize;
	}
	public long durationForAdd() {
		return this._durationForAdd;
	}
	public void setDurationForAdd(long newDurationForAdd) {
		this._durationForAdd = newDurationForAdd;
	}
	public long durationForMax() {
		return this._durationForMax;
	}
	public void setDurationForMax(long newDurationForMax) {
		this._durationForMax = newDurationForMax;
	}
	
	public MeasuredResult() {
		this(0, 0, 0);
	}
	public MeasuredResult(int givenSize, long givenDurationForAdd, long givenDurationForMax) {
		this.setSize(givenSize);
		this.setDurationForAdd(givenDurationForAdd);
		this.setDurationForMax(givenDurationForMax);
	}
}
