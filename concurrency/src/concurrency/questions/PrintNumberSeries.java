package concurrency.questions;

import java.util.concurrent.Semaphore;

public class PrintNumberSeries {
	private int n;
	private Semaphore zeroSem, oddSem, evenSem;

	public PrintNumberSeries(int n) {
		this.n = n;
		zeroSem = new Semaphore(1);
		oddSem = new Semaphore(0);
		evenSem = new Semaphore(0);
	}

	public void printZero() throws InterruptedException {
		for (int i = 0; i < n; i++) {
			try {
				zeroSem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName() + "0");
			Thread.sleep(2000);
			(i % 2 == 0 ? oddSem : evenSem).release();
		}
	}

	public void printEven() throws InterruptedException {
		for (int i = 2; i <= n; i = i + 2) {
			try {
				evenSem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(Thread.currentThread().getName() + ":" + i);
			Thread.sleep(2000);
			zeroSem.release();
		}
	}

	public void printOdd() throws InterruptedException {
		for (int i = 1; i <= n; i += 2) {
			try {
				oddSem.acquire();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.print(Thread.currentThread().getName() + ":" + i);
			Thread.sleep(2000);
			zeroSem.release();
		}
	}
}
