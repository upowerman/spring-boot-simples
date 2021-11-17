package com.yunus.service.impl;


import com.yunus.mapper.LoginMapper;
import com.yunus.po.User;
import com.yunus.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT,timeout=5)
@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
	LoginMapper loginmapper;
	public String getpwdbyname(String name) {
		User s=loginmapper.getpwdbyname(name);
		if(s!=null)
		return s.getPassword();
		else
		return null;
	}

}
