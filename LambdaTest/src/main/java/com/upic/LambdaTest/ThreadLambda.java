package com.upic.LambdaTest;
/**
 * 
 * @author DTZ
 *
 */
public class ThreadLambda {

	public static void main(String[] args) {
		// 传统的
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Thread");
			}
		}).start();

		new Thread(() -> {
			System.out.println("Lambda Thread");
		}, "ThreadName-1").start();
		
		Runnable r=()->{
			System.out.println("Runnable");
		};
		r.run();
	}
	
	
}
