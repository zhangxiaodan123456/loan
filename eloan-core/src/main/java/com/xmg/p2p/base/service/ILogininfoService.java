package com.xmg.p2p.base.service;


public interface ILogininfoService {
	/**
	 * 用户注册
	 * 
	 * @param username
	 * @param password
	 */
	void register(String username, String password);
	/**
	 * 检查用户名是否存在 如果存在,返回true 如果不存在,返回false
	 * 
	 * @param username
	 * @return
	 */
	boolean checkUsername(String username);
}
