package com.djm.springbootstart.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class FooContorller {

	@ResponseBody
	@RequestMapping(value = "/hello")
	public String hello() {
		return "Hello World2";
	}
}
