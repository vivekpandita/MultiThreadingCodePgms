package vp.ThreadCreation;

public class HandleUnCaughtException {
	public static void main(String[] args) {
		Thread t = new Thread(()->{
			throw new RuntimeException("RunTime Exception");
		});
		t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
			
			@Override
			public void uncaughtException(Thread t, Throwable e) {
				System.out.println("Uncaught Exception came here for some post processing/ cleanup");
			}
		});
		t.start();
	}
}
