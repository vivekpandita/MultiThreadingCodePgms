package vp.ThreadCreation;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {

    List<Runnable> tasks;
    public MultiExecutor(List<Runnable> tasks) {
        this.tasks = tasks;
    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
    	this.tasks.forEach((t)->{
    		new Thread(t).start();
    	});
    }
    
    public static void main(String[] args) {
		Runnable t =  new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Executing thread t " + Thread.currentThread().getName());
			}
		};
		
		Runnable t1 =  new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Executing thread t1 " + Thread.currentThread().getName());
			}
		};
		
Runnable t2 =  new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Executing thread t2 " + Thread.currentThread().getName());
			}
		};
		
Runnable t3 =  new Runnable() {
			
			@Override
			public void run() {
				System.out.println("Executing thread t3 " + Thread.currentThread().getName());
			}
		};
		
		List<Runnable> runTasks = new ArrayList<Runnable>();
		runTasks.add(t);
		runTasks.add(t1);
		runTasks.add(t2);
		runTasks.add(t3);
		
		MultiExecutor m = new MultiExecutor(runTasks);
		m.executeAll();
	}
}
