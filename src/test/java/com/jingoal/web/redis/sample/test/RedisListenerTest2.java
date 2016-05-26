package com.jingoal.web.redis.sample.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

import com.jingoal.web.common.exception.MessageException;
import com.jingoal.web.redis.RedisProducer;
import com.jingoal.web.redis.sample.BaseTest;
import com.jingoal.web.redis.sample.message.UpdateUserMessage;
import com.jingoal.web.redis.sample.model.User;

public class RedisListenerTest2 extends BaseTest {

	@Autowired
	private RedisProducer<User> redisProducer;

	@Test
	public void sendUserUpdateMsgTest() {
		User user = new User();
		user.setUserName("chenbin");
		user.setPassword("12345678");

		UpdateUserMessage uum = new UpdateUserMessage(user);

		for (int i = 0; i < 10; i++) {
			try {
				redisProducer.send(uum);
			} catch (MessageException e) {
				e.printStackTrace();
			}
		}
	}

}
