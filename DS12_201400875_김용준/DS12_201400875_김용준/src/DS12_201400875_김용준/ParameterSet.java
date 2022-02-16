package DS12_201400875_김용준;

public class ParameterSet {
	// Private instance variables
	private int _startingSize;
	private int _numberOfSizeIncreasingSteps;
	private int _incrementSize;
	// public Getters & Setters
	
	public int startingSize() {
		return this._startingSize;
	}
	public int numberOfSizeIncreasingSteps() {
		return this._numberOfSizeIncreasingSteps;
	}
	public int incrementSize() {
		return this._incrementSize;
	}
	public int maxDataSize() {
		return (this.startingSize() + (this.incrementSize() * (this.numberOfSizeIncreasingSteps() - 1)));
	}
	// 생성자:
	public ParameterSet(int givenStartingSize, int givenNumberOfSizeIncreasingSteps, int givenIncrementSize)
	{
		this._incrementSize = givenIncrementSize;
		this._numberOfSizeIncreasingSteps = givenNumberOfSizeIncreasingSteps;
		this._startingSize = givenStartingSize;
	}
}
