package com.jiang.seven.service.Impl;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.support.TransactionSynchronizationAdapter;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.jiang.seven.dao.UserInfoVoMapper;
import com.jiang.seven.entity.UserInfoVo;
import com.jiang.seven.entity.mongodb.UserInfoRepository;
import com.jiang.seven.interfaces.AfterCommitExecutor;
import com.jiang.seven.service.UserService;

@Service("userService")
//相当于<bean id="userService" ...></bean>
//@Service("userService") junit test 时这样配置
//@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserInfoVoMapper userInfoVoMapper ;
	
	@Autowired
	private AfterCommitExecutor afterCommitExecutor ;
	
	
//	@Autowired
//    private UserInfoRepository userInfoRepository;
	

/*	public UserInfoVoMapper getUserInfoVoMapper() {
		return userInfoVoMapper;
	}
	
	@Autowired
	public void setUserInfoVoMapper(UserInfoVoMapper userInfoVoMapper) {
		this.userInfoVoMapper = userInfoVoMapper;
	}

*/

	@Override
	public UserInfoVo getUserById(String id) {
		// TODO Auto-generated method stub
		return userInfoVoMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<UserInfoVo> getAll() {
		// TODO Auto-generated method stub
		return userInfoVoMapper.getAll();
	}

	@Override
	public List<UserInfoVo> getAll1() {
		// TODO Auto-generated method stub
		return userInfoVoMapper.getAll1();
	}
	/**
	 * 如何在数据库事务提交成功后进行异步操作
	 * 业务场景
		业务需求上经常会有一些边缘操作，比如主流程操作A：用户报名课程操作入库，边缘操作B：发送邮件或短信通知。
		
		业务要求
			操作A操作数据库失败后，事务回滚，那么操作B不能执行。
			操作A执行成功后，操作B也必须执行成功
		如何实现
			普通的执行A，之后执行B，是可以满足要求1，对于要求2通常需要设计补偿的操作
			一般边缘的操作，通常会设置成为异步的，以提升性能，比如发送MQ，业务系统负责事务成功后消息发送成功，然后接收系统负责保证通知成功完成
		本文内容
			如何在spring事务提交之后进行异步操作，这些异步操作必须得在该事务成功提交后才执行，回滚则不执行。
		
		要点
			如何在spring事务提交之后操作
			如何把操作异步化
		实现方案
			使用TransactionSynchronizationManager在事务提交之后操作
	 */
	@Override
	public List<UserInfoVo> getAll2() {
		// TODO Auto-generated method stub
		List<UserInfoVo> userInfoVos = userInfoVoMapper.getAll2();
		// send after tx commit but is async
		// 该方法就可以实现在事务提交之后进行操作
       /* TransactionSynchronizationManager.registerSynchronization(new TransactionSynchronizationAdapter() {
            @Override
            public void afterCommit() {
            	executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("send email after transaction commit...");
                        try {
                            Thread.sleep(10*1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("complete send email after transaction commit...");
                    }
                });
            }
         }
        );*/
		afterCommitExecutor.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("send email after transactioin commit");
            }
        });
//      async work but tx not work, execute even when tx is rollback
//      asyncService.executeAfterTxComplete();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        if(random.nextInt() % 2 ==0){
            throw new RuntimeException("test email transaction");
        }
        System.out.println("service end");
		return userInfoVos;
	}
	/**
	 * 操作异步化
	 * 使用mq或线程池来进行异步，比如使用线程池：
	 * private final ExecutorService executorService = Executors.newFixedThreadPool(5);
	 * 加入线程池进行异步操作
	 * executorService.submit(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("send email after transaction commit...");
                        try {
                            Thread.sleep(10*1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("complete send email after transaction commit...");
                    }
                });
	 * 
	 * 封装以上两步
	 * 对于第二步来说，如果这类方法比较多的话，则写起来重复性太多，因而，抽象出来如下：
	 * 这里改造了azagorneanu的代码:
	 * 
	 * 
	 */
	private final ExecutorService executorService = Executors.newFixedThreadPool(5);
	
	@Override
	public UserInfoVo getUserInfoVoBySelective(String userName) {
		// TODO Auto-generated method stub
		return userInfoVoMapper.getUserInfoVoBySelective(userName);
	}
	
}
