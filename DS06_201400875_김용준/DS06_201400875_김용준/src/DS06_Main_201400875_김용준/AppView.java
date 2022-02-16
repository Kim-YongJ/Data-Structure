package DS06_Main_201400875_김용준;

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
	
	public static int inputInteger() throws NumberFormatException {
		return Integer.parseInt(AppView.scanner.next()); // 정수가 아닌 경우 에러처리 보완
	}
	
	public static void outputResult(int size, long durationForAdd, long durationForMax) {
		AppView.outputLine(
				"[크기 : " + String.format("%5d", size) + "] " +
				"삽입 : " + String.format("%8d", durationForAdd) + ", " +
				"최대값 : " + String.format("%8d", durationForMax)
				);
	}
	
}
