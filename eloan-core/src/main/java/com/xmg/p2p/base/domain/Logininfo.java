package com.xmg.p2p.base.domain;

import org.apache.ibatis.type.Alias;

import lombok.Getter;
import lombok.Setter;
@Alias("LoginInfo") //别名
@Setter
@Getter
public class Logininfo extends BaseDomain{
	
	public static final int STATE_NORMAL = 0;// 正常
	public static final int STATE_LOCK = 1;// 锁定

	public static final int USER_MANAGER = 0;// 后台用户
	public static final int USER_CLIENT = 1;// 前台用户
     
    private Long id;

    private String username;

    private String password;

    private int state;
    private int userType;
}