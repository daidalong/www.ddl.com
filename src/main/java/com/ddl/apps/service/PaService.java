package com.ddl.apps.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ddl.apps.dao.PaDAO;
import com.ddl.apps.model.po.User;

@Service
public class PaService {

	@Autowired
	private PaDAO paDAO;

	public void addUser(User user) throws Exception {
		paDAO.insertUser(user);
	}

	public User getUserByMobile(String mobile) throws Exception {
		return paDAO.getUserByMobile(mobile);
	}

	public List<User> getAllUserList() {
		return paDAO.getAllUserList();
	}
}