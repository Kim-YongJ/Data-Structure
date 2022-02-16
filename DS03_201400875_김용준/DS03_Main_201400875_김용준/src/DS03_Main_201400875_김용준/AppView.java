package DS03_Main_201400875_�����;

import java.util.Scanner;

public class AppView {
	private static Scanner scanner = new Scanner(System.in);
	
	private AppView() {}
	
	public static void output(String message) {
			System.out.print(message);
		}
	public static void outputLine(String message) {
			System.out.println(message);
		}
	public static int inputMenuNumber() {
		int InputMenu;
		String ScannedToken;
		while (true) {
			AppView.output("? �����Ϸ��� �ϴ� �޴� ��ȣ�� �����Ͻÿ� (add:1, remove:2, search:3, frequency:4, exit:9): ");
			ScannedToken = AppView.scanner.next();
			InputMenu = Integer.parseInt(ScannedToken);
			return InputMenu;
		}
	}
	public static int inputCapacityOfCoinBag() { 
		int InputBag;
		String ScannedToken;
		while (true) {
			AppView.output("? ���� ������ ũ��, �� ���濡 �� ������ �ִ� ������ �Է��Ͻÿ�: ");
			ScannedToken = AppView.scanner.next();
			InputBag = Integer.parseInt(ScannedToken);
			return InputBag;
		}	
	}
	public static int inputCoinValue() {
		int InputCoin;
		String ScannedToken;
		while (true) {
			AppView.output("? ���� ���� �Է��Ͻÿ�: ");
			ScannedToken = AppView.scanner.next();
			InputCoin = Integer.parseInt(ScannedToken);
			return InputCoin;
		}
	
	}
}
