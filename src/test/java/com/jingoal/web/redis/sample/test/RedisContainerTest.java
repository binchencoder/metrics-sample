package com.jingoal.web.redis.sample.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.testng.annotations.Test;

import com.jingoal.web.redis.sample.BaseTest;

public class RedisContainerTest extends BaseTest {

	@Autowired
	private RedisMessageListenerContainer redisContainer;

	// @Test
	public void test() {
		template.boundListOps("chatroom").leftPush("chatroomTest");
	}

}
