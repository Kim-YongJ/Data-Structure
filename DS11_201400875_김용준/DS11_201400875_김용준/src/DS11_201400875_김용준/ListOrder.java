package DS11_201400875_�����;

public enum ListOrder {
	Ascending, // �������� ������ ����Ʈ�� ������ ǥ��
	Descending, // �������� ������ ����Ʈ�� ������ ǥ��
	Random; // ������ ������ ����Ʈ�� ������ ǥ��
	
	public static final String[] ORDER_NAMES = {"��������", "��������", "������"};

	public String orderName() {
		
		// "ordinal()"�� ��� Enum �� �̸� ���ǵǾ� �ִ� �Լ���,
		// ����� ���� Enum �ȿ����� ������ ������ ���� �� �ִ�.
		// ��. Ascending.ordinal() �� 0, Descending.ordinal() �� 1,
		// Random.ordinal() �� 2 �� ��´�.
		
		return ListOrder.ORDER_NAMES[this.ordinal()];
	}

}
