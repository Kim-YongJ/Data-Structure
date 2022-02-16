package DS12_201400875_�����;

import java.util.Arrays;
import java.util.Random;

public final class DataGenerator {
	private DataGenerator() {};
	
	public static Integer[] ascendingOrderList (int aSize) {
		Integer[] list = null;
		if(aSize > 0) {
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++) {
				list[i] = i;
			}
		}
		return list;
	}
	
	public static Integer[] descendingOrderList(int aSize) {
		Integer[] list = null;
		if(aSize > 0) {
			list = new Integer[aSize];
			for(int i = 0; i < aSize; i++) {
				list[i] = 9999-i;
			}
			
		}
		return list;
	}
	
	public static Integer[] randomOrderList (int aSize) {
		// ��ġ�� ���Ұ� ���� ������ ����Ʈ�� �����Ͽ�, �����ش�.
		Integer[] list = null;
		if(aSize > 0) {
		// �ϴ� Ascending order list �� �����
			list = new Integer[aSize];
			for (int i = 0; i < aSize; i++) {
				list[i] = i;
			}
		// �� ���� list[i] �� ���� ������ ��ġ r �� �����Ͽ� list[i] �� list[r] �� �¹ٲ۴�.
			Random random = new Random();
			for(int i = 0; i < aSize; i++) {
				int r = random.nextInt(aSize);
				Integer temp = list[i];
				list[i] = list[r];
				list[r] = temp;
			}
		}
		return list;
	}
}
