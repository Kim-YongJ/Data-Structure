package DS10_201400875_±è¿ëÁØ;

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
	public static void outputDebugMessage(String message) {
		System.out.println(message);
	}
	public static char inputChar() {
		String line = AppView.scanner.nextLine().trim();
		while(line.equals("")) {
			line = AppView.scanner.nextLine().trim();
		}
		return line.charAt(0);
	}
}
