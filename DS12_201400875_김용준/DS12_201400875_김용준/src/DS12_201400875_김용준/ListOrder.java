package DS12_201400875_김용준;

public enum ListOrder {
	Ascending, // 오름차순 데이터 리스트의 유형을 표현
	Descending, // 내림차순 데이터 리스트의 유형을 표현
	Random; // 무작위 데이터 리스트의 유형을 표현
	
	public static final String[] ORDER_NAMES = {"오름차순", "내림차순", "무작위"};

	public String orderName() {
		
		// "ordinal()"은 모든 Enum 에 미리 정의되어 있는 함수로,
		// 선언된 값의 Enum 안에서의 순서를 정수로 얻을 수 있다.
		// 즉. Ascending.ordinal() 은 0, Descending.ordinal() 은 1,
		// Random.ordinal() 은 2 를 얻는다.
		
		return ListOrder.ORDER_NAMES[this.ordinal()];
	}

}
