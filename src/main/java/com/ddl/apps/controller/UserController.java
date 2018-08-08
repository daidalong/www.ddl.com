package com.ddl.apps.controller;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ddl.apps.model.po.User;
import com.ddl.apps.service.PaService;
import com.ddl.core.json.Dson;

@Controller
@RequestMapping("/user")
public class UserController {
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private PaService paService;

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	@ResponseBody
	public Dson addUser(String name, String mobile) {
		logger.info("into addUser name=" + name + ",mobile=" + mobile);
		Dson dson = new Dson();
		if (StringUtils.isEmpty(name)) {
			dson.put("code", 1);
			dson.setMsg("添加用户失败！原因：用户名为空！");
			return dson;
		}

		if (StringUtils.isEmpty(mobile)) {
			dson.put("code", 1);
			dson.setMsg("添加用户失败！原因：手机号为空！");
			return dson;
		}

		User user = new User();
		user.setName(name);
		user.setMobile(mobile);
		user.setCreateTime(new Date());
		try {
			paService.addUser(user);
			dson.setCode(0);
			dson.setMsg("添加用户成功！");
			dson.setData(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("addUser exception", e);
			dson.setCode(1);
			dson.setMsg("添加用户失败！原因：" + e.getMessage());

		}
		logger.info("exit addUser dson=" + dson);
		return dson;
	}

	@RequestMapping(value = "/get", method = RequestMethod.POST)
	@ResponseBody
	public Dson getUser(String mobile) {
		logger.info("into getUser mobile=" + mobile);
		Dson dson = new Dson();
		if (StringUtils.isEmpty(mobile)) {
			dson.setCode(1);
			dson.setMsg("查询用户失败！原因：手机号为空！");
			return dson;
		}

		User user;
		try {
			user = paService.getUserByMobile(mobile);
			dson.setCode(0);
			dson.setMsg("查询用户成功！");
			dson.setData(user);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getUser exception", e);
			dson.setCode(1);
			dson.setMsg("查询用户失败！原因：" + e.getMessage());
		}
		logger.info("exit getUser dson=" + dson);
		return dson;
	}

	@RequestMapping("/add-list")
	@ResponseBody
	public Dson addUserList(@RequestBody List<User> users) {
		logger.info("into addUserList users=" + users);
		Dson dson = new Dson();
		if (CollectionUtils.isEmpty(users)) {
			dson.setCode(1);
			dson.setMsg("添加用户失败！原因：参数集合为空！");
			return dson;
		}

		try {
			for (User user : users) {
				user.setCreateTime(new Date());
				paService.addUser(user);
			}
			dson.setCode(0);
			dson.setMsg("添加用户集合成功！");
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("addUserList exception", e);
			dson.setCode(1);
			dson.setMsg("添加用户集合失败！原因：" + e.getMessage());
		}
		logger.info("exit addUserList dson=" + dson);
		return dson;
	}

	@RequestMapping(value = "/get-list", method = RequestMethod.POST)
	@ResponseBody
	public Dson getUserList() {
		logger.info("into getUserList");
		Dson dson = new Dson();
		List<User> users = null;
		try {
			users = paService.getAllUserList();
			dson.setCode(0);
			dson.setMsg("查询用户成功！");
			dson.setData(users);
		} catch (Exception e) {
			e.printStackTrace();
			logger.error("getUserList exception", e);
			dson.setCode(1);
			dson.setMsg("查询用户失败！原因：" + e.getMessage());
			dson.setData(users);
		}
		logger.info("into getUserList dson=" + dson);
		return dson;
	}
}