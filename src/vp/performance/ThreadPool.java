package vp.performance;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPool {
	public static void main(String[] args) {
		ExecutorService e = Executors.newFixedThreadPool(3);
//		Executor e1 = Executors.newFixedThreadPool(3);
		Runnable r = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Hello....");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hi.......");
				System.out.println(Thread.currentThread().getName());
				System.out.println("**************");
			}
		};
		e.execute(r);
		e.execute(r);
		e.execute(r);
		// 4th one will wait till one of the thread gets free
		e.execute(r);
		e.shutdown();
//		System.exit(0);
	}
}
