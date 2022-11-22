package vp.ThreadCoordination;

public class Interruption2 {
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new LongInterruption(10000));
		t.start();
		// Below Sleep is dummy , we could have taken some other approach to check the timer
		// When we wanted to do is if current thread is still performing sometime after time is over
		// interrupt the thread
		Thread.sleep(10000);
		if (t.isAlive()) {
			System.out.println("Is alive, trying to interrupt...");
			t.interrupt();

		} else {
			System.out.println("Not alive");
		}
	}
	
	public static class LongInterruption implements Runnable {
		int loopLimit = 0;
		public LongInterruption(int loopLimit) {
			this.loopLimit = loopLimit;
		}

		@Override
		public void run() {
			double sum=0;
			for(double i =0;i<loopLimit;i++)
			{
				sum+=i;
				if (i%1000==0)
				{
				System.out.println("Sum till now at i:"+i +" is:"+sum);
				}
				if(Thread.currentThread().isInterrupted())
				{
					System.out.println("Current thread interrupted as time expires");
					break;
				}
			}
			System.out.println("**********\nFINAL Sum is:"+sum);
		}
		
	}
}
