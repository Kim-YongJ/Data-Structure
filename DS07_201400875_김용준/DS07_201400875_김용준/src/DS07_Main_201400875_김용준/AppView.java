package DS07_Main_201400875_김용준;

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
		// 학급 학생 수 출력 
		AppView.outputLine("학급 학생 수 : " + aNumberOfStudents);
	}
	public static void outputHighestScore(int aScore) {
		// 학급 최고 점수 출력
		AppView.outputLine("학급 최고 점수 : " + aScore);
	}
	public static void outputLowestScore(int aScore) {
		// 학급 최저 점수 출력
		AppView.outputLine("학급 최저 점수 : " + aScore);
	}
	public static void outputAverageScore(double anAverageScore) {
		// 학급 평균 점수 출력
		AppView.outputLine("학급 평균 : " + anAverageScore);
	}
	public static void outputNumberOfStudentsAboveAverage(int aNumberOfStudents) {
		// 평균 이상인 학생 수 출력
		AppView.outputLine("평균 이상인 학생 수 : " + aNumberOfStudents);
	}
	public static void outputNumberOfStudentsForGrade(char aGrade, int aNumberOfStudents) {
		AppView.outputLine(aGrade + " 학점의 학생 수는 " + aNumberOfStudents + " 입니다.");
	}
	public static void outputScore(int aScore) {
		// 학생들의 점수 출력
		AppView.outputLine("점수 : " + aScore);
	}
	
	public static int inputInt() {
		return Integer.parseInt(AppView.scanner.nextLine());
	}
	public static int inputScore() {
		while(true) {
			try {
				AppView.output("- 점수를 입력하시오 (0..100): ");
				int score = AppView.inputInt();
				return score;
			} 
			catch(NumberFormatException e) {
				AppView.outputLine("(오류) 정수가 입력되지 않았습니다.");
			}
		}
	}
	public static boolean doesContinueToInputStudent() {
		AppView.output("성적을 입력하려면 'Y‘ 또는 ‘y’ 를, 종료하려면 다른 아무 키나 치시오: ");
		String line = null;
		do {
			line = AppView.scanner.nextLine();
		}
		while(line.equals(""));
		char answer = AppView.scanner.nextLine().charAt(0);
		return((answer == 'Y') || (answer == 'y'));
	}
}
