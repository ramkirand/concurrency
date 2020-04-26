package concurrency.questions;

import java.util.concurrent.atomic.AtomicInteger;

/*
 * Problem:Suppose there are three threads t1, t2 and t3. t1 prints First, t2 prints Second and t3 prints Third.
 */
public class OrderPrinting {
	AtomicInteger count;

	public OrderPrinting() {
		count = new AtomicInteger(1);
	}

	public void printFirst() {
		synchronized (this) {
			System.out.println("first");
			count.incrementAndGet();
			this.notifyAll();
		}

	}

	public void printSecond() throws InterruptedException {
		synchronized (this) {
			while (count.get() != 2)
				this.wait();
			System.out.println("second");
			count.incrementAndGet();
			this.notifyAll();
		}
	}

	public void printThird() throws InterruptedException {
		synchronized (this) {
			while (count.get() != 3)
				this.wait();
			System.out.println("third");
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
