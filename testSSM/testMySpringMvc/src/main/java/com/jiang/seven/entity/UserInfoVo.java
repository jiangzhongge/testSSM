package com.jiang.seven.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class UserInfoVo implements Serializable{
 
	private static final long serialVersionUID = -3733042763453048048L;

	private String id;

    private Date createTime;

    private Date updateTime;

    private String name;

    private String pwd;
    
	private List<UserRoleInfoVo> userRoles ;

    public List<UserRoleInfoVo> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(List<UserRoleInfoVo> userRoles) {
		this.userRoles = userRoles;
	}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }  
 
}