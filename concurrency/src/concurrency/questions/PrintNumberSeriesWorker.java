package concurrency.questions;

public class PrintNumberSeriesWorker extends Thread {

	PrintNumberSeries printNumberSeries;
	String method;

	public PrintNumberSeriesWorker(PrintNumberSeries printNumberSeries, String method) {
		this.printNumberSeries = printNumberSeries;
		this.method = method;
	}

	public void run() {
		if ("zero".equals(method)) {
			try {
				printNumberSeries.printZero();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("even".equals(method)) {
			try {
				printNumberSeries.printEven();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			try {
				printNumberSeries.printOdd();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		PrintNumberSeries printNumberSeries = new PrintNumberSeries(5);
		Thread T1 = new PrintNumberSeriesWorker(printNumberSeries, "zero");
		Thread T2 = new PrintNumberSeriesWorker(printNumberSeries, "even");
		Thread T3 = new PrintNumberSeriesWorker(printNumberSeries, "odd");
		T1.start();
		T2.start();
		T3.start();
	}

}
