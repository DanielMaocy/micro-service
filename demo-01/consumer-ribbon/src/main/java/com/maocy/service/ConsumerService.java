package com.maocy.service;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.maocy.entity.User;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCollapser;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;

@Service
public class ConsumerService {

	@Autowired
	RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod="error")
	public String index() {
		String result = restTemplate.getForEntity("http://service-system/index", String.class).getBody();
		return result;
	}
	
	@HystrixCommand(fallbackMethod="error")
	@CacheResult(cacheKeyMethod="getKey")
	public String login(String id) {
		long start = System.currentTimeMillis();
		ResponseEntity<String> responseEntity = restTemplate.getForEntity(
				"http://service-system/login?name={1}&password={2}", String.class, "admin", "123456");
		long end = System.currentTimeMillis();
		System.out.println("耗时：" + (end - start));
		String result = responseEntity.getBody();
		return result;
	}
	
	public String error(String id, Throwable t) {
		System.out.println("异常：" + t.getMessage());
		return "Hello Error ......";
	}
	
	public String getKey(String id) {
		System.out.println("缓存key:" + id);
		return id;
	}
	
	@HystrixCollapser(batchMethod="getUserAll", collapserProperties= {
			@HystrixProperty(name="timerDelayInMilliseconds", value="100")
	})
	public User getUser(String id) {
		User result = restTemplate.getForEntity("http://service-system/user-get?id={1}", User.class, id).getBody();
		System.out.println("getUser == >" + result);
		return result;
	}
	
	@HystrixCommand
	public List<User> getUserAll(List<String> ids) {
		System.out.println("=====" + ids);
		@SuppressWarnings("unchecked")
		List<User> result = restTemplate.getForEntity("http://service-system/user-get-all?ids={1}", List.class, StringUtils.join(ids, ",")).getBody();
		System.out.println("getUserAll == >" + result);
		return result;
	}
}
