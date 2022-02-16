package DS07_Main_201400875_김용준;

public class Ban extends UnsortedArrayList<Student> {
	
	private static char scoreToGrade(int aScore) {
		if(aScore >= 90) {
			return 'A';
		}
		else if(aScore >= 80) {
			return 'B';
		}
		else if(aScore >= 70) {
			return 'C';
		}
		else if(aScore >= 60) {
			return 'D';
		}
		else {
			return 'F';
		}
	}
	
	public Ban() {
		super();
	}
	public Ban(int givenCapacity) {
		super(givenCapacity);
	}
	
	private Student lowestRecursively(int left, int right) {
		if(left == right) {
			return this.elementAt(left);
		}
		else {
			Student lowestFromRights = lowestRecursively(left+1,right);
			if(lowestFromRights.compareTo(this.elementAt(left)) <= 0) {
				return lowestFromRights;
			}
			else {
				return this.elementAt(left);
			}
		}
	}
	public Student lowest() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.lowestRecursively(0, this.size()-1);
		}
	}
	private Student highestRecursively(int left, int right) {
		if(left == right) {
			return this.elementAt(right);
		}
		else {
			Student highestFromRights = highestRecursively(left,right-1);
			if(highestFromRights.compareTo(this.elementAt(right)) > 0) {
				return highestFromRights;
			}
			else {
				return this.elementAt(right);
			}
		}
	}
	public Student highest() {
		if(this.isEmpty()) {
			return null;
		}
		else {
			return this.highestRecursively(0, this.size()-1);
		}
	}
	private int sumOfScoresRecursively(int left, int right) {
		int mid = (left+right) / 2;
		if(left == right) {
			return this.elementAt(left).score();
		}
		else {
			int leftSum = this.sumOfScoresRecursively(left, mid);
			int rightSum = this.sumOfScoresRecursively(mid+1, right);
			return (leftSum + rightSum);
		}
	}
	
	public int sum() {
		if(this.isEmpty()) {
			return 0;
		}
		else {
			return this.sumOfScoresRecursively(0, this.size()-1);
		}
	}
	public double average() {
		if(this.isEmpty()) {
			return 0;
		}
		else {
			return ((double) this.sum()) / ((double) this.size());
		}
	}
	public int numberOfStudentsAboveAverage() {
		double average = this.average();
		int numberOfStudentsAboveAverage = 0;
		Iterator<Student> iterator = this.iterator();
		while(iterator.hasNext()) {
			Student student = iterator.next();
			if(student.score() >= average) {
				numberOfStudentsAboveAverage++;
			}
		}
		return numberOfStudentsAboveAverage;
	}
	private void quicksortRecursively(int left, int right) {
		if(left < right) {
			int mid = this.partition(left, right);
			this.quicksortRecursively(left, mid-1);
			this.quicksortRecursively(mid+1, right);
		}
	}
	public void sortByScore() {
		if(this.size() > 1) {
			int maxLoc = 0;
			for(int i = 1; i < this.size(); i++) {
				if(this.elementAt(i).score() > this.elementAt(maxLoc).score()) {
					maxLoc = i;
				}
			}
			this.swap(maxLoc, this.size()-1);
			this.quicksortRecursively(0, this.size()-2);
		}
	}
	private void swap(int p, int q) {
		Student temp = this.elementAt(p);
		this.setElementAt(p, this.elementAt(q));
		this.setElementAt(q, temp);
	}
	private int partition(int left, int right) {
		int pivot = left;
		int toRight = left;
		int toLeft = right+1;
		do {
			do {toRight++;} while(this.elementAt(toRight).score() < this.elementAt(pivot).score());
			do {toLeft--;} while(this.elementAt(toLeft).score() > this.elementAt(pivot).score());
			if(toRight < toLeft) {
				this.swap(toRight, toLeft);
			}
		} while(toRight < toLeft);
		this.swap(left, toLeft);
		return toLeft;
	}
	public GradeCounter countGrades() {
	// Step 1: GradeCounter 객체를 생성한다.
	GradeCounter gradeCounter = new GradeCounter();
	// GradeCounter 객체 생성자에 의해, 
	// 학점별 counter 는 모두 0 으로 초기화 된다.
	
	// Step 2: 학생들의 학점을 센다.
	// 학생들은 Iterator 를 사용하여 차례로 얻는다.
	Iterator<Student> iterator = this.iterator();
	while(iterator.hasNext()) {
		Student student = iterator.next();
		char grade = Ban.scoreToGrade(student.score()); // 점수를 학점으로 변환
		gradeCounter.count(grade); // GradeCounter 객체에게 학점 세기를 시킨다.
		}
		return gradeCounter;
	}

}
