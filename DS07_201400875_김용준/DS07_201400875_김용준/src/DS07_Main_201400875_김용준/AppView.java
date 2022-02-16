package DS07_Main_201400875_�����;

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
	
	public static void outputNumberOfStudents (int aNumberOfStudents) {
		// �б� �л� �� ��� 
		AppView.outputLine("�б� �л� �� : " + aNumberOfStudents);
	}
	public static void outputHighestScore(int aScore) {
		// �б� �ְ� ���� ���
		AppView.outputLine("�б� �ְ� ���� : " + aScore);
	}
	public static void outputLowestScore(int aScore) {
		// �б� ���� ���� ���
		AppView.outputLine("�б� ���� ���� : " + aScore);
	}
	public static void outputAverageScore(double anAverageScore) {
		// �б� ��� ���� ���
		AppView.outputLine("�б� ��� : " + anAverageScore);
	}
	public static void outputNumberOfStudentsAboveAverage(int aNumberOfStudents) {
		// ��� �̻��� �л� �� ���
		AppView.outputLine("��� �̻��� �л� �� : " + aNumberOfStudents);
	}
	public static void outputNumberOfStudentsForGrade(char aGrade, int aNumberOfStudents) {
		AppView.outputLine(aGrade + " ������ �л� ���� " + aNumberOfStudents + " �Դϴ�.");
	}
	public static void outputScore(int aScore) {
		// �л����� ���� ���
		AppView.outputLine("���� : " + aScore);
	}
	
	public static int inputInt() {
		return Integer.parseInt(AppView.scanner.nextLine());
	}
	public static int inputScore() {
		while(true) {
			try {
				AppView.output("- ������ �Է��Ͻÿ� (0..100): ");
				int score = AppView.inputInt();
				return score;
			} 
			catch(NumberFormatException e) {
				AppView.outputLine("(����) ������ �Էµ��� �ʾҽ��ϴ�.");
			}
		}
	}
	public static boolean doesContinueToInputStudent() {
		AppView.output("������ �Է��Ϸ��� 'Y�� �Ǵ� ��y�� ��, �����Ϸ��� �ٸ� �ƹ� Ű�� ġ�ÿ�: ");
		String line = null;
		do {
			line = AppView.scanner.nextLine();
		}
		while(line.equals(""));
		char answer = AppView.scanner.nextLine().charAt(0);
		return((answer == 'Y') || (answer == 'y'));
	}
}
