package com.xmg.p2p.base.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.xmg.p2p.base.service.ILogininfoService;
import com.xmg.p2p.base.util.JSONResult;

/**
 * 用于注册/登陆相关
 * 
 * @author Administrator
 * 
 */
@Controller
public class RegisterController {
	@Autowired
	private ILogininfoService logininfoService;

	@RequestMapping("register")
	@ResponseBody
	public JSONResult register(String username, String password) {
		username="zhangsan";
		password="li";
		JSONResult json = new JSONResult();
		try {
			logininfoService.register(username, password);
		} catch (RuntimeException re) {
			json.setSuccess(false);
			json.setMsg(re.getMessage());
		}
		return json;
	}
	
	
	@RequestMapping("checkUsername")
	@ResponseBody
	public Boolean checkUsername(String username) {
		return !this.logininfoService.checkUsername(username);
	}

}
