package com.jingoal.web.redis.sample.test;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.testng.annotations.Test;

import com.jingoal.web.redis.sample.BaseTest;

public class Redis4RedisTemplateTest extends BaseTest {

	@Autowired
	private JedisConnectionFactory jedisConnectionFactory;

	@Test
	public void valueOperationsTest() {
		template.opsForValue().append("firstkey", "firstkey-value");
	}

	@Test
	public void listOperationsTest(){
		template.opsForList().leftPush("", "");
	}
	
	@Test
	public void hashOperationsTest(){
		Map<String, Object> map = new HashMap<>();
		map.put("1", 1);
		map.put("2", 2);
		
		template.boundHashOps("igoal.1.user.2").put("map.1", map);
		template.boundHashOps("igoal.1.user.2").put("map.2", map);
		template.boundHashOps("igoal.1.user.2").put("map.3", map);
		template.boundHashOps("igoal.1.user.2").put("map.4", map);
		
		Set<Object> keys = template.boundHashOps("igoal.1.user.2").keys();
		for (Object key : keys) {
			System.out.println(key);
		}
		
		//template.boundHashOps("igoal.1.user.2").delete("map.1", "map.2");
	}
}
