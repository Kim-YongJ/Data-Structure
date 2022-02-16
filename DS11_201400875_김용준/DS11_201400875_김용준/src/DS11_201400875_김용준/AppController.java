package DS11_201400875_�����;

import java.util.Arrays;
import java.util.Collections;

public class AppController {
	// ���
	private static final int TEST_SIZE = 10000;
	private static final int FIRST_PART_SIZE = 5;
	
	private static final InsertionSort<Integer> INSERTION_SORT = new InsertionSort<Integer>();
	private static final QuickSort<Integer> QUICK_SORT = new QuickSort<Integer>();
	
	// ����� ������
	private Integer[] _list;
	private ListOrder _listOrder;
	
	// Getters/Setters
	private Integer[] list() {
		return this._list;
	}
	private void setList(Integer[] newList) {
		this._list = newList;
	}
	private ListOrder listOrder() {
		return this._listOrder;
	}
	private void setListOrder(ListOrder newListOrder) {
		this._listOrder = newListOrder;
	}
	// ������
	public AppController() {}
	
	public void run() {
		AppView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ� >>>");
		AppView.outputLine("");
		AppView.outputLine( "> ���� ����� ����:" );
		AppView.outputLine("");
		this.validateWithAscendingOrderList();
		this.validateWithDescendingOrderList();
		this.validateWithRandomOrderList();
		AppView.outputLine("<<< ���� �˰����� ���� ����� �����ϴ� ���α׷��� �����մϴ� >>>");
	}
	
	private void validateWithAscendingOrderList() {
		this.setListOrder(ListOrder.Ascending);
		this.setList(DataGenerator.ascendingOrderList(TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}
	private void validateWithDescendingOrderList() {
		this.setListOrder(ListOrder.Descending);
		this.setList(DataGenerator.descendingOrderList(TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}
	private void validateWithRandomOrderList() {
		this.setListOrder(ListOrder.Random);
		this.setList(DataGenerator.randomOrderList(TEST_SIZE));
		this.showFirstPartOfDataList();
		this.validateSortsAndShowResult();
	}
	
	private void showFirstPartOfDataList() {
		AppView.output("[" + this.listOrder().orderName() + " ����Ʈ] �� �� �κ�: ");
		if(this.listOrder().orderName() == "��������") {
			this._list = DataGenerator.ascendingOrderList(TEST_SIZE);
			for(int i=0; i < 5; i++) {
				AppView.output((this._list[i].toString() + " "));
			}
		}
		else if(this.listOrder().orderName() == "��������") {
			this._list = DataGenerator.descendingOrderList(TEST_SIZE);
			for(int i=0; i < 5; i++) {
				AppView.output((this._list[i].toString() + " "));
			}
		}
		else if(this.listOrder().orderName() == "������") {
			this._list = DataGenerator.randomOrderList(TEST_SIZE);
			for(int i=0; i < 5; i++) {
				AppView.output((this._list[i].toString() + " "));
			}
		}
		AppView.outputLine("");
	}
	private void validateSortsAndShowResult() {
		this.validateSort(AppController.INSERTION_SORT);
		this.validateSort(AppController.QUICK_SORT);
		AppView.outputLine("");
	}
	private void validateSort(Sort<Integer> aSort) {
		Integer[] list = this.copyList(this._list);
		aSort.sort(list, list.length);
		this.showValidationMessage(aSort, list);
	}
	private Integer[] copyList(Integer[] aList) {
		// �־��� �迭 ��ü aList[] �� ���纻�� ����� �����ش�.
		// aList[] ��ü�� ����������,
		// �迭�� ���� ��ü ��ü�� �������� �ʰ� �����Ѵ�.
		Integer[] copiedList = new Integer[aList.length];
		
		copiedList = aList;
		return copiedList;
	}
	private boolean sortedListIsValid(Integer[] aList) {
		// �־��� aList �� ���ҵ��� ������������ �Ǿ� ������ true �� �����ش�.
		for(int i = 0; i < (aList.length-1); i++) {
			if(aList[i].compareTo (aList[i+1]) > 0) {
				return false; // ���������� �ƴ� ������ �߰�
			}
		}
		return true; // ����Ʈ ��ü�� ������������ �Ǿ� �ִ�.
	}
	
	private void showValidationMessage(Sort<Integer> aSort, Integer[] aList) {
		AppView.output("[" + this.listOrder().orderName() + " ����Ʈ]�� [" + aSort.getClass().getSimpleName() + "] �� ����� ");
		if(this.sortedListIsValid(aList)) {
			AppView.output("�ùٸ��ϴ�.");
			AppView.outputLine("");
		}
		else {
			AppView.output("�ùٸ��� �ʽ��ϴ�.");
		}
	}

}

