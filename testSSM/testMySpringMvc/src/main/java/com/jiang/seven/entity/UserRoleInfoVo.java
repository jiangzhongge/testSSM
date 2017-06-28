package com.jiang.seven.entity;

public class UserRoleInfoVo {
	
    private String id;

    private String roleId;

    private String userId;
    
    private RoleInfoVo roleInfoVo ;

    public RoleInfoVo getRoleInfoVo() {
		return roleInfoVo;
	}

	public void setRoleInfoVo(RoleInfoVo roleInfoVo) {
		this.roleInfoVo = roleInfoVo;
	}

	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }
}