package com.jiang.seven.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class CyclicBarrierTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ThreadPoolExecutor tpPoolExecutor = new ThreadPoolExecutor(10, 20, 60, TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
		// TODO Auto-generated method stub
		int count = 5;
		final CyclicBarrier barrier = new CyclicBarrier(count + 1);
		int[] datas = new int[1020];
		System.out.println(datas.length+"=="+datas[0]+"---"+datas[2]);
		int step = datas.length / count ;
		for(int i=0;i<count;i++){
			int start = i * step ;
			int end = (i+1) * step;
			if(i == count - 1){
				end = datas.length;
			}
			tpPoolExecutor.execute(new MyRunnable(barrier,datas,start,end));
		}
		try {
			System.out.println("结束线程！！！！");
			Thread.sleep(3000);
			System.out.println("waiting ！！！！");
			barrier.await();
			System.out.println("hahha ！！！！");
			barrier.await();
			System.out.println("真的结束线程啦！！！！");
			tpPoolExecutor.shutdown();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
