package com.jingoal.web.redis.sample.test;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.testng.annotations.Test;

import com.jingoal.web.redis.sample.BaseTest;

public class RedisCallbackTest extends BaseTest {

	// @Test
	public void redisCallbackTest() {
		template.execute(new RedisCallback<Object>() {
			public Object doInRedis(RedisConnection connection) throws DataAccessException {
				Long size = connection.dbSize();
				// Can cast to StringRedisConnection if using a
				// StringRedisTemplate
				((StringRedisConnection) connection).set("key", "value");

				return size;
			}
		});
	}

}
