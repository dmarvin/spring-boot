package com.djm.springbootstart.web;

import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.djm.springbootstart.foo.model.User;

@RestController
public class RedisController {

	private final static Logger LOGGER = LoggerFactory.getLogger(RedisController.class);

	@RequestMapping(value = "/getUser")
	@Cacheable(value="user-key")
	public User getUser(String name) {
		User user = User.builder().name(name).password("111111").build();
		LOGGER.info("获取用户信息,用户:{},密码:{}", user.getName(), user.getPassword());
		return user;
	}

	@RequestMapping(value = "/uid")
	public String uid(HttpSession session) {
		Object uid = session.getAttribute("marvin-id");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("marvin-id", uid);
		return uid.toString();
	}
}
