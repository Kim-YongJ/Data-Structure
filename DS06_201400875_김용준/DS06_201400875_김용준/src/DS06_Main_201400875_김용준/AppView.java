package DS06_Main_201400875_�����;

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
		return Integer.parseInt(AppView.scanner.next()); // ������ �ƴ� ��� ����ó�� ����
	}
	
	public static void outputResult(int size, long durationForAdd, long durationForMax) {
		AppView.outputLine(
				"[ũ�� : " + String.format("%5d", size) + "] " +
				"���� : " + String.format("%8d", durationForAdd) + ", " +
				"�ִ밪 : " + String.format("%8d", durationForMax)
				);
	}
	
}
