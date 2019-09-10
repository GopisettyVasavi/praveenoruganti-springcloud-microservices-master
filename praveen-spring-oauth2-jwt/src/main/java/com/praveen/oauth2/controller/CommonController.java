package com.praveen.oauth2.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("commons")
public class CommonController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public Map<String, String>getUserData() {
		Map<String, String> map = new HashMap<>();
		map.put("1", "common-value-1");
		map.put("2", "common-value-2");
		return map;
	}
}
 