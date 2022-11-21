package vp.ThreadCreation;

public class NewThread2 extends Thread {
	public static void main(String[] args) {
		NewThread2 t = new NewThread2();
		t.start();
	}
	
	@Override
	public void run() {
		System.out.println("Calling this thread" + /*Thread.currentThread().getName()*/  this.getName());
	}
}
