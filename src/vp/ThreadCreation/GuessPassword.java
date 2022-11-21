package vp.ThreadCreation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GuessPassword {
	public static final int MAX_PASSWORD = 9999;
	public static void main(String[] args) {
		Random r = new Random();
		int pwd = r.nextInt(MAX_PASSWORD);
//		System.out.println("Password"+pwd);
		Vault v = new Vault(pwd);
		
		List<Thread> t = new ArrayList<>();
		t.add(new AscendingHackerThread(v));
		t.add(new DescendingHackerThread(v));
		t.add(new PoliceThread());
		
		t.stream().forEach(thread -> thread.start());
	}
	
	private static class Vault {
		private int password;
		
		public Vault(int p) {
			this.password = p;
		}
		public boolean isPasswordCorrect(int guess)
		{
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			return password == guess;
		}
	}

	private static abstract class HackerThread extends Thread
	{
		protected Vault valut;
		
		public HackerThread(Vault valut) {
			this.valut = valut;
			this.setName(this.getClass().getSimpleName());
			this.setPriority(Thread.MAX_PRIORITY);
			}
		
		@Override
		public synchronized void start() {
			System.out.println("Starting Thread " + this.getName());
			super.start();
		}
		
	}

	private static class AscendingHackerThread extends HackerThread
	{

		public AscendingHackerThread(Vault valut) {
			super(valut);
		}
		
		@Override
		public void run() {
			for(int i=0;i<MAX_PASSWORD;i++)
			{
				if(valut.isPasswordCorrect(i))
				{
					System.out.println("Password guessed by "+ this.getName() + " -->"+ i);
					System.exit(0);
				}
			}
		}
	}
	
	private static class DescendingHackerThread extends HackerThread
	{

		public DescendingHackerThread(Vault valut) {
			super(valut);
		}
		
		@Override
		public void run() {
			for(int i=MAX_PASSWORD;i>=0;i--)
			{
				if(valut.isPasswordCorrect(i))
				{
					System.out.println("Password guessed by "+ this.getName() + " -->"+ i);
					System.exit(0);
				}
			}
		}
	}

	private static class PoliceThread extends Thread
	{
		@Override
		public void run() {
			for(int i=10;i>0;i--)
			{
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(i);
			}
			System.out.println("Game over, police caught you!!!");
			System.exit(0);
		}
	}
}


