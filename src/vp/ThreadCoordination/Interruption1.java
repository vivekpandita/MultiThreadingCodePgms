package vp.ThreadCoordination;

public class Interruption1 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new ShortInterruption());
		t.start();
		Thread.sleep(10000);
		t.interrupt();
	}
	
	private static class ShortInterruption implements Runnable
	{

		@Override
		public void run() {
			System.out.println("Start");
			try {
				Thread.sleep(100000);
			} catch (InterruptedException e) {
				System.out.println("Existing blocking thread");
			}
			System.out.println("Post Execution");
		}
		
	}
}
