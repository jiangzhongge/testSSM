package com.jiang.seven.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MyRunnable implements Runnable{
	
	private CyclicBarrier barrier ;
	private int[] datas;
	private int start ;
	private int end ;
	
	public MyRunnable(){
		
	}
	
	public MyRunnable(CyclicBarrier barrier,int[] datas,int start ,int end){
		this.barrier = barrier;
		this.datas = datas;
		this.start = start;
		this.end = end;
	}
	
	
	@Override
	public void run() {
		System.out.println(Thread.currentThread().getName());
		// TODO Auto-generated method stub
		try {
			System.out.println(Thread.currentThread().getName()+"------await");
			barrier.await();
			Thread.sleep(4000);
			if(Thread.currentThread().getName().equalsIgnoreCase("pool-1-thread-9")){
				for(int i=0;i<10;i++){
					System.out.println(i);
				}
			}else if(Thread.currentThread().getName().equalsIgnoreCase("pool-1-thread-10")){
				for(int i=0;i<10;i++){
					System.out.println("1"+i);
				}
			}
			System.out.println(Thread.currentThread().getName()+"------begin");
			barrier.await();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

