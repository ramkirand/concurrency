package concurrency.questions;

public class OrderPrintingThread extends Thread {
	private OrderPrinting obj;
	private String methodName;

	public OrderPrintingThread(OrderPrinting obj, String methodName) {
		this.obj = obj;
		this.methodName = methodName;
	}

	public void run() {
		if ("first".equals(methodName)) {
			try {
				obj.printFirst();
			} catch (Exception e) {
				// TODO: handle exception
			}

		} else if ("second".equals(methodName)) {
			try {
				obj.printSecond();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else if ("third".equals(methodName)) {
			try {
				obj.printThird();

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) {
		OrderPrinting orderPrinting = new OrderPrinting();
		OrderPrintingThread T1 = new OrderPrintingThread(orderPrinting, "first");
		OrderPrintingThread T2 = new OrderPrintingThread(orderPrinting, "second");
		OrderPrintingThread T3 = new OrderPrintingThread(orderPrinting, "third");
		T1.start();
		T3.start();
		T2.start();
		

	}

}
