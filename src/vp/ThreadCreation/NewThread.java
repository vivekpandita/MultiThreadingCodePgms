package vp.ThreadCreation;

public class NewThread {
	public static void main(String[] args) throws InterruptedException {
		Thread thread1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Executing Run (Old) for thread1 with priority "+Thread.currentThread().getPriority()+" titled ->" + Thread.currentThread().getName());
			}
		});
		
		thread1.setName("Legacy");
		thread1.setPriority(Thread.NORM_PRIORITY);

		
		Thread thread2 = new Thread(()->{
			System.out.println("Executing Run (Lambda) for thread2 with priority "+Thread.currentThread().getPriority()+" titled ->" + Thread.currentThread().getName());

		});
		
		thread2.setName("Lambda");
		thread2.setPriority(Thread.MAX_PRIORITY);

		
		System.out.println("Normal flow with Main Thread titled ->" + Thread.currentThread().getName());

		Thread.sleep(5000);
		System.out.println("Normal flow with Main Thread after SLEEP titled ->" + Thread.currentThread().getName());

		thread1.start();
		thread2.start();
		System.out.println("Done");
	}
}
