package com.jiang.seven.othertest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

public class TestVolatileAndAtomicinteger {
	
	private volatile static AtomicInteger atomicInteger = new AtomicInteger();
	
	private static ExecutorService executorService = Executors.newCachedThreadPool();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
		for(int j=0;j<3;j++){
			for(int i=0;i<100;i++){
				int current = atomicInteger.get(); // 取得AtomicInteger里存储的数值
				
				int next = current + 1; // 加1
				if(atomicInteger.compareAndSet(current, next)){
					Runnable thread = new MultiThread(j+"Thread-"+i,i);
					Future future = executorService.submit(thread);	
					if(future!=null){
                        try {
							future.get(3000, TimeUnit.MILLISECONDS);
							if(!future.isDone()){
								System.out.println(j+"==="+i+"取消了");
	                            future.cancel(true);
	                        }
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ExecutionException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (TimeoutException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
                    }
				}
			}
		}
	}
	
	public static class MultiThread implements Runnable{
		
		private String name ;
		private int num ;
		
		public MultiThread(String nameString , int number){
			this.name = nameString ;
			this.num = number ;
		}
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			if(num % 5 == 0){
				System.out.println("线程"+name+"======睡五秒吧====="+"---"+"睡五秒");
				try {
					Thread.sleep(5000);
					System.out.println("线程"+name+"======运行====="+"---"+atomicInteger.get());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}else{
				System.out.println("线程"+name+"======运行====="+"---"+atomicInteger.get());
			}
		}
		
	}

}
