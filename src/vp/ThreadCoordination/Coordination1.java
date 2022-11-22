package vp.ThreadCoordination;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Coordination1 {
	
	public static void main(String[] args) throws InterruptedException {
		List<Integer> list = Arrays.asList(100000, 5,10,100,500,5000,900,1);
		List<Factorial> threadList = new ArrayList<Coordination1.Factorial>();
		list.stream().forEach(l -> {
			threadList.add(new Factorial(l));
		});
		
		threadList.stream().forEach(l -> l.start());
		System.out.println("Started all Threads....");
//		Thread.sleep(5);
		/*threadList.stream().forEach(tt->{
			if(tt.isFactorialDone())
			{
				System.out.println("****FACTORIAL FOR "+tt.i + " is: "+tt.getFactorial());
			} else {
				System.out.println("****FACTORIAL FOR "+tt.i + " is not READY");

			}
		});*/
		
		// With above code, it will not wait till threads are finished before checking the is factorial check
		
		
		threadList.stream().forEach(tt->{
			
			try {
				tt.join(1000); //With JOIN it will wait
				// With JOIN we can specify how long it shud wait
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(tt.isFactorialDone())
			{
				System.out.println("****FACTORIAL FOR "+tt.i + " is: "+tt.getFactorial());
			} else {
				System.out.println("****FACTORIAL FOR "+tt.i + " is not READY");

			}
		});
		
	}
	
	private static class Factorial extends Thread {
		public int i = 0;
		private BigInteger factorial;
		private boolean isFactorialDone = false;
		public Factorial(int i) {
			this.i=i;
		}
		@Override
		public void run() {
			System.out.println("FACTORIAL Calculation Started for FOR "+i);
			BigInteger multiplier = BigInteger.valueOf(1);
			for(int b = 1;b<=i;b++)
			{
				multiplier = multiplier.multiply(BigInteger.valueOf(i));
			}
			factorial = multiplier;
			isFactorialDone = true;
//			System.out.println("****FACTORIAL FOR "+i + " is: "+factorial);
		}
		
		public BigInteger getFactorial()
		{
			return factorial;
			
		}
		
		public boolean isFactorialDone() {
			return isFactorialDone;
		}
		
	}
}
