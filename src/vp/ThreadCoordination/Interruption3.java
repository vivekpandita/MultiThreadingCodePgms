package vp.ThreadCoordination;

public class Interruption3 extends Interruption2{
	public static void main(String[] args) {
		Thread d = new Thread (new LongInterruption(1000000000));
		// When we set daemon to true, then appn will not
		// wait for d thread to finish before it terminates
		// When set to True, once main Thread task is done appn
		// will immediately terminate without waiting for LongInterruption Task to finish
		d.setDaemon(true);
		d.start();
	}
}
