package vp.ThreadCreation;

public class RunnableThread implements Runnable{

	@Override
	public void run() {
		System.out.println("RUN...");
	}
	
	public static void main(String[] args) {
		RunnableThread v = new RunnableThread();
		Thread d = new Thread(v);
		d.start();
	}

}
