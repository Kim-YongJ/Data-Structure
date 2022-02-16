package DS06_Main_201400875_�����;

public class AppController {
	private Experiment _experiment;
	
	private Experiment experiment() {
		return this._experiment;
	}
	private void setExperiment(Experiment newExperiment) {
		this._experiment = newExperiment;
	}
	
	public AppController() {
		this.setExperiment(new Experiment());
		this.experiment().generateData();
	}
	
	public void run() {
		AppView.outputLine("<<< ����Ʈ ���� ���� ���α׷��� �����մϴ�. >>>");
		AppView.outputLine("! ����Ʈ�� ������ ���� �ð��� ���̸� �˾ƺ��ϴ� : (���� : Micro Second)");
		AppView.outputLine("");
		AppView.outputLine("<Sorted Array List>");
		this.experiment().measureForSortedArrayList();
		this.showExperimentResults();

		AppView.outputLine("");
		AppView.outputLine("<UnSorted Array List>");
		this.experiment().measureForUnSortedArrayList();
		this.showExperimentResults();

		AppView.outputLine("");
		AppView.outputLine("<UnSorted Linked List>");
		this.experiment().measureForUnSortedLinkedList();
		this.showExperimentResults();

		AppView.outputLine("");
		AppView.outputLine("<Sorted Linked List>");
		this.experiment().measureForSortedLinkedList();
		this.showExperimentResults();

		AppView.outputLine("<<< ����Ʈ ���� ���� ���α׷��� �����մϴ�. >>>");
	}
	private void showExperimentResults() {
		MeasuredResult[] results = this.experiment().measuredResults();
		for(int i = 0; i < this.experiment().numberOfIteration(); i++) {
			AppView.outputResult(
			results[i].size(), results[i].durationForAdd()/1000, results[i].durationForMax()/1000
			);
		}
	}
	
}
