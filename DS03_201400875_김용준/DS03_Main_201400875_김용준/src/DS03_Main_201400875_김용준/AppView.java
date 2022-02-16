package DS03_Main_201400875_김용준;

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
			AppView.output("? 수행하려고 하는 메뉴 번호를 선택하시오 (add:1, remove:2, search:3, frequency:4, exit:9): ");
			ScannedToken = AppView.scanner.next();
			InputMenu = Integer.parseInt(ScannedToken);
			return InputMenu;
		}
	}
	public static int inputCapacityOfCoinBag() { 
		int InputBag;
		String ScannedToken;
		while (true) {
			AppView.output("? 동전 가방의 크기, 즉 가방에 들어갈 동전의 최대 개수를 입력하시오: ");
			ScannedToken = AppView.scanner.next();
			InputBag = Integer.parseInt(ScannedToken);
			return InputBag;
		}	
	}
	public static int inputCoinValue() {
		int InputCoin;
		String ScannedToken;
		while (true) {
			AppView.output("? 동전 값을 입력하시오: ");
			ScannedToken = AppView.scanner.next();
			InputCoin = Integer.parseInt(ScannedToken);
			return InputCoin;
		}
	
	}
}
