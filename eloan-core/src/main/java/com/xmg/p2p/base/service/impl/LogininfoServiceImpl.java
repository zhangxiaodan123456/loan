package com.xmg.p2p.base.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.xmg.p2p.base.domain.Logininfo;
import com.xmg.p2p.base.mapper.LogininfoMapper;
import com.xmg.p2p.base.service.ILogininfoService;
import com.xmg.p2p.base.util.MD5;

@Service
public class LogininfoServiceImpl implements ILogininfoService {

	@Autowired
	private LogininfoMapper logininfoMapper;
	@Override
	public void register(String username, String password) {
		// 判断用户名是否存在
		int count = this.logininfoMapper.getCountByUsername(username);
		// 如果不存在,设值并保存这个对象
		if (count <= 0) {
			Logininfo li = new Logininfo();
			li.setUsername(username);
			li.setPassword(MD5.encode(password));
			li.setState(Logininfo.STATE_NORMAL);
			li.setUserType(Logininfo.USER_CLIENT);
			this.logininfoMapper.insert(li);
		} else {
			// 如果存在,直接抛错
			throw new RuntimeException("用户名已经存在!");
		}
	}

	@Override
	public boolean checkUsername(String username) {
		return this.logininfoMapper.getCountByUsername(username) > 0;
	}
}
